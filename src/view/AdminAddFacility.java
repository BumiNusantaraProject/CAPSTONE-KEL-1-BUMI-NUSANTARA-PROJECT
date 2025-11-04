package view;

import Model.Fasilitas;
import Service.Service;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AdminAddFacility extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminAddFacility.class.getName());
    private final Service service = new Service();
    private double latitude = 0.0;
    private double longitude = 0.0;

    public AdminAddFacility() {
        initComponents();
        tampilkanDataFasilitas();
        pilihDariTabel();
        setLocationRelativeTo(null);
    }

    // =========================
    // 1️⃣ TAMPILKAN DATA FASILITAS (JOIN DENGAN KELURAHAN)
    // =========================
    private void tampilkanDataFasilitas() {
        try (Connection conn = service.getConnection()) {
            String sql = """
                SELECT f.id_fasilitas, f.nama_fasilitas, f.jenis_fasilitas, 
                       f.lokasi, k.nama_kelurahan, f.latitude, f.longitude
                FROM fasilitas f
                JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
            """;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID", "Nama", "Jenis", "Lokasi", "Kelurahan", "Latitude", "Longitude"}, 0
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_fasilitas"),
                    rs.getString("nama_fasilitas"),
                    rs.getString("jenis_fasilitas"),
                    rs.getString("lokasi"),
                    rs.getString("nama_kelurahan"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude")
                });
            }

            jTable2.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
        }
    }

    private void pilihDariTabel() {
        jTable2.getSelectionModel().addListSelectionListener(e -> {
            int baris = jTable2.getSelectedRow();
            if (baris >= 0) {
                latitude = Double.parseDouble(jTable2.getValueAt(baris, 5).toString());
                longitude = Double.parseDouble(jTable2.getValueAt(baris, 6).toString());
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnBankSampah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lihatDetail = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnKembali = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnTapak = new javax.swing.JButton();
        btnTPA = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Jenis", "Lokasi", "Kelurahan"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 520));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        btnBankSampah.setBackground(new java.awt.Color(153, 255, 204));
        btnBankSampah.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnBankSampah.setText("Menu Bank Sampah");
        btnBankSampah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBankSampah.setFocusPainted(false);
        btnBankSampah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBankSampahActionPerformed(evt);
            }
        });
        jPanel1.add(btnBankSampah);
        btnBankSampah.setBounds(410, 70, 140, 29);

        jTable2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Jenis", "Lokasi", "Kelurahan"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 130, 830, 340);

        lihatDetail.setBackground(new java.awt.Color(255, 255, 153));
        lihatDetail.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lihatDetail.setText("Lihat detail");
        lihatDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lihatDetail.setFocusPainted(false);
        lihatDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatDetailActionPerformed(evt);
            }
        });
        jPanel1.add(lihatDetail);
        lihatDetail.setBounds(560, 70, 120, 29);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 820, 20);

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
        btnKembali.setBounds(0, 10, 120, 30);

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Menambahkan & Mengedit fasilitas!");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(580, 10, 240, 30);

        btnTapak.setBackground(new java.awt.Color(102, 153, 255));
        btnTapak.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnTapak.setText("Menu Tapak");
        btnTapak.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTapak.setFocusPainted(false);
        btnTapak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTapakActionPerformed(evt);
            }
        });
        jPanel1.add(btnTapak);
        btnTapak.setBounds(150, 70, 120, 29);

        btnTPA.setBackground(new java.awt.Color(255, 153, 102));
        btnTPA.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnTPA.setText("Menu TPA");
        btnTPA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTPA.setFocusPainted(false);
        btnTPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTPAActionPerformed(evt);
            }
        });
        jPanel1.add(btnTPA);
        btnTPA.setBounds(280, 70, 120, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBankSampahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBankSampahActionPerformed
    this.dispose(); // menutup halaman LoginMenu
        new AdminAddFacilityBankSampah().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnBankSampahActionPerformed

    private void lihatDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatDetailActionPerformed
        int baris = jTable2.getSelectedRow();
    if (baris < 0) {
        JOptionPane.showMessageDialog(this, "Pilih fasilitas terlebih dahulu!");
        return;
    }

    int id = Integer.parseInt(jTable2.getValueAt(baris, 0).toString());
    String jenis = jTable2.getValueAt(baris, 2).toString();

    try (Connection conn = service.getConnection()) {
        String sql = null;

        // Tentukan query join berdasarkan jenis fasilitas
        if (jenis.equalsIgnoreCase("TPA")) {
    sql = """
        SELECT f.nama_fasilitas, f.jenis_fasilitas, f.lokasi, k.nama_kelurahan, 
               f.latitude, f.longitude, t.status, t.kapasitas_maks_ton
        FROM fasilitas f
        JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
        LEFT JOIN tpa t ON f.id_fasilitas = t.id_fasilitas
        WHERE f.id_fasilitas = ?
    """;
} else if (jenis.equalsIgnoreCase("TPS") || jenis.equalsIgnoreCase("TPS 3R")) {
    sql = """
        SELECT f.nama_fasilitas, f.jenis_fasilitas, f.lokasi, k.nama_kelurahan, 
               f.latitude, f.longitude, t.status, t.volume_kapasitas_m3
        FROM fasilitas f
        JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
        LEFT JOIN tps t ON f.id_fasilitas = t.id_fasilitas
        WHERE f.id_fasilitas = ?
    """;
} else if (jenis.equalsIgnoreCase("Bank Sampah")) {
    sql = """
        SELECT f.nama_fasilitas, f.jenis_fasilitas, f.lokasi, k.nama_kelurahan, 
               f.latitude, f.longitude, b.nama_pengelola, b.kontak, b.jam_operasional
        FROM fasilitas f
        JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
        LEFT JOIN bank_sampah b ON f.id_fasilitas = b.id_fasilitas
        WHERE f.id_fasilitas = ?
    """;
} else {
    sql = """
        SELECT f.nama_fasilitas, f.jenis_fasilitas, f.lokasi, k.nama_kelurahan,
               f.latitude, f.longitude, tb.luas_lahan, tb.kondisi
        FROM fasilitas f
        JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
        LEFT JOIN tapak_berkelanjutan tb ON f.id_fasilitas = tb.id_fasilitas
        WHERE f.id_fasilitas = ?
    """;
}


        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            StringBuilder detail = new StringBuilder();
            detail.append("Nama: ").append(rs.getString("nama_fasilitas")).append("\n");
            detail.append("Jenis: ").append(rs.getString("jenis_fasilitas")).append("\n");
            detail.append("Lokasi: ").append(rs.getString("lokasi")).append("\n");
            detail.append("Kelurahan: ").append(rs.getString("nama_kelurahan")).append("\n");
            detail.append("Koordinat: ").append(rs.getDouble("latitude"))
                  .append(", ").append(rs.getDouble("longitude")).append("\n\n");

            // Tambahkan info spesifik berdasarkan jenis
            if (jenis.equalsIgnoreCase("TPA")) {
                detail.append("Status: ").append(rs.getString("status")).append("\n");
                detail.append("Kapasitas Maksimum: ").append(rs.getDouble("kapasitas_maks_ton")).append(" ton\n");
            } else if (jenis.equalsIgnoreCase("Bank Sampah")) {
                detail.append("Pengelola: ").append(rs.getString("nama_pengelola")).append("\n");
                detail.append("Kontak: ").append(rs.getString("kontak")).append("\n");
                detail.append("Jam Operasional: ").append(rs.getString("jam_operasional")).append("\n");
            } else {
                detail.append("Luas Lahan: ").append(rs.getDouble("luas_lahan")).append(" m²\n");
                detail.append("Kondisi: ").append(rs.getString("kondisi")).append("\n");
            }

            JTextArea area = new JTextArea(detail.toString());
                    area.setEditable(false);
                    area.setFont(new java.awt.Font("Poppins", java.awt.Font.BOLD, 13));
                    area.setLineWrap(true);
                    area.setWrapStyleWord(true);
                    area.setCaretPosition(0);
                    area.setMargin(new java.awt.Insets(10, 10, 10, 10));

                    JScrollPane scroll = new JScrollPane(area);
                    scroll.setPreferredSize(new java.awt.Dimension(420, 300));

                    JOptionPane.showMessageDialog(this, scroll,
                            "Detail Fasilitas ID: " + id,
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "Data detail tidak ditemukan.");
                }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan SQL: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
    }
    }//GEN-LAST:event_lihatDetailActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new AdminHomeMenu().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnTapakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTapakActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new AdminAddFacilityTapak().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnTapakActionPerformed

    private void btnTPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTPAActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new AdminAddFacilityTPA().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnTPAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
    com.formdev.flatlaf.FlatLightLaf.setup();
} catch (Exception ex) {
    logger.log(java.util.logging.Level.SEVERE, "Failed to initialize FlatLaf", ex);
}
        java.awt.EventQueue.invokeLater(() -> new AdminAddFacility().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBankSampah;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTPA;
    private javax.swing.JButton btnTapak;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton lihatDetail;
    // End of variables declaration//GEN-END:variables
}
