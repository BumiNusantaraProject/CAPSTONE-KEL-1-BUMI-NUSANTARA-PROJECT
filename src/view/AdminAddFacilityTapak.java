package view;

import javax.swing.*;
import java.sql.*;
import Service.Service;
import javax.swing.table.DefaultTableModel;

public class AdminAddFacilityTapak extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminAddFacilityTapak.class.getName());
    private final Service service = new Service();
    private double latitude = 0.0;
    private double longitude = 0.0;

    public AdminAddFacilityTapak() {
        initComponents();
        setLocationRelativeTo(null);
        tampilkanDataFasilitas();

        // Saat klik tabel → isi field
        tblFasilitas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblFasilitas.getSelectedRow() != -1) {
                isiFieldDariTabel();
            }
        });
    }

    // ---------------------------
    // 🔹 Method bantu
    // ---------------------------

    private void kosongkanField() {
        txtNama.setText("");
        txtNamaJalan.setText("");
        txtLuasLahan.setText("");
        comboKondisi.setSelectedIndex(0);
        comboJenis.setSelectedIndex(0);
        comboKelurahan.setSelectedIndex(0);
        latitude = 0.0;
        longitude = 0.0;
    }

    private void tampilkanDataFasilitas() {
        try (Connection conn = service.getConnection()) {
            String sql = """
                SELECT f.id_fasilitas, f.nama_fasilitas, f.jenis_fasilitas, f.lokasi,
                       k.nama_kelurahan, f.latitude, f.longitude,
                       t.luas_lahan, t.kondisi
                FROM fasilitas f
                JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
                LEFT JOIN tapak_berkelanjutan t ON f.id_fasilitas = t.id_fasilitas
                WHERE f.jenis_fasilitas IN ('Taman', 'Hutan Kota', 'Jalur Hijau', 'RTH', 'Waduk')
                ORDER BY f.id_fasilitas ASC
            """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID", "Nama", "Jenis", "Lokasi", "Kelurahan", "Latitude", "Longitude", "Luas Lahan (m²)", "Kondisi"}, 0
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_fasilitas"),
                    rs.getString("nama_fasilitas"),
                    rs.getString("jenis_fasilitas"),
                    rs.getString("lokasi"),
                    rs.getString("nama_kelurahan"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"),
                    rs.getDouble("luas_lahan"),
                    rs.getString("kondisi")
                });
            }

            tblFasilitas.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
        }
    }

    private void isiFieldDariTabel() {
        int baris = tblFasilitas.getSelectedRow();
        if (baris >= 0) {
            txtNama.setText(tblFasilitas.getValueAt(baris, 1).toString());
            comboJenis.setSelectedItem(tblFasilitas.getValueAt(baris, 2).toString());
            txtNamaJalan.setText(tblFasilitas.getValueAt(baris, 3).toString());
            comboKelurahan.setSelectedItem(tblFasilitas.getValueAt(baris, 4).toString());
            txtLuasLahan.setText(tblFasilitas.getValueAt(baris, 7).toString());
            comboKondisi.setSelectedItem(tblFasilitas.getValueAt(baris, 8).toString());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnKembali = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboJenis = new javax.swing.JComboBox<>();
        comboKondisi = new javax.swing.JComboBox<>();
        pilihLokasi1 = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        txtLuasLahan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboKelurahan = new javax.swing.JComboBox<>();
        HapusFasilitasButton = new javax.swing.JButton();
        EditFasilitasButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFasilitas = new javax.swing.JTable();
        lihatDetail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(830, 520));
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
        TambahFasilitasButton.setBounds(220, 210, 120, 29);

        txtNamaJalan.setBackground(new java.awt.Color(230, 230, 230));
        txtNamaJalan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtNamaJalan.setBorder(null);
        txtNamaJalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaJalanActionPerformed(evt);
            }
        });
        jPanel1.add(txtNamaJalan);
        txtNamaJalan.setBounds(520, 90, 180, 29);

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/emoticon.png"))); // NOI18N
        jLabel1.setText("Kondisi");
        jLabel1.setIconTextGap(8);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(320, 140, 80, 19);

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/eco-friendly-house.png"))); // NOI18N
        jLabel2.setText("Jenis");
        jLabel2.setIconTextGap(8);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(320, 70, 60, 19);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/map.png"))); // NOI18N
        jLabel3.setText("Nama jalan");
        jLabel3.setIconTextGap(8);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(520, 70, 100, 19);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/district.png"))); // NOI18N
        jLabel4.setText("Kelurahan");
        jLabel4.setIconTextGap(8);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(520, 140, 100, 19);

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
        jLabel5.setText("Menambahkan Tapak Berkelanjutan");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(580, 10, 240, 30);

        comboJenis.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Taman", "Hutan kota", "Jalur hijau", "Hutan kota", "Waduk" }));
        comboJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJenisActionPerformed(evt);
            }
        });
        jPanel1.add(comboJenis);
        comboJenis.setBounds(320, 90, 190, 30);

        comboKondisi.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        comboKondisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "buruk", "cukup", "baik", "sangat Baik", " " }));
        comboKondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKondisiActionPerformed(evt);
            }
        });
        jPanel1.add(comboKondisi);
        comboKondisi.setBounds(320, 160, 190, 30);

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
        pilihLokasi1.setBounds(90, 210, 120, 29);

        txtNama.setBackground(new java.awt.Color(230, 230, 230));
        txtNama.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtNama.setBorder(null);
        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNama);
        txtNama.setBounds(130, 90, 180, 29);

        txtLuasLahan.setBackground(new java.awt.Color(230, 230, 230));
        txtLuasLahan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtLuasLahan.setBorder(null);
        txtLuasLahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuasLahanActionPerformed(evt);
            }
        });
        jPanel1.add(txtLuasLahan);
        txtLuasLahan.setBounds(130, 160, 180, 29);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/tag.png"))); // NOI18N
        jLabel6.setText("Nama");
        jLabel6.setIconTextGap(8);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 70, 70, 19);

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/measuring-tape.png"))); // NOI18N
        jLabel7.setText("Luas lahan");
        jLabel7.setIconTextGap(8);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(130, 140, 100, 19);

        comboKelurahan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        comboKelurahan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bukit Pinang", "Gunung Kelua", "Air Hitam", "Sidodadi", "Teluk Lerong Ulu", "Teluk Lerong Ilir", "Pasar Pagi", "Bugis", "Pelita", "Karang Mumus", "Dadi Mulya", "Temindung Permai", "Sempaja Selatan", "Sempaja Timur", "Sempaja Utara", "Sempaja Barat", "Mugirejo", "Sungai Pinang Luar", "Sungai Pinang Dalam", "Bandara", "Loa Bakung", "Loa Buah", "Mesjid", "Baqa", "Sungai Keledang", "Harapan Baru", "Rapak Dalam", "Tani Aman", "Karang Asam Ilir", "Karang Asam Ulu", "Lok Bahu", "Karang Anyar", "Sungai Kapih", "Makroman", "Pulau Atas", "Simpang Pasir", "Handil Bakti", "Rawa Makmur", "Sungai Dama", "Sidodamai", "Gunung Lingai", "Air Putih", "Sambutan", "Jawa" }));
        comboKelurahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelurahanActionPerformed(evt);
            }
        });
        jPanel1.add(comboKelurahan);
        comboKelurahan.setBounds(520, 160, 190, 30);

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
        HapusFasilitasButton.setBounds(350, 210, 120, 29);

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
        EditFasilitasButton.setBounds(480, 210, 130, 29);

        tblFasilitas.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tblFasilitas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFasilitas.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tblFasilitas);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 260, 820, 210);

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
        lihatDetail.setBounds(620, 210, 120, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TambahFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahFasilitasButtonActionPerformed
    String nama = txtNama.getText().trim();
        String jenis = comboJenis.getSelectedItem().toString();
        String lokasi = txtNamaJalan.getText().trim();
        String kelurahan = comboKelurahan.getSelectedItem().toString();
        String kondisi = comboKondisi.getSelectedItem().toString();
        String luasStr = txtLuasLahan.getText().trim();

        if (nama.isEmpty() || lokasi.isEmpty() || luasStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi semua kolom terlebih dahulu!");
            return;
        }

        try (Connection conn = service.getConnection()) {
            double luas = Double.parseDouble(luasStr);

            // Cari id_kelurahan
            int idKelurahan = 0;
            PreparedStatement psKel = conn.prepareStatement("SELECT id_kelurahan FROM kelurahan WHERE nama_kelurahan = ?");
            psKel.setString(1, kelurahan);
            ResultSet rsKel = psKel.executeQuery();
            if (rsKel.next()) idKelurahan = rsKel.getInt("id_kelurahan");

            // Insert ke fasilitas
            PreparedStatement psFas = conn.prepareStatement("""
                INSERT INTO fasilitas (nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan, latitude, longitude)
                VALUES (?, ?, ?, ?, ?, ?)
            """, Statement.RETURN_GENERATED_KEYS);
            psFas.setString(1, nama);
            psFas.setString(2, jenis);
            psFas.setString(3, lokasi);
            psFas.setInt(4, idKelurahan);
            psFas.setDouble(5, latitude);
            psFas.setDouble(6, longitude);
            psFas.executeUpdate();

            ResultSet genKeys = psFas.getGeneratedKeys();
            int idFasilitas = 0;
            if (genKeys.next()) idFasilitas = genKeys.getInt(1);

            // Insert ke tapak_berkelanjutan
            PreparedStatement psTapak = conn.prepareStatement("""
                INSERT INTO tapak_berkelanjutan (id_fasilitas, luas_lahan, kondisi)
                VALUES (?, ?, ?)
            """);
            psTapak.setInt(1, idFasilitas);
            psTapak.setDouble(2, luas);
            psTapak.setString(3, kondisi);
            psTapak.executeUpdate();

            tampilkanDataFasilitas();
            kosongkanField();
            JOptionPane.showMessageDialog(this, "Fasilitas berhasil ditambahkan!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_TambahFasilitasButtonActionPerformed

    private void txtNamaJalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaJalanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaJalanActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // menutup halaman LoginMenu
        new AdminAddFacility().setVisible(true); // membuka halaman LoginUser
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void comboJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJenisActionPerformed

    }//GEN-LAST:event_comboJenisActionPerformed

    private void comboKondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKondisiActionPerformed

    }//GEN-LAST:event_comboKondisiActionPerformed

    private void pilihLokasi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihLokasi1ActionPerformed
        Map map = new Map(this);
        map.setVisible(true);
    }//GEN-LAST:event_pilihLokasi1ActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtLuasLahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuasLahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuasLahanActionPerformed

    private void comboKelurahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelurahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKelurahanActionPerformed

    private void HapusFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusFasilitasButtonActionPerformed
        int baris = tblFasilitas.getSelectedRow();
        if (baris < 0) {
            JOptionPane.showMessageDialog(this, "Pilih fasilitas yang akan dihapus!");
            return;
        }

        int id = Integer.parseInt(tblFasilitas.getValueAt(baris, 0).toString());
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus fasilitas ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            try (Connection conn = service.getConnection()) {
                // Hapus dari tapak_berkelanjutan dulu
                PreparedStatement psTapak = conn.prepareStatement("DELETE FROM tapak_berkelanjutan WHERE id_fasilitas=?");
                psTapak.setInt(1, id);
                psTapak.executeUpdate();

                // Hapus dari fasilitas
                PreparedStatement psFas = conn.prepareStatement("DELETE FROM fasilitas WHERE id_fasilitas=?");
                psFas.setInt(1, id);
                psFas.executeUpdate();

                tampilkanDataFasilitas();
                kosongkanField();
                JOptionPane.showMessageDialog(this, "Fasilitas berhasil dihapus!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Kesalahan: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_HapusFasilitasButtonActionPerformed

    private void EditFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditFasilitasButtonActionPerformed
        int baris = tblFasilitas.getSelectedRow();
        if (baris < 0) {
            JOptionPane.showMessageDialog(this, "Pilih fasilitas yang akan diperbarui!");
            return;
        }

        try (Connection conn = service.getConnection()) {
            int id = (int) tblFasilitas.getValueAt(baris, 0);
            String nama = txtNama.getText().trim();
            String jenis = comboJenis.getSelectedItem().toString();
            String lokasi = txtNamaJalan.getText().trim();
            String kelurahan = comboKelurahan.getSelectedItem().toString();
            String kondisi = comboKondisi.getSelectedItem().toString();
            double luas = Double.parseDouble(txtLuasLahan.getText().trim());

            // Cari id_kelurahan
            int idKelurahan = 0;
            PreparedStatement psKel = conn.prepareStatement("SELECT id_kelurahan FROM kelurahan WHERE nama_kelurahan = ?");
            psKel.setString(1, kelurahan);
            ResultSet rs = psKel.executeQuery();
            if (rs.next()) idKelurahan = rs.getInt("id_kelurahan");

            // Update fasilitas
            PreparedStatement psFas = conn.prepareStatement("""
                UPDATE fasilitas
                SET nama_fasilitas=?, jenis_fasilitas=?, lokasi=?, id_kelurahan=?, latitude=?, longitude=?
                WHERE id_fasilitas=?
            """);
            psFas.setString(1, nama);
            psFas.setString(2, jenis);
            psFas.setString(3, lokasi);
            psFas.setInt(4, idKelurahan);
            psFas.setDouble(5, latitude);
            psFas.setDouble(6, longitude);
            psFas.setInt(7, id);
            psFas.executeUpdate();

            // Update tapak_berkelanjutan
            PreparedStatement psTapak = conn.prepareStatement("""
                UPDATE tapak_berkelanjutan
                SET luas_lahan=?, kondisi=?
                WHERE id_fasilitas=?
            """);
            psTapak.setDouble(1, luas);
            psTapak.setString(2, kondisi);
            psTapak.setInt(3, id);
            psTapak.executeUpdate();

            tampilkanDataFasilitas();
            kosongkanField();
            JOptionPane.showMessageDialog(this, "Data fasilitas berhasil diperbarui!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_EditFasilitasButtonActionPerformed

    private void lihatDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatDetailActionPerformed
        int baris = tblFasilitas.getSelectedRow();
        if (baris < 0) {
            JOptionPane.showMessageDialog(this, "Pilih fasilitas terlebih dahulu!");
            return;
        }

        int id = Integer.parseInt(tblFasilitas.getValueAt(baris, 0).toString());

        try (Connection conn = service.getConnection()) {
            String sql = """
                SELECT f.nama_fasilitas, f.jenis_fasilitas, f.lokasi, k.nama_kelurahan,
                       f.latitude, f.longitude, t.luas_lahan, t.kondisi
                FROM fasilitas f
                JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
                LEFT JOIN tapak_berkelanjutan t ON f.id_fasilitas = t.id_fasilitas
                WHERE f.id_fasilitas = ?
            """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                StringBuilder detail = new StringBuilder();
                detail.append("Nama: ").append(rs.getString("nama_fasilitas")).append("\n");
                detail.append("Jenis: ").append(rs.getString("jenis_fasilitas")).append("\n");
                detail.append("Lokasi: ").append(rs.getString("lokasi")).append("\n");
                detail.append("Kelurahan: ").append(rs.getString("nama_kelurahan")).append("\n");
                detail.append("Koordinat: ").append(rs.getDouble("latitude")).append(", ")
                      .append(rs.getDouble("longitude")).append("\n\n");
                detail.append("Luas Lahan: ").append(rs.getDouble("luas_lahan")).append(" m²\n");
                detail.append("Kondisi: ").append(rs.getString("kondisi")).append("\n");

                JTextArea area = new JTextArea(detail.toString());
                area.setEditable(false);
                area.setFont(new java.awt.Font("Poppins", java.awt.Font.BOLD, 12));
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                JScrollPane scroll = new JScrollPane(area);
                scroll.setPreferredSize(new java.awt.Dimension(400, 250));

                JOptionPane.showMessageDialog(this, scroll, "Detail Tapak Berkelanjutan", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Data detail tidak ditemukan.");
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
        java.awt.EventQueue.invokeLater(() -> new AdminAddFacilityTapak().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditFasilitasButton;
    private javax.swing.JButton HapusFasilitasButton;
    private javax.swing.JButton TambahFasilitasButton;
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JComboBox<String> comboKelurahan;
    private javax.swing.JComboBox<String> comboKondisi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton lihatDetail;
    private javax.swing.JButton pilihLokasi1;
    private javax.swing.JTable tblFasilitas;
    private javax.swing.JTextField txtLuasLahan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaJalan;
    // End of variables declaration//GEN-END:variables
}
