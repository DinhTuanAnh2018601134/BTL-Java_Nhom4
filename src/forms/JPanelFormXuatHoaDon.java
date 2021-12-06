/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.DienThoai;
import classes.DienThoaiDaBan;
import classes.KhachHang;
import classes.NhanVien;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author tuananh
 */
public class JPanelFormXuatHoaDon extends javax.swing.JPanel {

    private Calendar cal = Calendar.getInstance();
    private String year = "" + cal.get(Calendar.YEAR);
    private String month = "" + (cal.get(Calendar.MONTH) + 1);
    private String date = "" + cal.get(Calendar.DATE);
    private String hour = "" + cal.get(Calendar.HOUR);
    private String minute = "" + cal.get(Calendar.MINUTE);
    private String second = "" + cal.get(Calendar.SECOND);

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Phones;"
            + "integratedSecurity=true";
    private static String USER_NAME = "tuananh";
    private static String PASSWORD = "";
    private static Connection conn;
    private static Statement stmt;

    private ArrayList<NhanVien> dsnv = new ArrayList<>();
    private ArrayList<KhachHang> dskh = new ArrayList<>();
    private ArrayList<DienThoai> dsdt = new ArrayList<>();
    private ArrayList<DienThoaiDaBan> dsdtb = new ArrayList<>();
    
    private int i;

    /**
     * Creates new form JPanelFormXuatHoaDon
     */
    public JPanelFormXuatHoaDon() {
        initComponents();
        initData();
    }

