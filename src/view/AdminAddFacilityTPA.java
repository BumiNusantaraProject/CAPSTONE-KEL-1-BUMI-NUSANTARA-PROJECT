package view;

import javax.swing.*;
import java.sql.*;
import Service.Service;
import javax.swing.table.DefaultTableModel;

public class AdminAddFacilityTPA extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminAddFacilityTPA.class.getName());
    private final Service service = new Service();
    private double latitude = 0.0;
    private double longitude = 0.0;

    public AdminAddFacilityTPA() {
        initComponents();
        setLocationRelativeTo(null);
        tampilkanDataFasilitas();

        // Saat baris tabel diklik → isi field input
        jTable2.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable2.getSelectedRow() != -1) {
                isiFieldDariTabel();
            }
        });
    }

    // 🔹 Reset semua field
    private void kosongkanField() {
        txtNama.setText("");
        txtNamaJalan.setText("");
        txtKapasitasMaksimum.setText("");
        comboKelurahan.setSelectedIndex(0);
        comboJenis.setSelectedIndex(0);
        comboStatus.setSelectedIndex(0);
        latitude = 0.0;
        longitude = 0.0;
    }

    // 🔹 Tampilkan semua data fasilitas TPA/TPS/TPS3R
    private void tampilkanDataFasilitas() {
        try (Connection conn = service.getConnection()) {
            String sql = """
                SELECT f.id_fasilitas, f.nama_fasilitas, f.jenis_fasilitas, f.lokasi,
                       k.nama_kelurahan, f.latitude, f.longitude, t.status, t.kapasitas_maks_ton
                FROM fasilitas f
                JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
                LEFT JOIN tpa t ON f.id_fasilitas = t.id_fasilitas
                WHERE f.jenis_fasilitas IN ('TPA', 'TPS', 'TPS3R')
                ORDER BY f.id_fasilitas ASC
            """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"ID", "Nama", "Jenis", "Lokasi", "Kelurahan", "Latitude", "Longitude", "Status", "Kapasitas (ton)"}, 0
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
                        rs.getString("status"),
                        rs.getDouble("kapasitas_maks_ton")
                });
            }

            jTable2.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
        }
    }

    // 🔹 Isi field dari baris tabel yang diklik
    private void isiFieldDariTabel() {
        int baris = jTable2.getSelectedRow();
        if (baris >= 0) {
            txtNama.setText(jTable2.getValueAt(baris, 1).toString());
            comboJenis.setSelectedItem(jTable2.getValueAt(baris, 2).toString());
            txtNamaJalan.setText(jTable2.getValueAt(baris, 3).toString());
            comboKelurahan.setSelectedItem(jTable2.getValueAt(baris, 4).toString());
            comboStatus.setSelectedItem(jTable2.getValueAt(baris, 7));
            txtKapasitasMaksimum.setText(jTable2.getValueAt(baris, 8).toString());
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
        pilihLokasi1 = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        txtKapasitasMaksimum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboKelurahan = new javax.swing.JComboBox<>();
        HapusFasilitasButton = new javax.swing.JButton();
        EditFasilitasButton = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox<>();
        lihatDetail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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
        txtNamaJalan.setBounds(530, 90, 180, 29);

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/settings.png"))); // NOI18N
        jLabel1.setText("Kapasitas Maksimum");
        jLabel1.setIconTextGap(8);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(530, 140, 160, 16);

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/eco-friendly-house.png"))); // NOI18N
        jLabel2.setText("Jenis");
        jLabel2.setIconTextGap(8);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(330, 70, 60, 16);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/map.png"))); // NOI18N
        jLabel3.setText("Nama jalan");
        jLabel3.setIconTextGap(8);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(530, 70, 100, 16);

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/district.png"))); // NOI18N
        jLabel4.setText("Kelurahan");
        jLabel4.setIconTextGap(8);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 140, 100, 16);

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
        btnKembali.setBounds(0, 10, 96, 23);

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Menambahkan TPA");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(670, 10, 150, 30);

        comboJenis.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        comboJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TPA", "TPS", "TPS3R" }));
        comboJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJenisActionPerformed(evt);
            }
        });
        jPanel1.add(comboJenis);
        comboJenis.setBounds(330, 90, 190, 30);

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
        txtNama.setBounds(130, 90, 190, 29);

        txtKapasitasMaksimum.setBackground(new java.awt.Color(230, 230, 230));
        txtKapasitasMaksimum.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        txtKapasitasMaksimum.setBorder(null);
        txtKapasitasMaksimum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKapasitasMaksimumActionPerformed(evt);
            }
        });
        jPanel1.add(txtKapasitasMaksimum);
        txtKapasitasMaksimum.setBounds(530, 160, 180, 29);

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/tag.png"))); // NOI18N
        jLabel6.setText("Nama");
        jLabel6.setIconTextGap(8);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 70, 70, 16);

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/loading.png"))); // NOI18N
        jLabel7.setText("Status");
        jLabel7.setIconTextGap(8);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(330, 140, 100, 16);

        comboKelurahan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        comboKelurahan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bukit Pinang", "Gunung Kelua", "Air Hitam", "Sidodadi", "Teluk Lerong Ulu", "Teluk Lerong Ilir", "Pasar Pagi", "Bugis", "Pelita", "Karang Mumus", "Dadi Mulya", "Temindung Permai", "Sempaja Selatan", "Sempaja Timur", "Sempaja Utara", "Sempaja Barat", "Mugirejo", "Sungai Pinang Luar", "Sungai Pinang Dalam", "Bandara", "Loa Bakung", "Loa Buah", "Mesjid", "Baqa", "Sungai Keledang", "Harapan Baru", "Rapak Dalam", "Tani Aman", "Karang Asam Ilir", "Karang Asam Ulu", "Lok Bahu", "Karang Anyar", "Sungai Kapih", "Makroman", "Pulau Atas", "Simpang Pasir", "Handil Bakti", "Rawa Makmur", "Sungai Dama", "Sidodamai", "Gunung Lingai", "Air Putih", "Sambutan", "Jawa" }));
        comboKelurahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelurahanActionPerformed(evt);
            }
        });
        jPanel1.add(comboKelurahan);
        comboKelurahan.setBounds(130, 160, 190, 30);

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
        HapusFasilitasButton.setBounds(500, 210, 120, 29);

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
        EditFasilitasButton.setBounds(350, 210, 140, 29);

        comboStatus.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "aktif", "Non-aktif" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });
        jPanel1.add(comboStatus);
        comboStatus.setBounds(330, 160, 190, 30);

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
        lihatDetail.setBounds(630, 210, 120, 29);

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
        jScrollPane2.setBounds(0, 260, 820, 210);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 820, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TambahFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahFasilitasButtonActionPerformed
    String nama = txtNama.getText().trim();
        String jenis = comboJenis.getSelectedItem().toString();
        String lokasi = txtNamaJalan.getText().trim();
        String kelurahan = comboKelurahan.getSelectedItem().toString();
        String status = comboStatus.getSelectedItem().toString();
        String kapasitasStr = txtKapasitasMaksimum.getText().trim();

        if (nama.isEmpty() || lokasi.isEmpty() || kapasitasStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi semua kolom terlebih dahulu!");
            return;
        }

        try (Connection conn = service.getConnection()) {
            double kapasitas = Double.parseDouble(kapasitasStr);

            // cari id_kelurahan
            int idKel = 0;
            PreparedStatement psKel = conn.prepareStatement("SELECT id_kelurahan FROM kelurahan WHERE nama_kelurahan=?");
            psKel.setString(1, kelurahan);
            ResultSet rs = psKel.executeQuery();
            if (rs.next()) idKel = rs.getInt("id_kelurahan");

            // insert ke fasilitas
            PreparedStatement psFas = conn.prepareStatement("""
                INSERT INTO fasilitas (nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan, latitude, longitude)
                VALUES (?, ?, ?, ?, ?, ?)
            """, Statement.RETURN_GENERATED_KEYS);
            psFas.setString(1, nama);
            psFas.setString(2, jenis);
            psFas.setString(3, lokasi);
            psFas.setInt(4, idKel);
            psFas.setDouble(5, latitude);
            psFas.setDouble(6, longitude);
            psFas.executeUpdate();

            ResultSet genKeys = psFas.getGeneratedKeys();
            int idBaru = 0;
            if (genKeys.next()) idBaru = genKeys.getInt(1);

            // insert ke tpa
            PreparedStatement psTpa = conn.prepareStatement("""
                INSERT INTO tpa (id_fasilitas, status, kapasitas_maks_ton) VALUES (?, ?, ?)
            """);
            psTpa.setInt(1, idBaru);
            psTpa.setString(2, status);
            psTpa.setDouble(3, kapasitas);
            psTpa.executeUpdate();

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

    private void pilihLokasi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihLokasi1ActionPerformed
        Map map = new Map(this);
        map.setVisible(true);
    }//GEN-LAST:event_pilihLokasi1ActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtKapasitasMaksimumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKapasitasMaksimumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKapasitasMaksimumActionPerformed

    private void comboKelurahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelurahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKelurahanActionPerformed

    private void HapusFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusFasilitasButtonActionPerformed
        int baris = jTable2.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih fasilitas yang akan dihapus!");
            return;
        }

        int id = (int) jTable2.getValueAt(baris, 0);
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus fasilitas ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            try (Connection conn = service.getConnection()) {
                PreparedStatement psDelTpa = conn.prepareStatement("DELETE FROM tpa WHERE id_fasilitas=?");
                psDelTpa.setInt(1, id);
                psDelTpa.executeUpdate();

                PreparedStatement psDelFas = conn.prepareStatement("DELETE FROM fasilitas WHERE id_fasilitas=?");
                psDelFas.setInt(1, id);
                psDelFas.executeUpdate();

                tampilkanDataFasilitas();
                kosongkanField();
                JOptionPane.showMessageDialog(this, "Fasilitas berhasil dihapus!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Kesalahan: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_HapusFasilitasButtonActionPerformed

    private void EditFasilitasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditFasilitasButtonActionPerformed
        int baris = jTable2.getSelectedRow();
        if (baris < 0) {
            JOptionPane.showMessageDialog(this, "Pilih fasilitas yang akan diperbarui!");
            return;
        }

        int id = (int) jTable2.getValueAt(baris, 0);
        String nama = txtNama.getText().trim();
        String jenis = comboJenis.getSelectedItem().toString();
        String lokasi = txtNamaJalan.getText().trim();
        String kelurahan = comboKelurahan.getSelectedItem().toString();
        String status = comboStatus.getSelectedItem().toString();
        String kapasitasStr = txtKapasitasMaksimum.getText().trim();

        try (Connection conn = service.getConnection()) {
            double kapasitas = Double.parseDouble(kapasitasStr);

            // cari id_kelurahan
            PreparedStatement psKel = conn.prepareStatement("SELECT id_kelurahan FROM kelurahan WHERE nama_kelurahan = ?");
            psKel.setString(1, kelurahan);
            ResultSet rs = psKel.executeQuery();
            int idKelurahan = 0;
            if (rs.next()) idKelurahan = rs.getInt("id_kelurahan");

            // update fasilitas
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

            // update tpa
            PreparedStatement psTpa = conn.prepareStatement("""
                UPDATE tpa SET status=?, kapasitas_maks_ton=? WHERE id_fasilitas=?
            """);
            psTpa.setString(1, status);
            psTpa.setDouble(2, kapasitas);
            psTpa.setInt(3, id);
            psTpa.executeUpdate();

            tampilkanDataFasilitas();
            kosongkanField();
            JOptionPane.showMessageDialog(this, "Fasilitas berhasil diperbarui!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Kesalahan: " + e.getMessage());
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
                SELECT f.nama_fasilitas, f.jenis_fasilitas, f.lokasi, k.nama_kelurahan,
                       f.latitude, f.longitude, t.status, t.kapasitas_maks_ton
                FROM fasilitas f
                JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
                LEFT JOIN tpa t ON f.id_fasilitas = t.id_fasilitas
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
                detail.append("Status: ").append(rs.getString("status")).append("\n");
                detail.append("Kapasitas Maksimum: ").append(rs.getDouble("kapasitas_maks_ton")).append(" ton\n");

                JTextArea area = new JTextArea(detail.toString());
                area.setEditable(false);
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                JScrollPane scroll = new JScrollPane(area);
                scroll.setPreferredSize(new java.awt.Dimension(450, 300));

                JOptionPane.showMessageDialog(this, scroll, "Detail Fasilitas", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Data detail tidak ditemukan.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_lihatDetailActionPerformed

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStatusActionPerformed

public static void main(String args[]) {
        try {
    com.formdev.flatlaf.FlatLightLaf.setup();
} catch (Exception ex) {
    logger.log(java.util.logging.Level.SEVERE, "Failed to initialize FlatLaf", ex);
}
        java.awt.EventQueue.invokeLater(() -> new AdminAddFacilityTPA().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditFasilitasButton;
    private javax.swing.JButton HapusFasilitasButton;
    private javax.swing.JButton TambahFasilitasButton;
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<String> comboJenis;
    private javax.swing.JComboBox<String> comboKelurahan;
    private javax.swing.JComboBox<String> comboStatus;
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
    private javax.swing.JTable jTable2;
    private javax.swing.JButton lihatDetail;
    private javax.swing.JButton pilihLokasi1;
    private javax.swing.JTextField txtKapasitasMaksimum;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaJalan;
    // End of variables declaration//GEN-END:variables
}
