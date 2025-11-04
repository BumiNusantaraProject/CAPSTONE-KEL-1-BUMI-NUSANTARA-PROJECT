package view;

import Model.Fasilitas;
import Service.Service;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

public class AdminHomeMenu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminHomeMenu.class.getName());
    private Service service = new Service();
    
    public AdminHomeMenu() {
        initComponents();
        initMap();             
        tampilkanWaypointDariDatabase();
        setLocationRelativeTo(null);
    }

    private void initMap() {
        TileFactoryInfo info = new OSMTileFactoryInfo("OpenStreetMap", "https://tile.openstreetmap.org");
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer1.setTileFactory(tileFactory);

        // Posisi awal (Samarinda)
        GeoPosition samarinda = new GeoPosition(-0.4674743403812144, 117.15747892856598);
        jXMapViewer1.setAddressLocation(samarinda);
        jXMapViewer1.setZoom(5);

        // Aktifkan kontrol mouse
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer1);
        jXMapViewer1.addMouseListener(mm);
        jXMapViewer1.addMouseMotionListener(mm);
        jXMapViewer1.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer1));
    }
    
    private void tampilkanWaypointDariDatabase() {
        try {
            List<Fasilitas> fasilitasList = service.getAllFasilitas();
            Set<Waypoint> waypoints = new HashSet<>();

            for (Fasilitas f : fasilitasList) {
                double lat = f.getLatitude();
                double lon = f.getLongitude();

                // Validasi data numerik
                if (lat != 0 && lon != 0) {
                    GeoPosition pos = new GeoPosition(lat, lon);
                    waypoints.add(new DefaultWaypoint(pos));
                    System.out.println("Fasilitas: " + f.getNama_fasilitas() + " (" + lat + ", " + lon + ")");
                } else {
                    System.out.println("Koordinat tidak valid untuk: " + f.getNama_fasilitas());
                }
            }

            WaypointPainter<Waypoint> painter = new WaypointPainter<>();
            painter.setWaypoints(waypoints);
            jXMapViewer1.setOverlayPainter(painter);
            jXMapViewer1.repaint();

            System.out.println("Total fasilitas ditampilkan: " + waypoints.size());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan fasilitas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnMenuLaporan = new javax.swing.JButton();
        btnMenuFasilitas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnKeluar = new javax.swing.JButton();
        btnMenuKelurahan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jXMapViewer1 = new org.jxmapviewer.JXMapViewer();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(53, 75, 11));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnMenuLaporan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnMenuLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/clipboard.png"))); // NOI18N
        btnMenuLaporan.setText("Menu laporan");
        btnMenuLaporan.setBorderPainted(false);
        btnMenuLaporan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuLaporan.setIconTextGap(8);
        btnMenuLaporan.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnMenuLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuLaporanActionPerformed(evt);
            }
        });

        btnMenuFasilitas.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnMenuFasilitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/tea-leaf.png"))); // NOI18N
        btnMenuFasilitas.setText("Menu fasilitas");
        btnMenuFasilitas.setBorderPainted(false);
        btnMenuFasilitas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuFasilitas.setIconTextGap(8);
        btnMenuFasilitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuFasilitasActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo80x.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Features");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        btnKeluar.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/left-arrow.png"))); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.setBorderPainted(false);
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnKeluar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKeluar.setIconTextGap(8);
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnMenuKelurahan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnMenuKelurahan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/eco-friendly-house.png"))); // NOI18N
        btnMenuKelurahan.setText("Menu kelurahan");
        btnMenuKelurahan.setBorderPainted(false);
        btnMenuKelurahan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMenuKelurahan.setIconTextGap(8);
        btnMenuKelurahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuKelurahanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btnMenuFasilitas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMenuLaporan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnMenuKelurahan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addComponent(btnMenuLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuFasilitas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenuKelurahan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 160, 490);

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html><span style='letter-spacing:12px;'>Hi, selamat<br>datang admin</span></html>");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 50, 277, 110);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("<html>Akses berbagai fitur untuk mengedit laporan, menambahkan fasilitas dan melihat <br> wilayah secara efisien.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 160, 539, 38);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(1184, 289, 1, 10);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bumi Nusantara Project");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 20, 146, 19);

        jXMapViewer1.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jXMapViewer1Layout = new javax.swing.GroupLayout(jXMapViewer1);
        jXMapViewer1.setLayout(jXMapViewer1Layout);
        jXMapViewer1Layout.setHorizontalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jXMapViewer1Layout.setVerticalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        getContentPane().add(jXMapViewer1);
        jXMapViewer1.setBounds(180, 210, 620, 188);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/map.png"))); // NOI18N
        jLabel5.setText("Ini adalah tampilan dimana saja fasilitas berada");
        jLabel5.setIconTextGap(12);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(180, 350, 620, 90);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Award winning photography nature world.jpeg"))); // NOI18N
        jLabel7.setAlignmentY(0.0F);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(160, 0, 680, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuFasilitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuFasilitasActionPerformed
        this.dispose(); // menutup halaman LoginMenu
    new AdminAddFacility().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnMenuFasilitasActionPerformed

    private void btnMenuLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuLaporanActionPerformed
        this.dispose(); // menutup halaman LoginMenu
    new AdminEditReport().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnMenuLaporanActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed

int konfirmasi = JOptionPane.showConfirmDialog(
        this,
        "Apakah Anda yakin ingin keluar dari aplikasi?",
        "Konfirmasi Keluar",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    if (konfirmasi == JOptionPane.YES_OPTION) {
        this.dispose(); // Tutup halaman saat ini
        new LoginAdmin().setVisible(true); // Kembali ke halaman login
    }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnMenuKelurahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuKelurahanActionPerformed
        this.dispose(); // menutup halaman LoginMenu
    new AdminEditKelurahan().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnMenuKelurahanActionPerformed

    public static void main(String args[]) {
        try {
            FlatLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Gagal load tema FlatLaf: " + ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(() -> new AdminHomeMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnMenuFasilitas;
    private javax.swing.JButton btnMenuKelurahan;
    private javax.swing.JButton btnMenuLaporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.jxmapviewer.JXMapViewer jXMapViewer1;
    // End of variables declaration//GEN-END:variables
}
