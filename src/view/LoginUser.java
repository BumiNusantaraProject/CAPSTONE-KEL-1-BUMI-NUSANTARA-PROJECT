/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Service.Service;
import javax.swing.JOptionPane;
import Model.User;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author VOIR
 */
public class LoginUser extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginUser.class.getName());
    
    /**
     * Creates new form Login
     */
    public LoginUser() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        btnBuatSekarang = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Bumi Nusantara Project");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 80, 160, 19);

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 1, 24)); // NOI18N
        jLabel2.setText("<html><span style='letter-spacing:12px;'>Senang bertemu<br>dengan anda!</span></html>");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 110, 230, 80);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Email / Username");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 210, 120, 19);

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 290, 58, 19);

        jButton1.setBackground(new java.awt.Color(53, 75, 11));
        jButton1.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Masuk");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 370, 100, 33);

        jTextField1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(30, 230, 250, 35);

        jPanel2.setBackground(new java.awt.Color(53, 75, 11));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 470, 830, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Frame 4.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(330, 0, 500, 479);

        btnKembali.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/left-arrow.png"))); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.setBorderPainted(false);
        btnKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnKembali.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKembali.setIconTextGap(8);
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btnKembali);
        btnKembali.setBounds(10, 20, 107, 30);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 60, 340, 20);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Belum punya akun?");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 430, 140, 19);

        btnBuatSekarang.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnBuatSekarang.setForeground(new java.awt.Color(0, 122, 255));
        btnBuatSekarang.setText("Buat sekarang!");
        btnBuatSekarang.setBorderPainted(false);
        btnBuatSekarang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuatSekarang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuatSekarang.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnBuatSekarang.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnBuatSekarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuatSekarangActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuatSekarang);
        btnBuatSekarang.setBounds(160, 430, 100, 20);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(30, 310, 250, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-4, -6, 830, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = jTextField1.getText().trim();
        String password = new String(jPasswordField1.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua kolom!");
            return;
        }

        // Panggil service login
        Service service = new Service();
        Model.User user = service.loginUser(email, password);

        // Validasi hasil login
        if (user != null) {
            if (user.getRole().equalsIgnoreCase("user")) {
                JOptionPane.showMessageDialog(this, "Selamat datang, User!");
                this.dispose();
                new UserHomeMenu_1().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Anda bukan User!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email atau password salah!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new LoginMenu().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnBuatSekarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuatSekarangActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new Register().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnBuatSekarangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    try {
    com.formdev.flatlaf.FlatLightLaf.setup();
} catch (Exception ex) {
    logger.log(java.util.logging.Level.SEVERE, "Failed to initialize FlatLaf", ex);
}

        java.awt.EventQueue.invokeLater(() -> new LoginUser().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuatSekarang;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
