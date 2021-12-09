package forms;

import classes.HoaDon;
import connect.ConnectToSQL;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPaneFormQLHoaDon extends javax.swing.JPanel {
    ConnectToSQL sql = new ConnectToSQL();
    private final String DB_URL = sql.DB_URL;
    private final String USER_NAME = sql.USER_NAME;
    private final String PASSWORD = sql.PASSWORD;
    private  Connection conn;
    private  Statement stmt;
    private final ArrayList<HoaDon> dshd = new ArrayList<>();

    /**
     * Creates new form JPaneFormQLHoaDonl
     */
    public JPaneFormQLHoaDon() {
        initComponents();
        getDanhSach();
        HienThiDanhSach(dshd);
    }

    //Lấy ds từ csdl vào mảng 
    private void getDanhSach() {
        try {
            // connnect to database 'phones'
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            stmt = conn.createStatement();
            // get data from table 'hoa don'
            ResultSet rs = stmt.executeQuery("select MaHD,NgayLap,HoaDon.MaNV,TenNV,HoaDon.MaKH,TenKH from HoaDon "
                    + "inner join KhachHang on HoaDon.MaKH = KhachHang.MaKH "
                    + "inner join NhanVien on HoaDon.MaNV = NhanVien.MaNV");
            // show data
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setNgayLap(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setTenNV(rs.getString(4));
                hd.setMaKH(rs.getString(5));
                hd.setTenKH(rs.getString(6));
                dshd.add(hd);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //hiển thị ds từ mảng ra bảng
    private void HienThiDanhSach(ArrayList<HoaDon> dshd) {
        try {
            // show data
            DefaultTableModel tblModel = null;
            String header[] = {"ID", "Ngày Lập", "Mã Nhân Viên", "Tên Nhân Viên", "Mã Khách Hàng", "Tên Khách Hàng", ""};
            tblModel = new DefaultTableModel(header, 0);
            Vector data = null;
            for (HoaDon hd : dshd) {
                data = new Vector();
                data.add(hd.getMaHD());
                data.add(hd.getNgayLap());
                data.add(hd.getMaNV());
                data.add(hd.getTenNV());
                data.add(hd.getMaKH());
                data.add(hd.getTenKH());
                data.add("");
                tblModel.addRow(data);
            }
            jTableHoaDon.setModel(tblModel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //click vao bảng thì hiện dữ liệu lên textbox
    private void HienThiChiTiet(int selectedIndex) {
        txtMaHoaDon.setText(dshd.get(selectedIndex).getMaHD());
        txtNgaylap.setText(dshd.get(selectedIndex).getNgayLap());
        txtMaNhanVien.setText(dshd.get(selectedIndex).getMaNV());
        txtTenNhanVien.setText(dshd.get(selectedIndex).getTenNV());
        txtMaKhachHang.setText(dshd.get(selectedIndex).getMaKH());
        txtTenKhachHang.setText(dshd.get(selectedIndex).getTenKH());
    }
    //hien thi danh sach tim kiem len bang
    private void HienThiTimKiem(String maHD) {
        ArrayList<HoaDon> dshdtk = new ArrayList<>();
        for (HoaDon hd : dshd) {
            if (maHD.equalsIgnoreCase(hd.getMaHD().trim())) {
                dshdtk.add(hd);
                break;
            }
        }
        HienThiDanhSach(dshdtk);
    }
    //xóa hóa đơn khỏi mảng
    private void XoaHoaDon(String maHD) {
        for (HoaDon hd : dshd) {
            if (maHD.equals(hd.getMaHD())) {
                dshd.remove(hd);
                break;
            }
        }
    }
    //xóa hóa đơn khỏi csdl
    private void XoaHoaDonCSDL(String maHD) {
        try {
            // connnect to database 'testdb'
            conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            stmt = conn.createStatement();
            String strSql = "delete from ChiTietHoaDon where MaHD='" + maHD +"'";
            stmt.executeUpdate(strSql);
            strSql = "delete from HoaDon where MaHD='" + maHD +"'";
            stmt.executeUpdate(strSql);
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //clear textbox
    private void ClearTextbox() {
        txtMaHoaDon.setText("");
        txtNgaylap.setText("");
        txtMaNhanVien.setText("");
        txtTenNhanVien.setText("");
        txtMaKhachHang.setText("");
        txtTenKhachHang.setText("");
        txtMaHoaDon.requestFocus(true);
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
        txtMaNhanVien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHoaDon = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        btnXuatHoaDon = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnLoc = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Hóa Đơn");
        add(jLabel1);
        jLabel1.setBounds(335, 6, 250, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Mã Hóa Đơn ");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel2);
        jLabel2.setBounds(10, 60, 120, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Ngày Lập");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel3);
        jLabel3.setBounds(10, 100, 83, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Mã Nhân Viên");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel4);
        jLabel4.setBounds(10, 140, 126, 22);

        txtMaHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtMaHoaDon);
        txtMaHoaDon.setBounds(150, 60, 190, 28);

        txtNgaylap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtNgaylap);
        txtNgaylap.setBounds(150, 100, 190, 28);

        txtMaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtMaNhanVien);
        txtMaNhanVien.setBounds(150, 140, 190, 28);

        jTableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ngày Lập", "Mã Nhân Viên", "Tên Nhân Viên", "Mã Khách Hàng", "Tên Khách Hàng", "Thêm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHoaDon);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 262, 900, 340);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Tên Nhân Viên");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel5);
        jLabel5.setBounds(350, 60, 140, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Mã Khách Hàng");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel6);
        jLabel6.setBounds(350, 100, 150, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Tên Khách Hàng");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel7);
        jLabel7.setBounds(350, 140, 150, 22);

        txtTenNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtTenNhanVien);
        txtTenNhanVien.setBounds(510, 60, 190, 28);

        txtMaKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtMaKhachHang);
        txtMaKhachHang.setBounds(510, 100, 190, 28);

        txtTenKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtTenKhachHang);
        txtTenKhachHang.setBounds(510, 140, 190, 28);

        btnXuatHoaDon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXuatHoaDon.setText("Sửa Hóa Đơn");
        btnXuatHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });
        add(btnXuatHoaDon);
        btnXuatHoaDon.setBounds(720, 60, 170, 31);

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa);
        btnXoa.setBounds(720, 100, 170, 31);

        btnXuatFile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXuatFile.setText("Xuất File");
        btnXuatFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnXuatFile);
        btnXuatFile.setBounds(720, 140, 170, 31);

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        add(btnTimKiem);
        btnTimKiem.setBounds(410, 230, 117, 27);

        txtTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTim.setText("Nhập mã hóa đơn cần tìm");
        txtTim.setToolTipText("");
        txtTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimMouseClicked(evt);
            }
        });
        add(txtTim);
        txtTim.setBounds(240, 230, 170, 27);

        btnLoc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnLoc);
        btnLoc.setBounds(160, 230, 80, 27);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        add(jFormattedTextField1);
        jFormattedTextField1.setBounds(10, 230, 150, 27);
    }// </editor-fold>//GEN-END:initComponents
    //sự liện click vào bảng
    private void jTableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHoaDonMouseClicked
        int selectedIndex = jTableHoaDon.getSelectedRow();
        HienThiChiTiet(selectedIndex);
    }//GEN-LAST:event_jTableHoaDonMouseClicked
    //click nut tìm kiếm
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String id = txtTim.getText();
        if (id.equals("")) {
            HienThiDanhSach(dshd);
        } else {
            HienThiTimKiem(id);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed
    
    private void txtTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimMouseClicked
        txtTim.setText("");
    }//GEN-LAST:event_txtTimMouseClicked
    //click nút xóa hóa đơn
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String id = txtMaHoaDon.getText();
        XoaHoaDon(id);
        ClearTextbox();
        HienThiDanhSach(dshd);
        XoaHoaDonCSDL(id);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableHoaDon;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgaylap;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
