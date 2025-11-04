package view;

import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Register.class.getName());

    public Register() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnKembali = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnMasukDisini = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 520));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setPreferredSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Email / Username");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 210, 120, 19);

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 300, 58, 13);

        jButton1.setBackground(new java.awt.Color(53, 75, 11));
        jButton1.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buat sekarang!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 380, 230, 33);

        jTextField1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(30, 240, 230, 35);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 60, 340, 20);

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

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Sudah punya akun?");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 430, 140, 19);

        btnMasukDisini.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnMasukDisini.setForeground(new java.awt.Color(0, 122, 255));
        btnMasukDisini.setText("Masuk disini!");
        btnMasukDisini.setBorderPainted(false);
        btnMasukDisini.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMasukDisini.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMasukDisini.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMasukDisini.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMasukDisini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukDisiniActionPerformed(evt);
            }
        });
        jPanel1.add(btnMasukDisini);
        btnMasukDisini.setBounds(170, 430, 90, 20);

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 1, 28)); // NOI18N
        jLabel2.setText("akun dulu yok!");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 140, 230, 30);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Bumi Nusantara Project");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 80, 150, 19);

        jLabel7.setFont(new java.awt.Font("Poppins ExtraBold", 1, 28)); // NOI18N
        jLabel7.setText("Hi, buat");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 110, 120, 30);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(30, 320, 230, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(270, 0, 290, 500);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BgUserRegis.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-7, -5, 830, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String email = jTextField1.getText().trim();
    String password = new String(jPasswordField1.getPassword());

    if (email.isEmpty() || password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Harap isi semua kolom!");
        return;
    }

    Service.Service service = new Service.Service();
    boolean success = service.registerUser(email, password);

    if (success) {
        JOptionPane.showMessageDialog(this, "Akun berhasil dibuat!");
        this.dispose();
        new LoginUser().setVisible(true);// Tutup form register
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new LoginUser().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnMasukDisiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukDisiniActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new LoginUser().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnMasukDisiniActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    try {
    com.formdev.flatlaf.FlatLightLaf.setup();
} catch (Exception ex) {
    logger.log(java.util.logging.Level.SEVERE, "Failed to initialize FlatLaf", ex);
}
        java.awt.EventQueue.invokeLater(() -> new Register().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnMasukDisini;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
