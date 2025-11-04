package KoneksiDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDatabase {
    private static KoneksiDatabase instance;
    private Connection connection;

    // Ubah sesuai dengan nama database, user, dan password kamu
    private final String URL = "jdbc:mysql://localhost:3306/pengelolaan_fasijau";
    private final String USER = "root";
    private final String PASSWORD = "";

    private KoneksiDatabase() {
        connect();
    }

    // Buat instance tunggal
    public static synchronized KoneksiDatabase getInstance() {
        if (instance == null) {
            instance = new KoneksiDatabase();
        }
        return instance;
    }

    // Method untuk memastikan koneksi selalu hidup
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect(); // reconnect otomatis
            }
        } catch (SQLException e) {
            System.err.println("Gagal memeriksa koneksi: " + e.getMessage());
            connect(); // coba sambung ulang
        }
        return connection;
    }

    // Method private untuk membuat koneksi baru
    private void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Koneksi database aktif!");
        } catch (SQLException e) {
            System.err.println("❌ Koneksi gagal: " + e.getMessage());
        }
    }

    // (Opsional) Kalau kamu mau menutup koneksi saat aplikasi ditutup
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 Koneksi database ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal menutup koneksi: " + e.getMessage());
        }
    }
}