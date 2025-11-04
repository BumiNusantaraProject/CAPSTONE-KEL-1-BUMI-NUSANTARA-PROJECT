package Service;

import KoneksiDB.KoneksiDatabase;
import Model.Fasilitas;
import Model.Laporan;
import Model.User;
import Model.Kelurahan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Service {

    private Connection conn;

    public Service() {
        this.conn = KoneksiDatabase.getInstance().getConnection();
    }

    // Pastikan koneksi selalu aktif
    public Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = KoneksiDatabase.getInstance().getConnection();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memeriksa koneksi: " + e.getMessage());
        }
        return conn;
    }

    // ------------------ USER LOGIN DAN REGISTER ------------------
    public boolean registerUser(String email, String password) {
        try (Connection c = getConnection()) {
            if (c == null) {
                JOptionPane.showMessageDialog(null, "Gagal koneksi ke database!");
                return false;
            }
            String cekSql = "SELECT * FROM users WHERE email = ?";
            try (PreparedStatement cekPs = c.prepareStatement(cekSql)) {
                cekPs.setString(1, email);
                ResultSet rs = cekPs.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Email sudah terdaftar!");
                    return false;
                }
            }

            String insertSql = "INSERT INTO users (email, password, role) VALUES (?, ?, 'user')";
            try (PreparedStatement ps = c.prepareStatement(insertSql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                return ps.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error register: " + e.getMessage());
            return false;
        }
    }

    public User loginUser(String email, String password) {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?")) {

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id_user"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error login: " + e.getMessage());
        }
        return null;
    }

    // ------------------ FASILITAS ------------------
    public List<Fasilitas> getAllFasilitas() {
        List<Fasilitas> list = new ArrayList<>();
        String sql = "SELECT * FROM fasilitas";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Fasilitas f = new Fasilitas(
                        rs.getInt("id_fasilitas"),
                        rs.getString("nama_fasilitas"),
                        rs.getString("jenis_fasilitas"),
                        rs.getString("lokasi"),
                        rs.getString("id_kelurahan"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude")
                );
                list.add(f);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal ambil data fasilitas: " + e.getMessage());
        }
        return list;
    }

    // ------------------ LAPORAN ------------------
    public List<Laporan> getAllLaporan() {
    List<Laporan> list = new ArrayList<>();
    String sql = "SELECT l.*, k.nama_kelurahan \n" +
"FROM laporan l\n" +
"JOIN kelurahan k ON l.id_kelurahan = k.id_kelurahan";

    try (Connection c = getConnection();
         PreparedStatement ps = c.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Laporan l = new Laporan(
                    rs.getInt("id_laporan"),
                    rs.getInt("id_user"),
                    rs.getString("id_kelurahan"),
                    rs.getString("nama_kelurahan"),
                    rs.getBytes("foto"),
                    rs.getString("alamat_lokasi"),
                    rs.getString("deksripsi"),
                    rs.getString("status"),
                    rs.getTimestamp("tanggal_lapor"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude")
            );
            list.add(l);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat laporan: " + e.getMessage());
    }
    return list;
}

    // ------------------ JOIN FASILITAS - KELURAHAN ------------------
    public List<Fasilitas> ambilSemuaFasilitas() {
        List<Fasilitas> list = new ArrayList<>();
        String sql = """
            SELECT f.id_fasilitas, f.nama_fasilitas, f.jenis_fasilitas, f.lokasi,
                   k.nama_kelurahan, f.latitude, f.longitude
            FROM fasilitas f
            LEFT JOIN kelurahan k ON f.id_kelurahan = k.id_kelurahan
            ORDER BY f.id_fasilitas ASC
        """;

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Fasilitas f = new Fasilitas() { @Override public void tampilkanInfo() {} };
                f.setId_fasilitas(rs.getInt("id_fasilitas"));
                f.setNama_fasilitas(rs.getString("nama_fasilitas"));
                f.setJenis_fasilitas(rs.getString("jenis_fasilitas"));
                f.setLokasi(rs.getString("lokasi"));
                f.setId_kelurahan(rs.getString("nama_kelurahan"));
                f.setLatitude(rs.getDouble("latitude"));
                f.setLongitude(rs.getDouble("longitude"));
                list.add(f);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data fasilitas: " + e.getMessage());
        }
        return list;
    }

    public boolean tambahFasilitas(String nama, String jenis, String lokasi, String kelurahan, double lat, double lon) {
        String sql = "INSERT INTO fasilitas (nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, nama);
            ps.setString(2, jenis);
            ps.setString(3, lokasi);
            ps.setInt(4, getIdKelurahanByName(kelurahan));
            ps.setDouble(5, lat);
            ps.setDouble(6, lon);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fasilitas berhasil ditambahkan!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah fasilitas: " + e.getMessage());
            return false;
        }
    }

    public boolean updateFasilitas(int id, String nama, String jenis, String lokasi, String kelurahan, double lat, double lon) {
        String sql = "UPDATE fasilitas SET nama_fasilitas=?, jenis_fasilitas=?, lokasi=?, id_kelurahan=?, latitude=?, longitude=? WHERE id_fasilitas=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, nama);
            ps.setString(2, jenis);
            ps.setString(3, lokasi);
            ps.setInt(4, getIdKelurahanByName(kelurahan));
            ps.setDouble(5, lat);
            ps.setDouble(6, lon);
            ps.setInt(7, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fasilitas berhasil diperbarui!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memperbarui fasilitas: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusFasilitas(int id) {
        String sql = "DELETE FROM fasilitas WHERE id_fasilitas=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus fasilitas: " + e.getMessage());
            return false;
        }
    }

    public boolean updateJenisFasilitas(int id, String newJenis) {
        String sql = "UPDATE fasilitas SET jenis_fasilitas=? WHERE id_fasilitas=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, newJenis);
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memperbarui jenis: " + e.getMessage());
            return false;
        }
    }

    public List<Kelurahan> getAllKelurahan() {
    List<Kelurahan> list = new ArrayList<>();
    String sql = "SELECT * FROM kelurahan ORDER BY id_kelurahan ASC";
    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Kelurahan k = new Kelurahan();
            k.setId_kelurahan(rs.getString("id_kelurahan"));
            k.setNama_kelurahan(rs.getString("nama_kelurahan"));
            k.setZona(rs.getString("zona"));
            k.setLatitude(rs.getDouble("latitude"));
            k.setLongitude(rs.getDouble("longitude"));
            list.add(k);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat kelurahan: " + e.getMessage());
    }
    return list;
}


    public int getIdKelurahanByName(String namaKelurahan) throws SQLException {
    String sql = "SELECT id_kelurahan FROM kelurahan WHERE nama_kelurahan=?";
    try (Connection c = getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setString(1, namaKelurahan);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getInt("id_kelurahan");
        else throw new SQLException("Kelurahan tidak ditemukan: " + namaKelurahan);
    }
}

    // ------------------ LAPORAN ------------------
    public boolean hapusLaporan(int id) {
        String sql = "DELETE FROM laporan WHERE id_laporan=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus laporan: " + e.getMessage());
            return false;
        }
    }

    public boolean updateStatusLaporan(int id, String newStatus) {
        String sql = "UPDATE laporan SET status=? WHERE id_laporan=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, newStatus);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memperbarui status laporan: " + e.getMessage());
            return false;
        }
    }
}