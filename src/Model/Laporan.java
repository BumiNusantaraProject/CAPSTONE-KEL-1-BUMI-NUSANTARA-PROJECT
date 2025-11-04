package Model;

import java.sql.Timestamp;

public class Laporan {
    private int id_laporan;
    private int id_user;
    private String id_kelurahan;
    private String nama_kelurahan;
    private String alamat_lokasi;
    private byte[] foto;
    private String deksripsi;
    private String status;
    private Timestamp tanggal_lapor;
    private double latitude;
    private double longitude;

    // === Constructor Lengkap ===
    public Laporan(int id_laporan, int id_user, String id_kelurahan, String nama_kelurahan,
                   byte[] foto, String alamat_lokasi, String deksripsi,
                   String status, Timestamp tanggal_lapor, double latitude, double longitude) {
        this.id_laporan = id_laporan;
        this.id_user = id_user;
        this.id_kelurahan = id_kelurahan;
        this.nama_kelurahan = nama_kelurahan;
        this.foto = foto;
        this.alamat_lokasi = alamat_lokasi;
        this.deksripsi = deksripsi;
        this.status = status;
        this.tanggal_lapor = tanggal_lapor;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // === Constructor Kosong (wajib untuk JDBC/JavaBean) ===
    public Laporan() {}

    // === Getter & Setter ===
    public int getId_laporan() { return id_laporan; }
    public void setId_laporan(int id_laporan) { this.id_laporan = id_laporan; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public String getId_kelurahan() { return id_kelurahan; }
    public void setId_kelurahan(String id_kelurahan) { this.id_kelurahan = id_kelurahan; }

    public String getNama_kelurahan() { return nama_kelurahan; }
    public void setNama_kelurahan(String nama_kelurahan) { this.nama_kelurahan = nama_kelurahan; }

    public String getAlamat_lokasi() { return alamat_lokasi; }
    public void setAlamat_lokasi(String alamat_lokasi) { this.alamat_lokasi = alamat_lokasi; }

    public byte[] getFoto() { return foto; }
    public void setFoto(byte[] foto) { this.foto = foto; }

    public String getDeksripsi() { return deksripsi; }
    public void setDeksripsi(String deksripsi) { this.deksripsi = deksripsi; }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        if (status == null ||
            status.equalsIgnoreCase("Menunggu") ||
            status.equalsIgnoreCase("Diproses") ||
            status.equalsIgnoreCase("Selesai")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status tidak valid! Gunakan: Menunggu, Diproses, atau Selesai");
        }
    }

    public Timestamp getTanggal_lapor() { return tanggal_lapor; }
    public void setTanggal_lapor(Timestamp tanggal_lapor) { this.tanggal_lapor = tanggal_lapor; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}