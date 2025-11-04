package view;

import Model.BankSampah;
import Service.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class AdminAddFacilityBankSampah extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminAddFacilityBankSampah.class.getName());
    private final Service service = new Service();
    private double latitude = 0.0;
    private double longitude = 0.0;

    public AdminAddFacilityBankSampah() {
        initComponents();
        tampilkanDataFasilitas();
        setLocationRelativeTo(null);
        
        jTable2.getSelectionModel().addListSelectionListener(event -> {
    if (!event.getValueIsAdjusting() && jTable2.getSelectedRow() != -1) {
        int row = jTable2.getSelectedRow();

        // Ambil data dari tabel
        String nama = jTable2.getValueAt(row, 1).toString();
        String lokasi = jTable2.getValueAt(row, 2).toString();
        String kelurahan = jTable2.getValueAt(row, 3).toString();
        String pengelola = jTable2.getValueAt(row, 4) != null ? jTable2.getValueAt(row, 4).toString() : "";
        String kontak = jTable2.getValueAt(row, 5) != null ? jTable2.getValueAt(row, 5).toString() : "";
        String jam = jTable2.getValueAt(row, 6) != null ? jTable2.getValueAt(row, 6).toString() : "";

        // Tampilkan di form
        txtNama1.setText(nama);
        txtNamaJalan.setText(lokasi);
        comboKelurahan.setSelectedItem(kelurahan);
        txtPengelola.setText(pengelola);
        txtKontak.setText(kontak);
        txtJam.setText(jam);
    }
});
    }

    private void kosongkanField() {
        txtNama1.setText("");
        txtNamaJalan.setText("");
        txtPengelola.setText("");
        txtKontak.setText("");
        txtJam.setText("");
        comboKelurahan.setSelectedIndex(0);
        latitude = 0.0;
        longitude = 0.0;
    }

    private void tampilkanDataFasilitas() {
        try (Connection conn = service.getConnection()) {
            String sql = """
                SELECT f.id_fasilitas, f.nama_fasilitas, f.jenis_fasilitas, f.lokasi,
                       k.nama_kelurahan, b.nama_pengelola, b.kontak, b.jam_operasional,
                       f.latitude, f.longitude
                FROM fasilitas f
                JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
                LEFT JOIN bank_sampah b ON f.id_fasilitas = b.id_fasilitas
                WHERE f.jenis_fasilitas = 'Bank Sampah'
                ORDER BY f.id_fasilitas ASC
            """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID", "Nama", "Lokasi", "Kelurahan", "Pengelola", "Kontak", "Jam Operasional"}, 0
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_fasilitas"),
                    rs.getString("nama_fasilitas"),
                    rs.getString("lokasi"),
                    rs.getString("nama_kelurahan"),
                    rs.getString("nama_pengelola"),
                    rs.getString("kontak"),
                    rs.getString("jam_operasional")
                });
            }

            jTable2.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
        }
    }

    public void setSelectedCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        JOptionPane.showMessageDialog(this,
            "Lokasi dipilih:\nLatitude: " + latitude + "\nLongitude: " + longitude);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TambahFasilitasButton = new javax.swing.JButton();
        txtNamaJalan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnKembali = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pilihLokasi1 = new javax.swing.JButton();
        txtJam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboKelurahan = new javax.swing.JComboBox<>();
        txtPengelola = new javax.swing.JTextField();
        txtKontak = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        HapusFasilitasButton = new javax.swing.JButton();
        EditFasilitasButton = new javax.swing.JButton();
        lihatDetail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtNama1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 520));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setPreferredSize(new java.awt.Dimension(830, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        TambahFasilitasButton.setBackground(new java.awt.Color(204, 255, 204));
        TambahFasilitasButton.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        TambahFasilitasButton.setText("Tambah Fasilitas");
        TambahFasilitasButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TambahFasilitasButton.setFocusPainted(false);
        TambahFasilitasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahFasilitasButtonActionPerformed(evt);
            }
        });
        jPanel1.add(TambahFasilitasButton);
        TambahFasilitasButton.setBounds(210, 230, 130, 29);

        txtNamaJalan.setBackground(new java.awt.Color(230, 230, 230));
        txtNamaJalan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtNamaJalan.setBorder(null);
        txtNamaJalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaJalanActionPerformed(evt);
            }
        });
        jPanel1.add(txtNamaJalan);
        txtNamaJalan.setBounds(230, 190, 170, 29);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/map.png"))); // NOI18N
        jLabel3.setText("Nama jalan");
        jLabel3.setIconTextGap(8);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(230, 170, 100, 19);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/district.png"))); // NOI18N
        jLabel4.setText("Kelurahan");
        jLabel4.setIconTextGap(8);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(590, 90, 90, 19);

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
        btnKembali.setBounds(0, 10, 103, 26);

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Menambahkan Bank Sampah");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(620, 10, 200, 30);

        pilihLokasi1.setBackground(new java.awt.Color(204, 204, 255));
        pilihLokasi1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        pilihLokasi1.setText("Pilih Koordinat");
        pilihLokasi1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pilihLokasi1.setFocusPainted(false);
        pilihLokasi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihLokasi1ActionPerformed(evt);
            }
        });
        jPanel1.add(pilihLokasi1);
        pilihLokasi1.setBounds(70, 230, 130, 29);

        txtJam.setBackground(new java.awt.Color(230, 230, 230));
        txtJam.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtJam.setBorder(null);
        txtJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJamActionPerformed(evt);
            }
        });
        jPanel1.add(txtJam);
        txtJam.setBounds(40, 130, 180, 29);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/tag.png"))); // NOI18N
        jLabel6.setText("Nama");
        jLabel6.setIconTextGap(8);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 170, 70, 19);

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/userSmall.png"))); // NOI18N
        jLabel7.setText("Pengelola");
        jLabel7.setIconTextGap(8);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(410, 170, 100, 19);

        comboKelurahan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        comboKelurahan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bukit Pinang", "Gunung Kelua", "Air Hitam", "Sidodadi", "Teluk Lerong Ulu", "Teluk Lerong Ilir", "Pasar Pagi", "Bugis", "Pelita", "Karang Mumus", "Dadi Mulya", "Temindung Permai", "Sempaja Selatan", "Sempaja Timur", "Sempaja Utara", "Sempaja Barat", "Mugirejo", "Sungai Pinang Luar", "Sungai Pinang Dalam", "Bandara", "Loa Bakung", "Loa Buah", "Mesjid", "Baqa", "Sungai Keledang", "Harapan Baru", "Rapak Dalam", "Tani Aman", "Karang Asam Ilir", "Karang Asam Ulu", "Lok Bahu", "Karang Anyar", "Sungai Kapih", "Makroman", "Pulau Atas", "Simpang Pasir", "Handil Bakti", "Rawa Makmur", "Sungai Dama", "Sidodamai", "Gunung Lingai", "Air Putih", "Sambutan", "Jawa" }));
        comboKelurahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelurahanActionPerformed(evt);
            }
        });
        jPanel1.add(comboKelurahan);
        comboKelurahan.setBounds(590, 110, 180, 30);

        txtPengelola.setBackground(new java.awt.Color(230, 230, 230));
        txtPengelola.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtPengelola.setBorder(null);
        txtPengelola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPengelolaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPengelola);
        txtPengelola.setBounds(410, 190, 180, 29);

        txtKontak.setBackground(new java.awt.Color(230, 230, 230));
        txtKontak.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtKontak.setBorder(null);
        txtKontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKontakActionPerformed(evt);
            }
        });
        jPanel1.add(txtKontak);
        txtKontak.setBounds(600, 190, 170, 29);

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/phone.png"))); // NOI18N
        jLabel8.setText("Kontak");
        jLabel8.setIconTextGap(8);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(600, 170, 100, 19);

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/time.png"))); // NOI18N
        jLabel2.setText("Jam Operasional");
        jLabel2.setIconTextGap(8);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 70, 160, 19);

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel9.setText("Contoh 12.00 - 14.00");
        jLabel9.setIconTextGap(8);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 100, 130, 19);

        HapusFasilitasButton.setBackground(new java.awt.Color(255, 102, 102));
        HapusFasilitasButton.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        HapusFasilitasButton.setText("Hapus Fasilitas");
        HapusFasilitasButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HapusFasilitasButton.setFocusPainted(false);
        HapusFasilitasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusFasilitasButtonActionPerformed(evt);
            }
        });
        jPanel1.add(HapusFasilitasButton);
        HapusFasilitasButton.setBounds(490, 230, 120, 29);

        EditFasilitasButton.setBackground(new java.awt.Color(51, 153, 255));
        EditFasilitasButton.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        EditFasilitasButton.setText("Perbarui Fasilitas");
        EditFasilitasButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EditFasilitasButton.setFocusPainted(false);
        EditFasilitasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditFasilitasButtonActionPerformed(evt);
            }
        });
        jPanel1.add(EditFasilitasButton);
        EditFasilitasButton.setBounds(350, 230, 130, 29);

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
        lihatDetail.setBounds(620, 230, 120, 29);

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
        jScrollPane2.setBounds(0, 280, 820, 200);

        txtNama1.setBackground(new java.awt.Color(230, 230, 230));
        txtNama1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtNama1.setBorder(null);
        txtNama1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNama1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNama1);
        txtNama1.setBounds(40, 190, 180, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TambahFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahFasilitasButtonActionPerformed
        String nama = txtNama1.getText().trim();
        String lokasi = txtNamaJalan.getText().trim();
        String pengelola = txtPengelola.getText().trim();
        String kontak = txtKontak.getText().trim();
        String jam = txtJam.getText().trim();
        String kelurahan = comboKelurahan.getSelectedItem().toString();

        if (nama.isEmpty() || lokasi.isEmpty() || pengelola.isEmpty() || kontak.isEmpty() || jam.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }

        try (Connection conn = service.getConnection()) {
            conn.setAutoCommit(false);

            // Ambil id_kelurahan berdasarkan nama
            int id_kelurahan = 0;
            PreparedStatement psKel = conn.prepareStatement("SELECT id_kelurahan FROM kelurahan WHERE nama_kelurahan = ?");
            psKel.setString(1, kelurahan);
            ResultSet rsKel = psKel.executeQuery();
            if (rsKel.next()) {
                id_kelurahan = rsKel.getInt("id_kelurahan");
            } else {
                JOptionPane.showMessageDialog(this, "Kelurahan tidak ditemukan!");
                return;
            }

            // 1️⃣ Masukkan ke tabel fasilitas
            PreparedStatement psFasilitas = conn.prepareStatement("""
                INSERT INTO fasilitas (nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan, latitude, longitude)
                VALUES (?, 'Bank Sampah', ?, ?, ?, ?)
            """, Statement.RETURN_GENERATED_KEYS);
            psFasilitas.setString(1, nama);
            psFasilitas.setString(2, lokasi);
            psFasilitas.setInt(3, id_kelurahan);
            psFasilitas.setDouble(4, latitude);
            psFasilitas.setDouble(5, longitude);
            psFasilitas.executeUpdate();

            ResultSet rs = psFasilitas.getGeneratedKeys();
            int idFasilitasBaru = 0;
            if (rs.next()) {
                idFasilitasBaru = rs.getInt(1);
            }

            // 2️⃣ Masukkan ke tabel bank_sampah
            PreparedStatement psBank = conn.prepareStatement("""
                INSERT INTO bank_sampah (id_fasilitas, nama_pengelola, kontak, jam_operasional)
                VALUES (?, ?, ?, ?)
            """);
            psBank.setInt(1, idFasilitasBaru);
            psBank.setString(2, pengelola);
            psBank.setString(3, kontak);
            psBank.setString(4, jam);
            psBank.executeUpdate();

            conn.commit();
            JOptionPane.showMessageDialog(this, "Bank Sampah berhasil ditambahkan!");
            tampilkanDataFasilitas();
            kosongkanField();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan SQL: " + e.getMessage());
        }
    }//GEN-LAST:event_TambahFasilitasButtonActionPerformed

    private void txtNamaJalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaJalanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaJalanActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new AdminAddFacility().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void pilihLokasi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihLokasi1ActionPerformed
        Map map = new Map(this);
        map.setVisible(true);
    }//GEN-LAST:event_pilihLokasi1ActionPerformed

    private void txtJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJamActionPerformed

    private void comboKelurahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelurahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKelurahanActionPerformed

    private void txtPengelolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPengelolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPengelolaActionPerformed

    private void txtKontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKontakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKontakActionPerformed

    private void HapusFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusFasilitasButtonActionPerformed
        int baris = jTable2.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
            return;
        }

        int id = (int) jTable2.getValueAt(baris, 0);
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus fasilitas ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            try (Connection conn = service.getConnection()) {
                conn.setAutoCommit(false);

                PreparedStatement psBank = conn.prepareStatement("DELETE FROM bank_sampah WHERE id_fasilitas = ?");
                psBank.setInt(1, id);
                psBank.executeUpdate();

                PreparedStatement psFas = conn.prepareStatement("DELETE FROM fasilitas WHERE id_fasilitas = ?");
                psFas.setInt(1, id);
                psFas.executeUpdate();

                conn.commit();
                JOptionPane.showMessageDialog(this, "Bank Sampah berhasil dihapus!");
                tampilkanDataFasilitas();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Kesalahan SQL: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_HapusFasilitasButtonActionPerformed

    private void EditFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditFasilitasButtonActionPerformed
        int baris = jTable2.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diperbarui!");
            return;
        }

        int id = (int) jTable2.getValueAt(baris, 0);
        String nama = txtNama1.getText().trim();
        String lokasi = txtNamaJalan.getText().trim();
        String pengelola = txtPengelola.getText().trim();
        String kontak = txtKontak.getText().trim();
        String jam = txtJam.getText().trim();
        String kelurahan = comboKelurahan.getSelectedItem().toString();

        try (Connection conn = service.getConnection()) {
            conn.setAutoCommit(false);

            PreparedStatement psKel = conn.prepareStatement("SELECT id_kelurahan FROM kelurahan WHERE nama_kelurahan = ?");
            psKel.setString(1, kelurahan);
            ResultSet rsKel = psKel.executeQuery();
            int idKel = rsKel.next() ? rsKel.getInt("id_kelurahan") : 0;

            PreparedStatement ps = conn.prepareStatement("""
                UPDATE fasilitas f
                JOIN bank_sampah b ON f.id_fasilitas = b.id_fasilitas
                SET f.nama_fasilitas=?, f.lokasi=?, f.id_kelurahan=?, f.latitude=?, f.longitude=?,
                    b.nama_pengelola=?, b.kontak=?, b.jam_operasional=?
                WHERE f.id_fasilitas=?
            """);
            ps.setString(1, nama);
            ps.setString(2, lokasi);
            ps.setInt(3, idKel);
            ps.setDouble(4, latitude);
            ps.setDouble(5, longitude);
            ps.setString(6, pengelola);
            ps.setString(7, kontak);
            ps.setString(8, jam);
            ps.setInt(9, id);
            ps.executeUpdate();

            conn.commit();
            JOptionPane.showMessageDialog(this, "Data Bank Sampah berhasil diperbarui!");
            tampilkanDataFasilitas();
            kosongkanField();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan SQL: " + e.getMessage());
        }
    }//GEN-LAST:event_EditFasilitasButtonActionPerformed

    private void lihatDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatDetailActionPerformed
         int baris = jTable2.getSelectedRow();
    if (baris < 0) {
        JOptionPane.showMessageDialog(this, "Pilih fasilitas terlebih dahulu!");
        return;
    }

    int id = Integer.parseInt(jTable2.getValueAt(baris, 0).toString());

    try (Connection conn = service.getConnection()) {
        String sql = """
            SELECT f.id_fasilitas, f.nama_fasilitas, f.jenis_fasilitas, f.lokasi,
                   k.nama_kelurahan, f.latitude, f.longitude,
                   b.nama_pengelola, b.kontak, b.jam_operasional
            FROM fasilitas f
            JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
            LEFT JOIN bank_sampah b ON f.id_fasilitas = b.id_fasilitas
            WHERE f.id_fasilitas = ?
        """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            StringBuilder detail = new StringBuilder();
            detail.append("ID Fasilitas: ").append(rs.getInt("id_fasilitas")).append("\n");
            detail.append("Nama: ").append(rs.getString("nama_fasilitas")).append("\n");
            detail.append("Jenis: ").append(rs.getString("jenis_fasilitas")).append("\n");
            detail.append("Lokasi: ").append(rs.getString("lokasi")).append("\n");
            detail.append("Kelurahan: ").append(rs.getString("nama_kelurahan")).append("\n");
            detail.append("Koordinat: ").append(rs.getDouble("latitude"))
                  .append(", ").append(rs.getDouble("longitude")).append("\n\n");

            detail.append("Pengelola: ").append(rs.getString("nama_pengelola") != null ? rs.getString("nama_pengelola") : "-").append("\n");
            detail.append("Kontak: ").append(rs.getString("kontak") != null ? rs.getString("kontak") : "-").append("\n");
            detail.append("Jam Operasional: ").append(rs.getString("jam_operasional") != null ? rs.getString("jam_operasional") : "-").append("\n");

            JTextArea textArea = new JTextArea(detail.toString());
            textArea.setEditable(false);
            textArea.setFont(new java.awt.Font("Poppins", java.awt.Font.PLAIN, 13));
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scroll = new JScrollPane(textArea);
            scroll.setPreferredSize(new java.awt.Dimension(600, 400));

            JOptionPane.showMessageDialog(this, scroll,
                    "Detail Bank Sampah", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan di database.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan SQL: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_lihatDetailActionPerformed

    private void txtNama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNama1ActionPerformed

public static void main(String args[]) {
        try {
    com.formdev.flatlaf.FlatLightLaf.setup();
} catch (Exception ex) {
    logger.log(java.util.logging.Level.SEVERE, "Failed to initialize FlatLaf", ex);
}
        java.awt.EventQueue.invokeLater(() -> new AdminAddFacilityBankSampah().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditFasilitasButton;
    private javax.swing.JButton HapusFasilitasButton;
    private javax.swing.JButton TambahFasilitasButton;
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<String> comboKelurahan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton lihatDetail;
    private javax.swing.JButton pilihLokasi1;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtKontak;
    private javax.swing.JTextField txtNama1;
    private javax.swing.JTextField txtNamaJalan;
    private javax.swing.JTextField txtPengelola;
    // End of variables declaration//GEN-END:variables
}
