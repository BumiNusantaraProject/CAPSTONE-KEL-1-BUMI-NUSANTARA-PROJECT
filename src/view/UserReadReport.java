package view;

import Model.Laporan;
import Service.Service;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jxmapviewer.viewer.GeoPosition;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class UserReadReport extends javax.swing.JFrame {
    
    private final Service service = new Service();
    private DefaultTableModel Model;

    public UserReadReport() {
        initComponents();
        loadTable();
        setLocationRelativeTo(null);
    }
    
    private void loadTable() {
    DefaultTableModel model = new DefaultTableModel(
        new Object[]{"ID","Kelurahan", "Tanggal", "Alamat", "Deskripsi", "Status"}, 0
    );

    List<Laporan> laporanList = service.getAllLaporan();
    for (Laporan l : laporanList) {
        model.addRow(new Object[]{
            l.getId_laporan(),
            l.getNama_kelurahan(),
            l.getTanggal_lapor(),
            l.getAlamat_lokasi(),
            l.getDeksripsi(),
            l.getStatus()
        });
    }

    tblLaporan.setModel(model);
    System.out.println("Jumlah laporan ditampilkan: " + model.getRowCount());
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lihatLokasi = new javax.swing.JButton();
        lihatFoto = new javax.swing.JButton();
        LihatDetailButton = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 520));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setPreferredSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

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
        lihatLokasi.setBounds(360, 120, 110, 30);

        lihatFoto.setBackground(new java.awt.Color(255, 153, 153));
        lihatFoto.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lihatFoto.setText("Lihat Foto");
        lihatFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lihatFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatFotoActionPerformed(evt);
            }
        });
        jPanel1.add(lihatFoto);
        lihatFoto.setBounds(480, 120, 100, 30);

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
        LihatDetailButton.setBounds(240, 120, 110, 30);

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
        btnKembali.setBounds(10, 10, 103, 26);

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 1, 36)); // NOI18N
        jLabel1.setText("Lihat Laporan");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(280, 60, 268, 55);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 820, 20);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Bumi Nusantara Project");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(650, 10, 150, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 170);

        tblLaporan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Kelurahan", "Tanggal", "Lokasi", "Foto", "Deskripsi", "Status"
            }
        ));
        tblLaporan.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tblLaporan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 171, 820, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lihatFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatFotoActionPerformed
    int row = tblLaporan.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih laporan terlebih dahulu!");
            return;
        }

        int idLaporan = (int) tblLaporan.getValueAt(row, 0);
        try (PreparedStatement ps = service.getConnection().prepareStatement("SELECT foto FROM laporan WHERE id_laporan=?")) {
            ps.setInt(1, idLaporan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                byte[] bytes = rs.getBytes("foto");
                if (bytes != null) {
                    Image img = ImageIO.read(new ByteArrayInputStream(bytes));
                    ImageIcon icon = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));
                    JLabel lbl = new JLabel(icon);
                    JOptionPane.showMessageDialog(this, lbl, "Foto Laporan ID: " + idLaporan, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Foto tidak tersedia!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan foto: " + e.getMessage());
        }   
    }//GEN-LAST:event_lihatFotoActionPerformed

    private void lihatLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatLokasiActionPerformed
    int selectedRow = tblLaporan.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih laporan terlebih dahulu!");
        return;
    }

    try {
        int laporanId = (int) tblLaporan.getValueAt(selectedRow, 0);

        String sql = "SELECT latitude, longitude FROM laporan WHERE id_laporan = ?";
        PreparedStatement ps = service.getConnection().prepareStatement(sql);
        ps.setInt(1, laporanId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            double lat = rs.getDouble("latitude");
            double lon = rs.getDouble("longitude");

            if (lat != 0 && lon != 0) {
                new Map(lat, lon).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Koordinat tidak tersedia untuk laporan ini!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Laporan tidak ditemukan.");
        }

        rs.close();
        ps.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat lokasi: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_lihatLokasiActionPerformed

    private void LihatDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatDetailButtonActionPerformed
    int row = tblLaporan.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih laporan terlebih dahulu!");
        return;
    }

    int idLaporan = (int) tblLaporan.getValueAt(row, 0);

    try (PreparedStatement ps = service.getConnection().prepareStatement(
            "SELECT * FROM laporan WHERE id_laporan = ?")) {
        ps.setInt(1, idLaporan);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Susun detail laporan dengan format yang lebih rapi
            StringBuilder detail = new StringBuilder();
            detail.append("DETAIL LAPORAN\n\n")
                  .append("ID Laporan     : ").append(rs.getInt("id_laporan")).append("\n")
                  .append("Tanggal Lapor  : ").append(rs.getString("tanggal_lapor")).append("\n")
                  .append("Alamat Lokasi  : ").append(rs.getString("alamat_lokasi")).append("\n")
                  .append("Kelurahan ID   : ").append(rs.getInt("id_kelurahan")).append("\n")
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
            area.setCaretPosition(0);
            area.setMargin(new java.awt.Insets(10, 10, 10, 10)); // padding biar lebih rapi

            JScrollPane scroll = new JScrollPane(area);
            scroll.setPreferredSize(new java.awt.Dimension(420, 291)); // ✅ menyesuaikan dengan frame utama

            JOptionPane.showMessageDialog(this, scroll,
                    "Detail Laporan ID: " + idLaporan,
                    JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(this, "Data laporan tidak ditemukan.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menampilkan detail: " + e.getMessage());
    }
 // TODO add your handling code here:
    }//GEN-LAST:event_LihatDetailButtonActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new UserAddReport().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    public static void main(String[] args) {
        try {
            FlatLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Gagal inisialisasi tema FlatLaf: " + ex.getMessage());
        }
        SwingUtilities.invokeLater(() -> new UserReadReport().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LihatDetailButton;
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton lihatFoto;
    private javax.swing.JButton lihatLokasi;
    private javax.swing.JTable tblLaporan;
    // End of variables declaration//GEN-END:variables
}
