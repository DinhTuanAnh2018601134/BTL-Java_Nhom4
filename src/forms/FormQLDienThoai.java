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
public class FormQLDienThoai extends javax.swing.JFrame {

    /**
     * Creates new form FormQLDienThoai
     */
    public FormQLDienThoai() {
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

        jPanelQLDT = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        jPanelQLDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelQLDT.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Điện Thoại");
        jPanelQLDT.add(jLabel1);
        jLabel1.setBounds(335, 6, 280, 29);

        jLabel2.setText("Mã điện thoại");
        jPanelQLDT.add(jLabel2);
        jLabel2.setBounds(30, 70, 64, 14);
        jLabel2.getAccessibleContext().setAccessibleName("jlabel2"); // NOI18N

        jScrollPane1.setViewportView(jTextPane1);

        jPanelQLDT.add(jScrollPane1);
        jScrollPane1.setBounds(110, 70, 130, 22);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iphone", "Samsung", "BKAV" }));
        jPanelQLDT.add(jComboBox1);
        jComboBox1.setBounds(110, 110, 130, 20);

        jLabel3.setText("ROM");
        jPanelQLDT.add(jLabel3);
        jLabel3.setBounds(270, 160, 23, 14);

        jLabel4.setText("Gía bán ");
        jPanelQLDT.add(jLabel4);
        jLabel4.setBounds(260, 70, 50, 14);

        jLabel5.setText("RAM");
        jPanelQLDT.add(jLabel5);
        jLabel5.setBounds(270, 120, 22, 14);

        jLabel6.setText("Kho");
        jPanelQLDT.add(jLabel6);
        jLabel6.setBounds(270, 220, 30, 10);

        jLabel7.setText("Hãng sản xuất");
        jPanelQLDT.add(jLabel7);
        jLabel7.setBounds(20, 120, 80, 14);

        jLabel8.setText("Tên điện thoại");
        jPanelQLDT.add(jLabel8);
        jLabel8.setBounds(20, 160, 90, 14);

        jLabel9.setText("Số lượng");
        jPanelQLDT.add(jLabel9);
        jLabel9.setBounds(30, 210, 60, 14);
        jPanelQLDT.add(jTextField1);
        jTextField1.setBounds(110, 160, 130, 20);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanelQLDT.add(jTextField2);
        jTextField2.setBounds(340, 70, 90, 20);
        jPanelQLDT.add(jTextField3);
        jTextField3.setBounds(340, 110, 90, 20);
        jPanelQLDT.add(jTextField4);
        jTextField4.setBounds(340, 160, 90, 20);
        jPanelQLDT.add(jTextField5);
        jTextField5.setBounds(110, 210, 130, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kho1", "Kho2", "Kho3", "Kho4" }));
        jPanelQLDT.add(jComboBox2);
        jComboBox2.setBounds(340, 210, 90, 20);

        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelQLDT.add(jButton1);
        jButton1.setBounds(40, 260, 80, 23);

        jButton2.setText("Xóa");
        jPanelQLDT.add(jButton2);
        jButton2.setBounds(560, 170, 80, 23);

        jButton3.setText("Xuất file");
        jPanelQLDT.add(jButton3);
        jButton3.setBounds(560, 210, 80, 23);

        jButton4.setText("Thêm");
        jPanelQLDT.add(jButton4);
        jButton4.setBounds(560, 70, 80, 23);

        jButton5.setText("Tìm kiếm");
        jPanelQLDT.add(jButton5);
        jButton5.setBounds(560, 260, 80, 23);

        jButton6.setText("Cập nhật");
        jPanelQLDT.add(jButton6);
        jButton6.setBounds(560, 120, 80, 23);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        jPanelQLDT.add(jComboBox3);
        jComboBox3.setBounds(120, 260, 150, 20);

        jTextField6.setText("Nhập thông tin cần tìm");
        jPanelQLDT.add(jTextField6);
        jTextField6.setBounds(300, 260, 250, 20);
        jPanelQLDT.add(jTabbedPane1);
        jTabbedPane1.setBounds(40, 300, 590, 220);

        getContentPane().add(jPanelQLDT);
        jPanelQLDT.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormQLDienThoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQLDienThoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQLDienThoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQLDienThoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQLDienThoai().setVisible(true);
            }
        });
    }

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
    public javax.swing.JPanel jPanelQLDT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
