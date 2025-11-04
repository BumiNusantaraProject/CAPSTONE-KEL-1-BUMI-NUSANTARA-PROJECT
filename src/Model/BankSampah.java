package Model;

import Model.Fasilitas;

public class BankSampah extends Fasilitas {
    private String nama_pengelola;
    private String kontak;
    private String jam_operasional;

    public BankSampah() {
        super();
    }

    public BankSampah(int id_fasilitas, String nama_fasilitas, String jenis_fasilitas,
                      String lokasi, String id_kelurahan, double latitude, double longitude,
                      String nama_pengelola, String kontak, String jam_operasional) {
        super(id_fasilitas, nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan, latitude, longitude);
        this.nama_pengelola = nama_pengelola;
        this.kontak = kontak;
        this.jam_operasional = jam_operasional;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Bank Sampah: " + getNama_fasilitas() +
                " | Pengelola: " + nama_pengelola + " | Kontak: " + kontak);
    }

}