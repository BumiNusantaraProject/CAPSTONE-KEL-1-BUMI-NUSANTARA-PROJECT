package view;

import Service.Service;
import com.formdev.flatlaf.FlatLightLaf;
import static com.mysql.cj.conf.PropertyKey.logger;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import java.sql.*;
import view.Map;

public class UserAddReport extends javax.swing.JFrame {
    
    private int userId;
    private File imageFile;
    private double latitude = 0.0;
    private double longitude = 0.0;
    private Service service = new Service();
    
    public UserAddReport(int userId) {
        initComponents();
        this.userId = userId;
        setLocationRelativeTo(null);
    }
    
    public UserAddReport() {
        initComponents();
        this.userId = 1; // default sementara
        setLocationRelativeTo(null);
    }
    
    private void clearInput() {
        txtAlamat.setText("");
        txtDeskripsi.setText("");
        imageFile = null;
        latitude = 0.0;
        longitude = 0.0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kirimLaporan = new javax.swing.JButton();
        txtAlamat = new javax.swing.JTextField();
        uploadFoto = new javax.swing.JButton();
        pilihLokasi = new javax.swing.JButton();
        lihatLaporan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbKelurahan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 520));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setPreferredSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Isi laporan kamu!");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 170, 105, 19);

        kirimLaporan.setBackground(new java.awt.Color(53, 75, 11));
        kirimLaporan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        kirimLaporan.setForeground(new java.awt.Color(255, 255, 255));
        kirimLaporan.setText("Laporkan!");
        kirimLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimLaporanActionPerformed(evt);
            }
        });
        jPanel2.add(kirimLaporan);
        kirimLaporan.setBounds(30, 430, 445, 40);

        txtAlamat.setBackground(new java.awt.Color(204, 204, 204));
        txtAlamat.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });
        jPanel2.add(txtAlamat);
        txtAlamat.setBounds(30, 280, 450, 25);

        uploadFoto.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        uploadFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/pictures.png"))); // NOI18N
        uploadFoto.setText("Upload foto");
        uploadFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        uploadFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFotoActionPerformed(evt);
            }
        });
        jPanel2.add(uploadFoto);
        uploadFoto.setBounds(30, 380, 202, 33);

        pilihLokasi.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        pilihLokasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/map.png"))); // NOI18N
        pilihLokasi.setText("Pilih lokasi");
        pilihLokasi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        pilihLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihLokasiActionPerformed(evt);
            }
        });
        jPanel2.add(pilihLokasi);
        pilihLokasi.setBounds(240, 380, 236, 33);

        lihatLaporan.setBackground(new java.awt.Color(53, 75, 11));
        lihatLaporan.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        lihatLaporan.setForeground(new java.awt.Color(255, 255, 255));
        lihatLaporan.setText("Lihat laporan lain!");
        lihatLaporan.setBorderPainted(false);
        lihatLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatLaporanActionPerformed(evt);
            }
        });
        jPanel2.add(lihatLaporan);
        lihatLaporan.setBounds(340, 10, 140, 30);

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Kelurahan");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 320, 63, 13);

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
        jPanel2.add(btnKembali);
        btnKembali.setBounds(0, 13, 103, 26);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 55, 500, 20);

        jLabel7.setFont(new java.awt.Font("Poppins ExtraBold", 1, 28)); // NOI18N
        jLabel7.setText("<html>Laporkan <br>masalah anda!");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 70, 235, 68);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Alamat");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 260, 68, 19);

        cmbKelurahan.setBackground(new java.awt.Color(204, 204, 204));
        cmbKelurahan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        cmbKelurahan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bukit Pinang", "Gunung Kelua", "Air Hitam", "Sidodadi", "Teluk Lerong Ulu", "Teluk Lerong Ilir", "Pasar Pagi", "Bugis", "Pelita", "Karang Mumus", "Dadi Mulya", "Temindung Permai", "Sempaja Selatan", "Sempaja Timur", "Sempaja Utara", "Sempaja Barat", "Mugirejo", "Sungai Pinang Luar", "Sungai Pinang Dalam", "Bandara", "Loa Bakung", "Loa Buah", "Mesjid", "Baqa", "Sungai Keledang", "Harapan Baru", "Rapak Dalam", "Tani Aman", "Karang Asam Ilir", "Karang Asam Ulu", "Lok Bahu", "Karang Anyar", "Sungai Kapih", "Makroman", "Pulau Atas", "Simpang Pasir", "Handil Bakti", "Rawa Makmur", "Sungai Dama", "Sidodamai", "Gunung Lingai", "Air Putih", "Sambutan", "Jawa" }));
        cmbKelurahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKelurahanActionPerformed(evt);
            }
        });
        jPanel2.add(cmbKelurahan);
        cmbKelurahan.setBounds(30, 340, 445, 25);

        txtDeskripsi.setBackground(new java.awt.Color(204, 204, 204));
        txtDeskripsi.setColumns(20);
        txtDeskripsi.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtDeskripsi.setRows(5);
        jScrollPane1.setViewportView(txtDeskripsi);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 190, 445, 59);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 500, 490);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PictBuatLaporan.jpg"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(393, 0, 430, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void lihatLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatLaporanActionPerformed
        this.dispose(); // menutup halaman LoginMenu
    new UserReadReport().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_lihatLaporanActionPerformed

    private void pilihLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihLokasiActionPerformed
        Map mapForm = new Map(this);
        mapForm.setVisible(true);
    }//GEN-LAST:event_pilihLokasiActionPerformed

    private void uploadFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFotoActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar", "jpg", "jpeg", "png"));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            imageFile = chooser.getSelectedFile();
        }
    }//GEN-LAST:event_uploadFotoActionPerformed

    private void kirimLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimLaporanActionPerformed
        try {
            String alamat = txtAlamat.getText().trim();
            String deskripsi = txtDeskripsi.getText().trim();
            String kelurahan = cmbKelurahan.getSelectedItem().toString();

            if (alamat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Alamat wajib diisi!");
                return;
            }
            if (imageFile == null) {
                JOptionPane.showMessageDialog(this, "Pilih foto terlebih dahulu!");
                return;
            }
            if (latitude == 0.0 || longitude == 0.0) {
                JOptionPane.showMessageDialog(this, "Pilih lokasi terlebih dahulu!");
                return;
            }
            
            int idKelurahan = service.getIdKelurahanByName(kelurahan);

            // Konversi file ke byte[]
            FileInputStream fis = new FileInputStream(imageFile);
            byte[] fotoBytes = fis.readAllBytes();
            fis.close();

            String sql = "INSERT INTO laporan (id_user, id_kelurahan, alamat_lokasi, foto, deksripsi, status, tanggal_lapor, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conn = service.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, idKelurahan);
            ps.setString(3, alamat);
            ps.setBytes(4, fotoBytes);
            ps.setString(5, deskripsi);
            ps.setString(6, "ditinjau");
            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            ps.setDouble(8, latitude);
            ps.setDouble(9, longitude);

            int rows = ps.executeUpdate();
            ps.close();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Laporan berhasil dikirim!");
                clearInput();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengirim laporan!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_kirimLaporanActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new UserHomeMenu_1().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        String alamat = txtAlamat.getText().trim();
        if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Alamat lokasi tersimpan sementara: " + alamat);
        }
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void cmbKelurahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKelurahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKelurahanActionPerformed
       
    public void setSelectedCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

    }

            
public static void main(String[] args) {
    try {
            FlatLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Gagal load tema FlatLaf: " + ex.getMessage());
        }

    SwingUtilities.invokeLater(() -> {
        UserAddReport form = new UserAddReport();
        form.setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<String> cmbKelurahan;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton kirimLaporan;
    private javax.swing.JButton lihatLaporan;
    private javax.swing.JButton pilihLokasi;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JButton uploadFoto;
    // End of variables declaration//GEN-END:variables
}