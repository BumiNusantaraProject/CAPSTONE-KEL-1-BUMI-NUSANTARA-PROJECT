package view;

import Service.Service;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Laporan;
import static com.mysql.cj.conf.PropertyKey.logger;
import org.jxmapviewer.viewer.GeoPosition;
import java.util.logging.Logger;
import java.util.logging.Level;


public class AdminEditReport extends javax.swing.JFrame {
    private final Service service = new Service();
    private DefaultTableModel model;
    private Integer selectedReportId = null;

    public AdminEditReport() {
         initComponents();
    loadTable();
    setLocationRelativeTo(null);
    selectedReportId = null;

    //Supaya tabel berperilaku sama seperti di AdminAddFacility
    tblLaporan.setRowSelectionAllowed(true);
    tblLaporan.setColumnSelectionAllowed(false);
    tblLaporan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tblLaporan.setFocusable(false);
    tblLaporan.setSelectionBackground(new java.awt.Color(204, 229, 255)); // biru muda
    tblLaporan.setSelectionForeground(java.awt.Color.BLACK);

    //Listener untuk deteksi baris yang dipilih
    tblLaporan.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tblLaporan.getSelectedRow();
            if (selectedRow >= 0) {
                selectedReportId = Integer.parseInt(tblLaporan.getValueAt(selectedRow, 0).toString());
                String status = tblLaporan.getValueAt(selectedRow, 4).toString();
                jTextField1.setText(selectedReportId.toString());
                comboStatus.setSelectedItem(status);
            }
        }
    });
    }

    private void loadTable() {
    if (model == null) {
        model = new DefaultTableModel(new Object[]{
            "ID", "Tanggal", "Alamat", "Deskripsi", "Status", "Latitude", "Longitude"
        }, 0);
        tblLaporan.setModel(model);
    } else {
        model.setRowCount(0); // kosongkan data lama tanpa buat model baru
    }

    try {
        List<Laporan> laporanList = service.getAllLaporan();
        for (Laporan l : laporanList) {
            model.addRow(new Object[]{
                l.getId_laporan(),
                l.getTanggal_lapor(),
                l.getAlamat_lokasi(),
                l.getDeksripsi(),
                l.getStatus(),
                l.getLatitude(),
                l.getLongitude()
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat tabel: " + e.getMessage());
    }

    // ✅ Jika sebelumnya ada yang terseleksi, tetap tampilkan
    if (selectedReportId != null) {
        for (int i = 0; i < tblLaporan.getRowCount(); i++) {
            int id = Integer.parseInt(tblLaporan.getValueAt(i, 0).toString());
            if (id == selectedReportId) {
                tblLaporan.setRowSelectionInterval(i, i);
                break;
            }
        }
    }
}
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        hapusLaporan = new javax.swing.JButton();
        lihatLokasi = new javax.swing.JButton();
        lihatFoto = new javax.swing.JButton();
        LihatDetailButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        CariButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        tblLaporan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tanggal", "Lokasi", "Foto", "Deskripsi", "Status"
            }
        ));
        tblLaporan.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblLaporan);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 185, 820, 290);

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(180, 80, 190, 29);

        refresh.setBackground(new java.awt.Color(153, 153, 153));
        refresh.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/refresh.png"))); // NOI18N
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel1.add(refresh);
        refresh.setBounds(470, 80, 40, 29);

        btnKembali.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/left-arrow.png"))); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.setBorderPainted(false);
        btnKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnKembali.setFocusPainted(false);
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
        jLabel5.setText("Ubah status: ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(530, 80, 90, 30);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 820, 20);

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Mengedit laporan!");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(680, 10, 140, 30);

        hapusLaporan.setBackground(new java.awt.Color(255, 153, 153));
        hapusLaporan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        hapusLaporan.setText("Hapus Laporan");
        hapusLaporan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        hapusLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusLaporanActionPerformed(evt);
            }
        });
        jPanel1.add(hapusLaporan);
        hapusLaporan.setBounds(300, 130, 110, 30);

        lihatLokasi.setBackground(new java.awt.Color(255, 204, 153));
        lihatLokasi.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lihatLokasi.setText("Lihat Lokasi");
        lihatLokasi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lihatLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatLokasiActionPerformed(evt);
            }
        });
        jPanel1.add(lihatLokasi);
        lihatLokasi.setBounds(180, 130, 110, 30);

        lihatFoto.setBackground(new java.awt.Color(153, 153, 255));
        lihatFoto.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lihatFoto.setText("Lihat Foto");
        lihatFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lihatFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatFotoActionPerformed(evt);
            }
        });
        jPanel1.add(lihatFoto);
        lihatFoto.setBounds(540, 130, 110, 30);

        LihatDetailButton.setBackground(new java.awt.Color(255, 255, 153));
        LihatDetailButton.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        LihatDetailButton.setText("Lihat Detail");
        LihatDetailButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        LihatDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatDetailButtonActionPerformed(evt);
            }
        });
        jPanel1.add(LihatDetailButton);
        LihatDetailButton.setBounds(420, 130, 110, 30);

        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Masukkan ID:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(90, 80, 90, 30);

        comboStatus.setBackground(new java.awt.Color(204, 204, 204));
        comboStatus.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ditinjau", "diproses", "selesai" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });
        jPanel1.add(comboStatus);
        comboStatus.setBounds(620, 80, 100, 29);

        CariButton.setBackground(new java.awt.Color(153, 153, 153));
        CariButton.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        CariButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N
        CariButton.setText("Cari");
        CariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CariButton);
        CariButton.setBounds(380, 80, 80, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        loadTable();
    }//GEN-LAST:event_refreshActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new AdminHomeMenu().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void hapusLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusLaporanActionPerformed
        if (selectedReportId == null) {
            JOptionPane.showMessageDialog(this, "Pilih laporan yang ingin dihapus!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus laporan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (service.hapusLaporan(selectedReportId)) {
                JOptionPane.showMessageDialog(this, "Laporan berhasil dihapus!");
                loadTable();
                selectedReportId = null;
                jTextField1.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus laporan!");
            }
        }
    }//GEN-LAST:event_hapusLaporanActionPerformed

    private void lihatLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatLokasiActionPerformed
        if (selectedReportId == null) {
        JOptionPane.showMessageDialog(this, "Pilih laporan terlebih dahulu!");
        return;
    }

    try {
        String sql = "SELECT latitude, longitude FROM laporan WHERE id_laporan = ?";
        PreparedStatement ps = service.getConnection().prepareStatement(sql);
        ps.setInt(1, selectedReportId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            double lat = rs.getDouble("latitude");
            double lon = rs.getDouble("longitude");
            if (lat != 0 && lon != 0) {
                // ✅ kirim this sebagai parentForm
                new Map(this, lat, lon).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Koordinat laporan tidak tersedia!");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan lokasi: " + e.getMessage());
    }                
    }//GEN-LAST:event_lihatLokasiActionPerformed

    private void lihatFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatFotoActionPerformed
        if (selectedReportId == null) {
            JOptionPane.showMessageDialog(this, "Pilih laporan terlebih dahulu!");
            return;
        }
        try (PreparedStatement ps = service.getConnection().prepareStatement("SELECT foto FROM laporan WHERE id_laporan=?")) {
            ps.setInt(1, selectedReportId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                byte[] bytes = rs.getBytes("foto");
                if (bytes != null) {
                    Image img = ImageIO.read(new ByteArrayInputStream(bytes));
                    ImageIcon icon = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));
                    JLabel lbl = new JLabel(icon);
                    JOptionPane.showMessageDialog(this, lbl, "Foto Laporan ID: " + selectedReportId, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Foto tidak tersedia!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan foto: " + e.getMessage());
        }
    }//GEN-LAST:event_lihatFotoActionPerformed

    private void LihatDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatDetailButtonActionPerformed
        if (selectedReportId == null) {
            JOptionPane.showMessageDialog(this, "Pilih laporan terlebih dahulu!");
            return;
        }
        try (PreparedStatement ps = service.getConnection().prepareStatement("SELECT * FROM laporan WHERE id_laporan = ?")) {
            ps.setInt(1, selectedReportId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                StringBuilder detail = new StringBuilder();
                detail.append("DETAIL LAPORAN\n\n")
                      .append("ID Laporan     : ").append(rs.getInt("id_laporan")).append("\n")
                      .append("Tanggal Lapor  : ").append(rs.getString("tanggal_lapor")).append("\n")
                      .append("Alamat Lokasi  : ").append(rs.getString("alamat_lokasi")).append("\n")
                      .append("Status         : ").append(rs.getString("status")).append("\n")
                      .append("Latitude       : ").append(rs.getDouble("latitude")).append("\n")
                      .append("Longitude      : ").append(rs.getDouble("longitude")).append("\n\n")
                      .append("Deskripsi:\n")
                      .append(rs.getString("deksripsi"));
                JTextArea area = new JTextArea(detail.toString());
                area.setEditable(false);
                area.setFont(new java.awt.Font("Poppins", java.awt.Font.BOLD, 12));
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                JScrollPane scroll = new JScrollPane(area);
                scroll.setPreferredSize(new java.awt.Dimension(420, 291));
                JOptionPane.showMessageDialog(this, scroll, "Detail Laporan ID: " + selectedReportId, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan detail: " + e.getMessage());
        }
    }//GEN-LAST:event_LihatDetailButtonActionPerformed

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        if (selectedReportId == null) return;
        String newStatus = comboStatus.getSelectedItem().toString();
        if (service.updateStatusLaporan(selectedReportId, newStatus)) {
            loadTable();
        }
    }//GEN-LAST:event_comboStatusActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void CariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariButtonActionPerformed
        String inputId = jTextField1.getText().trim();
        if (inputId.isEmpty()) {
            loadTable();
            return;
        }
        try {
            int idLaporan = Integer.parseInt(inputId);
            String sql = "SELECT * FROM laporan WHERE id_laporan = ?";
            PreparedStatement ps = service.getConnection().prepareStatement(sql);
            ps.setInt(1, idLaporan);
            ResultSet rs = ps.executeQuery();
            model.setRowCount(0);
            if (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_laporan"),
                    rs.getString("tanggal_lapor"),
                    rs.getString("alamat_lokasi"),
                    rs.getString("deksripsi"),
                    rs.getString("status"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude")
                });
                selectedReportId = idLaporan;
            } else {
                JOptionPane.showMessageDialog(this, "Tidak ada laporan dengan ID tersebut.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mencari: " + e.getMessage());
        }
    }//GEN-LAST:event_CariButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
                try {
            com.formdev.flatlaf.FlatLightLaf.setup();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(AdminEditReport.class.getName())
    .log(java.util.logging.Level.SEVERE, "Failed to initialize FlatLaf", ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> new AdminEditReport().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CariButton;
    private javax.swing.JButton LihatDetailButton;
    private javax.swing.JButton btnKembali;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JButton hapusLaporan;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton lihatFoto;
    private javax.swing.JButton lihatLokasi;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tblLaporan;
    // End of variables declaration//GEN-END:variables
}
