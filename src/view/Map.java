package view;

import Model.Fasilitas;
import Service.Service;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class Map extends javax.swing.JFrame {

    private final Service service = new Service();
    private double selectedLatitude = 0.0;
    private double selectedLongitude = 0.0;
    private DefaultWaypoint selectedWaypoint;
    private WaypointPainter<Waypoint> painter;
    private Set<Waypoint> waypoints = new HashSet<>();

    private Object parentForm; // bisa dari UserAddReport atau AdminAddFacility

    // === Constructor default ===
    public Map() {
        initComponents();
        initMap(-0.46747434, 117.15747892); // default Samarinda
        setLocationRelativeTo(null);
    }

    // === Constructor dengan koordinat spesifik ===
    public Map(double lat, double lon) {
        initComponents();
        initMap(lat, lon);
        setLocationRelativeTo(null);
    }

    // === Constructor dengan parent (UserAddReport/AdminAddFacility) ===
    public Map(Object parent) {
        this();
        this.parentForm = parent;
    }
    
    public Map(Object parent, double lat, double lon) {
        this.parentForm = parent;
        initComponents();
        initMap(lat, lon);
        setLocationRelativeTo(null);
    }

    // === Inisialisasi peta ===
    private void initMap(double lat, double lon) {
        TileFactoryInfo info = new OSMTileFactoryInfo("OpenStreetMap", "https://tile.openstreetmap.org");
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer1.setTileFactory(tileFactory);

        GeoPosition start = new GeoPosition(lat, lon);
        jXMapViewer1.setAddressLocation(start);
        jXMapViewer1.setZoom(5);

        MouseInputListener mm = new PanMouseInputListener(jXMapViewer1);
        jXMapViewer1.addMouseListener(mm);
        jXMapViewer1.addMouseMotionListener(mm);
        jXMapViewer1.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer1));
        
        painter = new WaypointPainter<>();
        painter.setWaypoints(waypoints);
        jXMapViewer1.setOverlayPainter(painter);
  
            // Tambahkan marker lokasi laporan saat peta dibuka
        if (lat != 0 && lon != 0) {
            GeoPosition pos = new GeoPosition(lat, lon);
            DefaultWaypoint waypoint = new DefaultWaypoint(pos);
            waypoints.clear();
            waypoints.add(waypoint);

            painter.setWaypoints(waypoints);
            jXMapViewer1.setOverlayPainter(painter);
            jXMapViewer1.setAddressLocation(pos);
            jXMapViewer1.setZoom(6); // zoom biar fokus ke titik laporan
            jXMapViewer1.repaint();
        }

        // klik kiri = pilih titik baru
        // klik kiri = pilih titik baru
jXMapViewer1.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            GeoPosition geo = jXMapViewer1.convertPointToGeoPosition(e.getPoint());
            selectedLatitude = geo.getLatitude();
            selectedLongitude = geo.getLongitude();

            System.out.println("Klik di: " + selectedLatitude + ", " + selectedLongitude);

            selectedWaypoint = new DefaultWaypoint(geo);
            waypoints.clear();
            waypoints.add(selectedWaypoint);

            painter.setWaypoints(waypoints);
            jXMapViewer1.setOverlayPainter(painter);
            jXMapViewer1.repaint();

            // Kirim data koordinat ke form asal
            if (parentForm != null) {
                if (parentForm instanceof AdminAddFacilityTPA formTPA) {
                    formTPA.setSelectedCoordinates(selectedLatitude, selectedLongitude);
                } else if (parentForm instanceof AdminAddFacilityTapak formTapak) {
                    formTapak.setSelectedCoordinates(selectedLatitude, selectedLongitude);
                } else if (parentForm instanceof AdminAddFacilityBankSampah formBank) {
                    formBank.setSelectedCoordinates(selectedLatitude, selectedLongitude);
                } else if (parentForm instanceof UserAddReport formUser) {
                    formUser.setSelectedCoordinates(selectedLatitude, selectedLongitude);
                }
            }

            // 🔹 Tutup map setelah klik titik
            JOptionPane.showMessageDialog(null, "Koordinat dipilih!\nLatitude: " + selectedLatitude + "\nLongitude: " + selectedLongitude);
            dispose();
        }
    }
});
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapViewer1 = new org.jxmapviewer.JXMapViewer();
        Kembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Kembali.setBackground(new java.awt.Color(255, 255, 255));
        Kembali.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        Kembali.setForeground(new java.awt.Color(0, 0, 0));
        Kembali.setText("Kembali");
        Kembali.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewer1Layout = new javax.swing.GroupLayout(jXMapViewer1);
        jXMapViewer1.setLayout(jXMapViewer1Layout);
        jXMapViewer1Layout.setHorizontalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapViewer1Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );
        jXMapViewer1Layout.setVerticalGroup(
            jXMapViewer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapViewer1Layout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addComponent(Kembali)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jXMapViewer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXMapViewer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public static void main(String args[]) {
        try {
            FlatLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Gagal inisialisasi FlatLaf: " + ex.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> new Map().setVisible(true));
    }
    
    private void KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliActionPerformed
    if (parentForm != null) {
        if (parentForm instanceof AdminAddFacilityTPA formTPA) {
            formTPA.setSelectedCoordinates(selectedLatitude, selectedLongitude);
        } else if (parentForm instanceof AdminAddFacilityTapak formTapak) {
            formTapak.setSelectedCoordinates(selectedLatitude, selectedLongitude);
        } else if (parentForm instanceof AdminAddFacilityBankSampah formBank) {
            formBank.setSelectedCoordinates(selectedLatitude, selectedLongitude);
        } else if (parentForm instanceof UserAddReport formUser) {
            formUser.setSelectedCoordinates(selectedLatitude, selectedLongitude);
        } else if (parentForm instanceof AdminEditReport) {
            // Tidak kirim koordinat, hanya tutup map
        }
        
    }
    this.dispose();
    }//GEN-LAST:event_KembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kembali;
    private org.jxmapviewer.JXMapViewer jXMapViewer1;
    // End of variables declaration//GEN-END:variables
}
