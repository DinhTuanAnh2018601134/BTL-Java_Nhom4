/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.KhachHang;
import connect.ConnectToSQL;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author tuananh
 */
public class JPanelFormQLKhachHang extends javax.swing.JPanel {

    ConnectToSQL sql = new ConnectToSQL();
    private final String DB_URL = sql.DB_URL;
    private final String USER_NAME = sql.USER_NAME;
    private final String PASSWORD = sql.PASSWORD;
    private Connection conn;
    private Statement stmt;
    private final ArrayList<KhachHang> dskh = new ArrayList<>();
//    Vector<String> gt = new Vector<>();

    /**
     * Creates new form JPanelFormQLKhachHang
     */
    public JPanelFormQLKhachHang() {
        initComponents();
//        loadCB();
        getDanhSanhKhachHang();
        HienThiDanhSachKhachHang(dskh);
    }

    private void ClearTextbox() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        cbGioiTinh.setSelectedIndex(0);
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtMaKH.requestFocus(true);
    }

    private void getDanhSanhKhachHang() {
        try {
            // connnect to database 'phones'
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            stmt = conn.createStatement();
            // get data from table 'hoa don'
            ResultSet rs = stmt.executeQuery("select * from KhachHang");
            // show data
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setGioitinh(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setEmail(rs.getString(6));

                dskh.add(kh);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void HienThiDanhSachKhachHang(ArrayList<KhachHang> dskh) {
        try {
            // show data
            DefaultTableModel tblModel = null;
            String header[] = {"M?? Kh??ch H??ng", "T??n Kh??ch H??ng", "Gi???i t??nh", "?????a Ch???", "SDT", "Email"};
            tblModel = new DefaultTableModel(header, 0);
            Vector data = null;
            for (KhachHang kh : dskh) {
                data = new Vector();
                data.add(0, kh.getMaKH());
                data.add(1, kh.getTenKH());
                data.add(2, kh.getGioitinh());
                data.add(3, kh.getDiaChi());
                data.add(4, kh.getSdt());
                data.add(5, kh.getEmail());
                tblModel.addRow(data);
            }
            jTableQLKH.setModel(tblModel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void seachKH() {
        ArrayList<KhachHang> listKh = new ArrayList<>();
        String tenKH = txtTim.getText();
        int d = 0;
        for (KhachHang khachHang : dskh) {
            if (tenKH.equalsIgnoreCase(khachHang.getTenKH().trim())) {
                d++;
                listKh.add(khachHang);
            }
        }
            HienThiDanhSachKhachHang(listKh);
        
    }

    private void deleteKH() {
        String maKH = txtMaKH.getText();
        KhachHang kh = new KhachHang(maKH);
        if (dskh.contains(kh)) {
            int result = JOptionPane.showConfirmDialog(null,
                    "B???n c?? ch???c mu???n x??a kh??ch h??ng n??y",
                    "X??c nh???n",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                dskh.remove(kh);
                try {
                    conn = getConnection(DB_URL, USER_NAME, PASSWORD);
                    stmt = conn.createStatement();
                    // x??a d??? li???u cho b???ng kh??ch h??ng
                    String sql = "DELETE FROM KhachHang WHERE MaKH='" + maKH + "'";
                    stmt.executeUpdate(sql);
                    conn.close();
                } catch (Exception ex) {
                    Logger.getLogger(JPanelFormQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else {

            JOptionPane.showMessageDialog(null, "Kh??ng c?? kh??ch h??ng n??y", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
        }
        HienThiDanhSachKhachHang(dskh);

    }

    private void updateKH() {

        String maKH = txtMaKH.getText();
        String tenKH = txtTenKH.getText();
        String gioTinh = (String) cbGioiTinh.getSelectedItem();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String email = txtEmail.getText();
        KhachHang kh = new KhachHang(maKH);

        if (dskh.contains(kh)) {
            int index = dskh.indexOf(kh);
            kh = dskh.get(index);
            kh = new KhachHang(kh.getMaKH(), tenKH, gioTinh, diaChi, sdt, email);
            dskh.set(index, kh);
            try {
                conn = getConnection(DB_URL, USER_NAME, PASSWORD);
                stmt = conn.createStatement();
                // Them d??? li???u cho b???ng kh??ch h??ng
                String sql = "UPDATE KhachHang SET TenKH=N'" + tenKH + "',GioiTinh=N'" + gioTinh + "',DiaChi=N'" + diaChi + "',SDT='" + sdt + "',Email='" + email
                        + "' WHERE MaKH='" + maKH + "'";
                stmt.executeUpdate(sql);
                conn.close();
                JOptionPane.showMessageDialog(null, "Update th??ng tin kh??ch h??ng " + kh.getMaKH() + " th??nh c??ng !", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(JPanelFormQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kh??ng c?? kh??ch h??ng n??y", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
        }
        HienThiDanhSachKhachHang(dskh);
    }

    private void ThemKH() {

        String maKH = txtMaKH.getText();
        String tenKH = txtTenKH.getText();
        String gioTinh = (String) cbGioiTinh.getSelectedItem();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String email = txtEmail.getText();
        KhachHang kh = new KhachHang(maKH);
        if (dskh.contains(kh)) {
            JOptionPane.showMessageDialog(null, "M?? kh??ch h??ng ???? t???n t???i", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
        } else {
            kh = new KhachHang(maKH, tenKH, gioTinh, diaChi, sdt, email);
            dskh.add(kh);
            try {
                conn = getConnection(DB_URL, USER_NAME, PASSWORD);
                stmt = conn.createStatement();
                // Them d??? li???u cho b???ng kh??ch h??ng
                String sql = "insert into KhachHang values('" + maKH + "'" + ",N'" + tenKH + "',N'" + gioTinh + "',N'" + diaChi + "','" + sdt + "','" + email + "')";
                stmt.executeUpdate(sql);
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(JPanelFormQLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

//    private void loadCB() {
//        gt.add(0, "Nam");
//        gt.add(1, "N???");
//        cbGioiTinh.setModel(new DefaultComboBoxModel(gt));
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbGioiTinh = new javax.swing.JComboBox<>();
        txtTenKH = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXuaFile = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        cbLoc = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableQLKH = new javax.swing.JTable();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(900, 600));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Qu???n L?? Kh??ch H??ng");
        add(jLabel1);
        jLabel1.setBounds(335, 6, 250, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("M?? Kh??ch H??ng");
        add(jLabel2);
        jLabel2.setBounds(10, 60, 130, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("T??n Kh??ch H??ng");
        add(jLabel3);
        jLabel3.setBounds(10, 100, 140, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Gi???i T??nh");
        add(jLabel4);
        jLabel4.setBounds(10, 140, 73, 20);

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "N???" }));
        add(cbGioiTinh);
        cbGioiTinh.setBounds(150, 140, 190, 25);

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(txtTenKH);
        txtTenKH.setBounds(150, 100, 190, 30);

        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(txtMaKH);
        txtMaKH.setBounds(150, 60, 190, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("?????a Ch???");
        add(jLabel5);
        jLabel5.setBounds(430, 60, 70, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("S??T");
        add(jLabel6);
        jLabel6.setBounds(430, 100, 70, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Email");
        add(jLabel7);
        jLabel7.setBounds(430, 140, 70, 20);

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(txtEmail);
        txtEmail.setBounds(510, 140, 190, 30);

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThem.setText("Th??m");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem);
        btnThem.setBounds(720, 60, 160, 29);

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCapNhat.setText("C???p Nh???t");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        add(btnCapNhat);
        btnCapNhat.setBounds(720, 100, 160, 29);

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXoa.setText("X??a");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa);
        btnXoa.setBounds(720, 140, 160, 29);

        btnXuaFile.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXuaFile.setText("Xu???t File");
        add(btnXuaFile);
        btnXuaFile.setBounds(720, 180, 160, 29);

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTimKiem.setText("T??m Ki???m");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        add(btnTimKiem);
        btnTimKiem.setBounds(450, 230, 109, 27);

        txtTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTim.setText("Nh???p T??n Kh??ch H??ng C???n T??m");
        txtTim.setToolTipText("");
        add(txtTim);
        txtTim.setBounds(240, 230, 200, 27);

        cbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL" }));
        add(cbLoc);
        cbLoc.setBounds(100, 230, 120, 27);

        btnLoc.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLoc.setText("L???c");
        add(btnLoc);
        btnLoc.setBounds(10, 230, 80, 27);

        jTableQLKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "M?? Kh??ch H??ng", "T??n Kh??ch H??ng", "Gi???i T??nh", "?????a Ch???", "S??? ??i???n Tho???i", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableQLKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableQLKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableQLKH);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 260, 900, 340);

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(txtDiaChi);
        txtDiaChi.setBounds(510, 60, 190, 30);

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(txtSDT);
        txtSDT.setBounds(510, 100, 190, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ThemKH();// TODO add your handling code here:
        HienThiDanhSachKhachHang(dskh);
        ClearTextbox();
    }//GEN-LAST:event_btnThemActionPerformed

    private void jTableQLKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableQLKHMouseClicked
        // TODO add your handling code here:
        int selectRow = jTableQLKH.getSelectedRow();
        KhachHang kh = new KhachHang();
        kh = dskh.get(selectRow);
        txtMaKH.setText(kh.getMaKH());
        txtTenKH.setText(kh.getTenKH());
        if (kh.getGioitinh().equalsIgnoreCase("Nam")) {
            cbGioiTinh.setSelectedIndex(0);
        } else {
            cbGioiTinh.setSelectedIndex(1);
        }
        txtDiaChi.setText(kh.getDiaChi());
        txtSDT.setText(kh.getSdt());
        txtEmail.setText(kh.getEmail());


    }//GEN-LAST:event_jTableQLKHMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        updateKH();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        deleteKH(); // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        seachKH();// TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuaFile;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableQLKH;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
