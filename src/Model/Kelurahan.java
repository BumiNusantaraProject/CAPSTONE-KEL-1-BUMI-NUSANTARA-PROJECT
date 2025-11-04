package Model;

public class Kelurahan {
    private String id_kelurahan;
    private String nama_kelurahan;
    private String lokasi_kelurahan;
    private String zona;
    private double latitude;
    private double longitude;
    

    public Kelurahan() {}

    public Kelurahan(String id_kelurahan, String nama_kelurahan, String lokasi_kelurahan, String zona, double latitude, double longitude) {
        this.id_kelurahan = id_kelurahan;
        this.nama_kelurahan = nama_kelurahan;
        this.lokasi_kelurahan = lokasi_kelurahan;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zona = zona;
    }

    // ENCAPSULATION: getter & setter
    public String getId_kelurahan() {
        return id_kelurahan;
    }

    public void setId_kelurahan(String id_kelurahan) {
        this.id_kelurahan = id_kelurahan;
    }

    public String getNama_kelurahan() {
        return nama_kelurahan;
    }

    public void setNama_kelurahan(String nama_kelurahan) {
        this.nama_kelurahan = nama_kelurahan;
    }

    public String getLokasi_kelurahan() {
        return lokasi_kelurahan;
    }

    public void setLokasi_kelurahan(String lokasi_kelurahan) {
        this.lokasi_kelurahan = lokasi_kelurahan;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    // METHOD TAMBAHAN UNTUK ABSTRAKSI DAN POLYMORPHISM
    public void tampilkanInfo() {
        System.out.println("Kelurahan: " + nama_kelurahan +
                " | Lokasi: " + lokasi_kelurahan +
                " | Zona: " + zona);
    }

    // VALIDASI DATA (bisa dianggap bentuk polymorphism juga)
    public boolean validate() {
        return id_kelurahan != null && !id_kelurahan.isEmpty()
            && nama_kelurahan != null && !nama_kelurahan.isEmpty()
            && lokasi_kelurahan != null && !lokasi_kelurahan.isEmpty()
            && zona != null && (zona.equals("hijau") || zona.equals("kuning") || zona.equals("merah"));
    }
}
