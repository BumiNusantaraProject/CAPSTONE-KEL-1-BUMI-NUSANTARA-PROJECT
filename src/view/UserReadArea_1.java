package view;

import Model.Kelurahan;
import Service.Service;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.*;

public class UserReadArea_1 extends javax.swing.JFrame {

    private final Service service = new Service();
    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(UserReadArea_1.class.getName());


    public UserReadArea_1() {
        initComponents();
        initMap();
        tampilkanKelurahanDenganZona();
        setLocationRelativeTo(null);
    }

    private void initMap() {
        TileFactoryInfo info = new OSMTileFactoryInfo("OpenStreetMap", "https://tile.openstreetmap.org");
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer1.setTileFactory(tileFactory);

        // Pusatkan di Samarinda
        GeoPosition samarinda = new GeoPosition(-0.46747434, 117.15747892);
        jXMapViewer1.setAddressLocation(samarinda);
        jXMapViewer1.setZoom(5);

        // Interaksi peta
        MouseInputListener mm = new PanMouseInputListener(jXMapViewer1);
        jXMapViewer1.addMouseListener(mm);
        jXMapViewer1.addMouseMotionListener(mm);
        jXMapViewer1.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer1));
    }

    private void tampilkanKelurahanDenganZona() {
        try {
            List<Kelurahan> kelurahanList = service.getAllKelurahan();
            Set<Waypoint> waypoints = new HashSet<>();

            for (Kelurahan k : kelurahanList) {
                double lat = k.getLatitude();
                double lon = k.getLongitude();

                if (lat != 0 && lon != 0) {
                    Color warna;
                    switch (k.getZona().toLowerCase()) {
                        case "merah" -> warna = Color.RED;
                        case "kuning" -> warna = Color.YELLOW;
                        case "hijau" -> warna = Color.GREEN;
                        default -> warna = Color.GRAY;
                    }

                    waypoints.add(new ColoredWaypoint(lat, lon, warna));
                }
            }

            ColoredWaypointPainter painter = new ColoredWaypointPainter();
            painter.setWaypoints(waypoints);
            jXMapViewer1.setOverlayPainter(painter);
            jXMapViewer1.repaint();

            System.out.println("Total kelurahan ditampilkan: " + waypoints.size());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan kelurahan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------------- Kelas bantu untuk warna marker ----------------
    static class ColoredWaypoint extends DefaultWaypoint {
        private final Color color;

        public ColoredWaypoint(double lat, double lon, Color color) {
            super(new GeoPosition(lat, lon));
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }

    static class ColoredWaypointPainter extends WaypointPainter<Waypoint> {
        @Override
        protected void doPaint(Graphics2D g, JXMapViewer map, int width, int height) {
            for (Waypoint wp : getWaypoints()) {
                if (wp instanceof ColoredWaypoint cwp) {
                    GeoPosition gp = cwp.getPosition();
                    Point2D pt = map.getTileFactory().geoToPixel(gp, map.getZoom());
                    Rectangle viewport = map.getViewportBounds();
                    int x = (int) (pt.getX() - viewport.getX());
                    int y = (int) (pt.getY() - viewport.getY());

                    g.setColor(Color.BLACK);
                    g.fill(new Ellipse2D.Double(x - 5, y - 5, 12, 12));

                    g.setColor(cwp.getColor());
                    g.fill(new Ellipse2D.Double(x - 4, y - 4, 10, 10));
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        noOpLocalCache1 = new org.jxmapviewer.cache.NoOpLocalCache();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jXMapViewer1 = new org.jxmapviewer.JXMapViewer();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 520));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setPreferredSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 1, 36)); // NOI18N
        jLabel1.setText("Wilayah");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(320, 60, 166, 55);

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

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Bumi Nusantara Project");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(650, 10, 150, 30);

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setText("Lihat keaadan di kelurahan sekitar anda!");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(280, 110, 250, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 820, 150);

        jXMapViewer1.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jXMapViewer1Layout = new javax.swing.GroupLayout(jXMapViewer1);
        jXMapViewer1.setLayout(jXMapViewer1Layout);
        jXMapViewer1Layout.setHorizontalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jXMapViewer1Layout.setVerticalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel1.add(jXMapViewer1);
        jXMapViewer1.setBounds(0, 148, 680, 350);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/record.png"))); // NOI18N
        jLabel3.setText("Zona Hijau");
        jLabel3.setIconTextGap(8);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(690, 260, 110, 20);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(680, 290, 140, 10);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/tale.png"))); // NOI18N
        jLabel6.setText("Legenda");
        jLabel6.setIconTextGap(8);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(690, 160, 90, 20);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(680, 150, 140, 10);

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/round.png"))); // NOI18N
        jLabel7.setText("Zona Merah");
        jLabel7.setIconTextGap(8);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(690, 200, 110, 20);

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/shape.png"))); // NOI18N
        jLabel8.setText("Zona Kuning");
        jLabel8.setIconTextGap(8);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(690, 230, 110, 20);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(680, 190, 140, 10);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 508);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new UserHomeMenu_1().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tampilkanPeta() {
    try {
        // Buat viewer peta
        JXMapViewer mapViewer1 = new JXMapViewer();

        // Gunakan tile server OSM yang stabil (France OSM mirror)
        TileFactoryInfo info = new TileFactoryInfo(
                0, 19, 20, 256, true, true,
                "http://a.tile.openstreetmap.org",  // alternatif agar tidak diblokir
                "x", "y", "z") {
            @Override
            public String getTileUrl(int x, int y, int zoom) {
                return String.format("%s/%d/%d/%d.png", getBaseURL(), zoom, x, y);
            }
        };

        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        mapViewer1.setTileFactory(tileFactory);

        // Lokasi awal: Indonesia (latitude, longitude)
        GeoPosition indonesia = new GeoPosition(-2.5, 118.0);
        mapViewer1.setAddressLocation(indonesia);
        mapViewer1.setZoom(5);

        // Tambahkan kontrol interaktif
        MouseInputListener mia = new PanMouseInputListener(mapViewer1);
        mapViewer1.addMouseListener(mia);
        mapViewer1.addMouseMotionListener(mia);
        mapViewer1.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer1));
        mapViewer1.addMouseListener(new CenterMapListener(mapViewer1));

        // Masukkan ke panel Maps
//        Maps.setLayout(new BorderLayout());
//        Maps.removeAll();
//        Maps.add(mapViewer, BorderLayout.CENTER);
//        Maps.revalidate();
//        Maps.repaint();

    } catch (Exception e) {
        JLabel errorLabel = new JLabel("Gagal memuat peta.");
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        Maps.add(errorLabel, BorderLayout.CENTER);
    }
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
               try {
    com.formdev.flatlaf.FlatLightLaf.setup();
} catch (Exception ex) {
}

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new UserReadArea_1().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private org.jxmapviewer.JXMapViewer jXMapViewer1;
    private org.jxmapviewer.cache.NoOpLocalCache noOpLocalCache1;
    // End of variables declaration//GEN-END:variables

}
