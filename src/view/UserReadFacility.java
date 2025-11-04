package view;

import javax.swing.table.DefaultTableModel;
import Service.Service;
import java.util.List;
import Model.Fasilitas;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UserReadFacility extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserReadFacility.class.getName());
    private final Service service = new Service();
    
    
    public UserReadFacility() {
        initComponents();
        tampilkanDataFasilitas();
        setLocationRelativeTo(null);
    }
    
    private void tampilkanDataFasilitas() {
    try {
        Service service = new Service();
        List<Fasilitas> daftarFasilitas = service.getAllFasilitas();

        // Siapkan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Lokasi");
        model.addColumn("Kelurahan");

        // Masukkan data fasilitas ke tabel
        for (Fasilitas f : daftarFasilitas) {
            model.addRow(new Object[]{
                f.getId_fasilitas(),
                f.getNama_fasilitas(),
                f.getJenis_fasilitas(),
                f.getLokasi(),
                f.getId_kelurahan()
            });
        }

        jTable1.setModel(model);
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal menampilkan data fasilitas: " + e.getMessage());
        e.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lihatDetail = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 520));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setPreferredSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 200, 820, 270);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 1, 36)); // NOI18N
        jLabel1.setText("Fasilitas");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(330, 60, 166, 55);

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
        jPanel3.add(btnKembali);
        btnKembali.setBounds(10, 10, 103, 26);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 820, 20);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setText("Lihat apa saja jenis fasilitas yang ada!");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(300, 110, 240, 30);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Bumi Nusantara Project");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(650, 10, 150, 30);

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
        jPanel3.add(lihatDetail);
        lihatDetail.setBounds(350, 150, 120, 29);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 820, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new UserHomeMenu_1().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void lihatDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatDetailActionPerformed
        int baris = jTable1.getSelectedRow();
    if (baris == -1) {
        JOptionPane.showMessageDialog(this, "Pilih fasilitas terlebih dahulu!");
        return;
    }

    // Ambil ID dan jenis fasilitas dari tabel
    int id = (int) ((DefaultTableModel) jTable1.getModel()).getValueAt(baris, 0);
    String jenis = jTable1.getValueAt(baris, 1).toString(); //

    try (Connection conn = service.getConnection()) {
        String sql;

        // Tentukan query JOIN sesuai jenis fasilitas
        if (jenis.equalsIgnoreCase("TPA")) {
            sql = """
            SELECT f.nama_fasilitas, f.jenis_fasilitas, f.lokasi, k.nama_kelurahan,
                   f.latitude, f.longitude, t.status, t.kapasitas_maks_ton
            FROM fasilitas f
            JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
            LEFT JOIN tpa t ON f.id_fasilitas = t.id_fasilitas
            WHERE f.id_fasilitas = ?
            """;
        } else if (jenis.equalsIgnoreCase("TPS") || jenis.equalsIgnoreCase("TPS3R")) {
            sql = """
            SELECT f.nama_fasilitas, f.jenis_fasilitas, f.lokasi, k.nama_kelurahan,
                   f.latitude, f.longitude, t.status, t.kapasitas_maks_ton AS volume_kapasitas_m3
            FROM fasilitas f
            JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
            LEFT JOIN tpa t ON f.id_fasilitas = t.id_fasilitas
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

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Format seperti referensi kamu
                    StringBuilder detail = new StringBuilder();
                    detail.append("DETAIL FASILITAS\n\n")
                          .append("Nama Fasilitas   : ").append(rs.getString("nama_fasilitas")).append("\n")
                          .append("Jenis Fasilitas  : ").append(rs.getString("jenis_fasilitas")).append("\n")
                          .append("Lokasi           : ").append(rs.getString("lokasi")).append("\n")
                          .append("Kelurahan        : ").append(rs.getString("nama_kelurahan")).append("\n")
                          .append("Koordinat        : ").append(rs.getDouble("latitude"))
                                                    .append(", ").append(rs.getDouble("longitude")).append("\n\n");

                    // Tambahan spesifik sesuai jenis
                    switch (jenis.toLowerCase()) {
                        case "tpa" -> {
                            detail.append("Status            : ").append(rs.getString("status")).append("\n")
                                  .append("Kapasitas Maks    : ").append(rs.getDouble("kapasitas_maks_ton")).append(" ton\n");
                        }
                        case "tps", "tps3r" -> {
                            detail.append("Status            : ").append(rs.getString("status")).append("\n")
                                  .append("Volume Kapasitas  : ").append(rs.getDouble("volume_kapasitas_m3")).append(" m³\n");
                        }
                        case "bank sampah" -> {
                            detail.append("Pengelola         : ").append(rs.getString("nama_pengelola")).append("\n")
                                  .append("Kontak            : ").append(rs.getString("kontak")).append("\n")
                                  .append("Jam Operasional   : ").append(rs.getString("jam_operasional")).append("\n");
                        }
                        default -> {
                            detail.append("Luas Lahan        : ").append(rs.getDouble("luas_lahan")).append(" m²\n")
                                  .append("Kondisi           : ").append(rs.getString("kondisi")).append("\n");
                        }
                    }

                    // Gunakan JTextArea agar tampil rapi seperti referensi
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
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan SQL: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
    }
    }//GEN-LAST:event_lihatDetailActionPerformed
   
    public static void main(String args[]) {
        try {
    com.formdev.flatlaf.FlatLightLaf.setup();
    } catch (Exception ex) {
    logger.log(java.util.logging.Level.SEVERE, "Failed to initialize FlatLaf", ex);
    }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new UserReadFacility().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lihatDetail;
    // End of variables declaration//GEN-END:variables
}
