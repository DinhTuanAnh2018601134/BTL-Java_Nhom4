/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

/**
 *
 * @author tuananh
 */
public class JPanelFormQLNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form JPanelFormQLNhanVien
     */
    public JPanelFormQLNhanVien() {
        initComponents();
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
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(900, 600));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");
        add(jLabel1);
        jLabel1.setBounds(335, 6, 380, 29);

        jTextField2.setName("txtManhanvien"); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(210, 100, 160, 20);

        jTextField3.setName("txtTennhanvien"); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(210, 140, 160, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jComboBox2.setName("cbxGioitinh"); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        add(jComboBox2);
        jComboBox2.setBounds(210, 180, 160, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bán hàng", "Thu ngân" }));
        jComboBox1.setName("cbxChucvu"); // NOI18N
        add(jComboBox1);
        jComboBox1.setBounds(210, 220, 160, 20);

        jTextField1.setName("txtLuong"); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(510, 220, 160, 20);

        jTextField6.setName("txtEmail"); // NOI18N
        add(jTextField6);
        jTextField6.setBounds(510, 180, 160, 20);

        jTextField5.setName("txtSDT"); // NOI18N
        add(jTextField5);
        jTextField5.setBounds(510, 140, 160, 20);

        jTextField4.setName("txtDiachi"); // NOI18N
        add(jTextField4);
        jTextField4.setBounds(510, 100, 160, 20);

        jButton2.setText("Thêm");
        jButton2.setName("btnThem"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(700, 100, 90, 23);

        jButton3.setText("Cập Nhập");
        jButton3.setName("btnCapnhap"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(700, 140, 90, 23);

        jButton4.setText("Xóa");
        jButton4.setName("btnXoa"); // NOI18N
        add(jButton4);
        jButton4.setBounds(700, 180, 90, 23);

        jButton1.setText("Xuất File");
        jButton1.setName("btnXuatfile"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(700, 220, 90, 23);

        jLabel2.setText("Mã Nhân Viên");
        add(jLabel2);
        jLabel2.setBounds(130, 100, 80, 20);

        jLabel4.setText("Tên Nhân Viên");
        add(jLabel4);
        jLabel4.setBounds(130, 140, 80, 20);

        jLabel3.setText("Giới Tinh");
        add(jLabel3);
        jLabel3.setBounds(130, 180, 80, 20);

        jLabel6.setText("Chức Vụ");
        add(jLabel6);
        jLabel6.setBounds(130, 220, 80, 20);

        jLabel7.setText("Địa Chỉ");
        add(jLabel7);
        jLabel7.setBounds(460, 100, 50, 20);

        jLabel8.setText("SDT");
        add(jLabel8);
        jLabel8.setBounds(460, 140, 50, 20);

        jLabel9.setText("Email");
        add(jLabel9);
        jLabel9.setBounds(460, 180, 50, 20);

        jLabel5.setText("Lương");
        add(jLabel5);
        jLabel5.setBounds(460, 220, 50, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        jComboBox3.setName("cbxAll"); // NOI18N
        add(jComboBox3);
        jComboBox3.setBounds(170, 290, 90, 25);

        jButton6.setText("Lọc");
        jButton6.setToolTipText("");
        jButton6.setName("btnLoc"); // NOI18N
        add(jButton6);
        jButton6.setBounds(100, 290, 70, 25);

        jTextField7.setText("Nhập tên nhân viên cần tìm");
        jTextField7.setName("txtTimkiem"); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        add(jTextField7);
        jTextField7.setBounds(370, 290, 230, 25);

        jButton5.setText("Tìm kiếm");
        jButton5.setToolTipText("");
        jButton5.setName("btnTimkiem"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(600, 290, 90, 25);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nhân Viên", "Giới Tính", "Chức Vụ", "Địa Chỉ", "SĐT", "Email", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setName("tblNhanvien"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 340, 820, 240);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
