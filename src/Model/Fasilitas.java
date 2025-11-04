package Model;

public class Fasilitas {

    private int id_fasilitas;
    private String nama_fasilitas;
    private String jenis_fasilitas;
    private String lokasi;
    private String id_kelurahan;
    private double latitude;
    private double longitude;

    public Fasilitas() {}

    public Fasilitas(int id_fasilitas, String nama_fasilitas, String jenis_fasilitas,
                     String lokasi, String id_kelurahan,
                     double latitude, double longitude) {
        this.id_fasilitas = id_fasilitas;
        this.nama_fasilitas = nama_fasilitas;
        this.jenis_fasilitas = jenis_fasilitas;
        this.lokasi = lokasi;
        this.id_kelurahan = id_kelurahan;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter & Setter
    public int getId_fasilitas() { return id_fasilitas; }
    public void setId_fasilitas(int id_fasilitas) { this.id_fasilitas = id_fasilitas; }

    public String getNama_fasilitas() { return nama_fasilitas; }
    public void setNama_fasilitas(String nama_fasilitas) { this.nama_fasilitas = nama_fasilitas; }

    public String getJenis_fasilitas() { return jenis_fasilitas; }
    public void setJenis_fasilitas(String jenis_fasilitas) { this.jenis_fasilitas = jenis_fasilitas; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public String getId_kelurahan() { return id_kelurahan; }
    public void setId_kelurahan(String id_kelurahan) { this.id_kelurahan = id_kelurahan; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    // Method tambahan (opsional)
    public void tampilkanInfo() {
        System.out.println("Fasilitas: " + nama_fasilitas + " | Jenis: " + jenis_fasilitas +
                " | Lokasi: " + lokasi + " (" + latitude + ", " + longitude + ")");
    }
}