    private void initData() {
        txtMaHoaDon.disable();
        txtNgaylap.disable();
        txtMaNhanVien.disable();
        txtTenNhanVien.disable();
        txtTenKhachHang.disable();
        txtDiaChi.disable();
        txtSDT.disable();
        txtTenDienThoai.disable();
        txtGiaBan.disable();

        txtMaHoaDon.setText("HD" + date + month + year + hour + minute + second);
        txtNgaylap.setText(year + "-" + month + "-" + date);
        txtMaNhanVien.setText("KT001");
        txtTenNhanVien.setText("");
        getKhachHang();
        getDienThoai();
    }
//    private void getNhanVien(){
//         try {
//             // connnect to database 'phones'
//            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
//            // crate statement
//            stmt = conn.createStatement();
//            // get data from table 'nha vien'
//            ResultSet rs = stmt.executeQuery("select MaNV,TenNV from NhanVien");
//            Vector data = new Vector();
//            DefaultComboBoxModel cmbModel = null;
//            // show data
//            while (rs.next()) {
//                NhanVien nv = new NhanVien();
//                nv.setMaNV(rs.getString(1));
//                nv.setTenNV(rs.getString(2));
//                dsnv.add(nv);
//                data.add(rs.getString(1));
//                cmbModel = new DefaultComboBoxModel(data);
//                cbMaNhanVien.setModel(cmbModel);
//            }
//            // close connection
//            conn.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    private void getKhachHang() {
        try {
            // connnect to database 'phones'
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            stmt = conn.createStatement();
            // get data from table 'nha vien'
            ResultSet rs = stmt.executeQuery("select MaKH,TenKH,DiaChi,SDT from KhachHang");
            Vector data = new Vector();
            DefaultComboBoxModel cmbModel = null;
            // show data
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setDiaChi(rs.getString(3));
                kh.setSdt(rs.getString(4));
                dskh.add(kh);
                data.add(rs.getString(1));
                cmbModel = new DefaultComboBoxModel(data);
                cbMaKhachHang.setModel(cmbModel);
            }
            for (KhachHang kh : dskh) {
                if (kh.getMaKH().equals(cbMaKhachHang.getSelectedItem())) {
                    txtTenKhachHang.setText(kh.getTenKH());
                    txtDiaChi.setText(kh.getDiaChi());
                    txtSDT.setText(kh.getSdt());
                    break;
                }
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getDienThoai() {
        try {
            // connnect to database 'phones'
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            stmt = conn.createStatement();
            // get data from table 'nha vien'
            ResultSet rs = stmt.executeQuery("select MaDT,TenDT,SoLuong,GiaBan from DienThoai");
            Vector data = new Vector();
            DefaultComboBoxModel cmbModel = null;
            // show data
            while (rs.next()) {
                DienThoai dt = new DienThoai();
                dt.setMaDT(rs.getString(1));
                dt.setTenDT(rs.getString(2));
                dt.setSoLuong(Integer.parseInt(rs.getString(3)));
                dt.setGiaBan(Integer.parseInt(rs.getString(4)));
                dsdt.add(dt);
                data.add(rs.getString(1));
                cmbModel = new DefaultComboBoxModel(data);
                cbMaDienThoai.setModel(cmbModel);
            }

            for (DienThoai dt : dsdt) {
                if (dt.getMaDT().equals(cbMaDienThoai.getSelectedItem())) {
                    txtTenDienThoai.setText(dt.getTenDT());
                    txtGiaBan.setText(dt.getGiaBan() + "");
                    break;
                }
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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
        txtMaHoaDon = new javax.swing.JTextField();
        txtNgaylap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenDienThoai = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSoLuongBan = new javax.swing.JTextField();
        cbMaDienThoai = new javax.swing.JComboBox<>();
        cbMaKhachHang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDienThoaiBan = new javax.swing.JTable();
        btnHuyHoaDon = new javax.swing.JButton();
        btnThemDienThoai = new javax.swing.JButton();
        btnXoaDienThoai = new javax.swing.JButton();
        btnThemHoaDon = new javax.swing.JButton();
        txtTenNhanVien = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(900, 600));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Xuất Hóa Đơn");
        add(jLabel1);
        jLabel1.setBounds(390, 10, 170, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã Hóa Đơn ");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel2);
        jLabel2.setBounds(10, 60, 120, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Ngày Lập");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel3);
        jLabel3.setBounds(10, 100, 65, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Mã Nhân Viên");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel4);
        jLabel4.setBounds(10, 140, 95, 17);

        txtMaHoaDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtMaHoaDon);
        txtMaHoaDon.setBounds(120, 50, 160, 30);

        txtNgaylap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtNgaylap);
        txtNgaylap.setBounds(120, 90, 160, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mã Khách Hàng");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel5);
        jLabel5.setBounds(300, 60, 120, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tên Khách Hàng");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel6);
        jLabel6.setBounds(300, 100, 114, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Địa Chỉ");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel7);
        jLabel7.setBounds(300, 140, 48, 17);

        txtTenKhachHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtTenKhachHang);
        txtTenKhachHang.setBounds(420, 90, 160, 30);

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtDiaChi);
        txtDiaChi.setBounds(420, 130, 160, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Mã Điện Thoại");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel8);
        jLabel8.setBounds(600, 60, 120, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tên Điện Thoại");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel9);
        jLabel9.setBounds(600, 100, 103, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Giá Bán");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel10);
        jLabel10.setBounds(600, 140, 52, 17);

        txtTenDienThoai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtTenDienThoai);
        txtTenDienThoai.setBounds(720, 90, 160, 30);

        txtGiaBan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtGiaBan);
        txtGiaBan.setBounds(720, 130, 160, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Tên Nhân Viên");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel11);
        jLabel11.setBounds(10, 180, 101, 17);

        txtMaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtMaNhanVien);
        txtMaNhanVien.setBounds(120, 130, 160, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Sô Điện Thoại");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel12);
        jLabel12.setBounds(300, 180, 100, 17);

        txtSDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtSDT);
        txtSDT.setBounds(420, 170, 160, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Số Lượng");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel13);
        jLabel13.setBounds(600, 180, 70, 17);

        txtSoLuongBan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtSoLuongBan);
        txtSoLuongBan.setBounds(720, 170, 160, 30);

        cbMaDienThoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaDienThoaiActionPerformed(evt);
            }
        });
        add(cbMaDienThoai);
        cbMaDienThoai.setBounds(720, 50, 160, 30);

        cbMaKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaKhachHangActionPerformed(evt);
            }
        });
        add(cbMaKhachHang);
        cbMaKhachHang.setBounds(420, 50, 160, 30);

        tblDienThoaiBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Điện Thoại", "Tên Điện Thoại", "Số Lượng", "Giá Bán", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDienThoaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDienThoaiBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDienThoaiBan);

        add(jScrollPane1);
        jScrollPane1.setBounds(120, 310, 660, 290);

        btnHuyHoaDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHuyHoaDon.setText("Hủy Hóa Đơn");
        add(btnHuyHoaDon);
        btnHuyHoaDon.setBounds(540, 260, 160, 30);

        btnThemDienThoai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemDienThoai.setText("Thêm Điện Thoại");
        btnThemDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDienThoaiActionPerformed(evt);
            }
        });
        add(btnThemDienThoai);
        btnThemDienThoai.setBounds(720, 220, 160, 30);

        btnXoaDienThoai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoaDienThoai.setText("Xóa Điện Thoại");
        btnXoaDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDienThoaiActionPerformed(evt);
            }
        });
        add(btnXoaDienThoai);
        btnXoaDienThoai.setBounds(720, 260, 160, 30);

        btnThemHoaDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemHoaDon.setText("Thêm Hóa Đơn");
        add(btnThemHoaDon);
        btnThemHoaDon.setBounds(540, 220, 160, 30);

        txtTenNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtTenNhanVien);
        txtTenNhanVien.setBounds(120, 170, 160, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void cbMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaKhachHangActionPerformed
        for (KhachHang kh : dskh) {
            if (kh.getMaKH().equals(cbMaKhachHang.getSelectedItem())) {
                txtTenKhachHang.setText(kh.getTenKH());
                txtDiaChi.setText(kh.getDiaChi());
                txtSDT.setText(kh.getSdt());
                break;
            }
        }
    }//GEN-LAST:event_cbMaKhachHangActionPerformed

    private void cbMaDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaDienThoaiActionPerformed
        for (DienThoai dt : dsdt) {
            if (dt.getMaDT().equals(cbMaDienThoai.getSelectedItem())) {
                txtTenDienThoai.setText(dt.getTenDT());
                txtGiaBan.setText(dt.getGiaBan() + "");
                txtSoLuongBan.setText("");
                break;
            }
        }
    }//GEN-LAST:event_cbMaDienThoaiActionPerformed

    private void btnThemDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDienThoaiActionPerformed
        if (!txtSoLuongBan.getText().equals("")) {
            DienThoaiDaBan dtdb = new DienThoaiDaBan();
            dtdb.setMaDT((String) cbMaDienThoai.getSelectedItem());
            dtdb.setTenDT(txtTenDienThoai.getText());
            dtdb.setGiaBan(Integer.parseInt(txtGiaBan.getText()));
            dtdb.setSoLuong(Integer.parseInt(txtSoLuongBan.getText()));
            dsdtb.add(dtdb);
            HienThiDanhSachDTDB();
        }
    }//GEN-LAST:event_btnThemDienThoaiActionPerformed
    private void HienThiDanhSachDTDB() {
        try {
            // show data
            DefaultTableModel tblModel = null;
            String header[] = {"STT", "Mã Điện Thoại", "Tên Điện Thoại", "Số Lượng", "Giá Bán", "Thành Tiền"};
            tblModel = new DefaultTableModel(header, 0);
            Vector data = null;
            int stt = 1;
            for (DienThoaiDaBan dt : dsdtb) {
                data = new Vector();
                int thanhTien = dt.getGiaBan() * dt.getSoLuong();
                data.add(stt);
                data.add(dt.getMaDT());
                data.add(dt.getTenDT());
                data.add(dt.getSoLuong());
                data.add(dt.getGiaBan());
                data.add(thanhTien + "");
                tblModel.addRow(data);
                stt++;
            }
            tblDienThoaiBan.setModel(tblModel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void btnXoaDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDienThoaiActionPerformed
        if(dsdtb.size() > 0){
            dsdtb.remove(i);
            HienThiDanhSachDTDB();
        }
    }//GEN-LAST:event_btnXoaDienThoaiActionPerformed

    private void tblDienThoaiBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDienThoaiBanMouseClicked
        i = tblDienThoaiBan.getSelectedRow();
    }//GEN-LAST:event_tblDienThoaiBanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnThemDienThoai;
    private javax.swing.JButton btnThemHoaDon;
    private javax.swing.JButton btnXoaDienThoai;
    private javax.swing.JComboBox<String> cbMaDienThoai;
    private javax.swing.JComboBox<String> cbMaKhachHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDienThoaiBan;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgaylap;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuongBan;
    private javax.swing.JTextField txtTenDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables

}
