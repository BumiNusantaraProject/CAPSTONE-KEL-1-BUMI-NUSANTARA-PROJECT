package Model;

import Model.Fasilitas;

public class TPA extends Fasilitas {
    private String status;
    private double kapasitas_maks_ton;

    public TPA() {
        super();
    }

    public TPA(int id_fasilitas, String nama_fasilitas, String jenis_fasilitas,
               String lokasi, String id_kelurahan, double latitude, double longitude,
               String status, double kapasitas_maks_ton) {
        super(id_fasilitas, nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan, latitude, longitude);
        this.status = status;
        this.kapasitas_maks_ton = kapasitas_maks_ton;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("TPA: " + getNama_fasilitas() +
                " | Kapasitas: " + kapasitas_maks_ton + " ton | Status: " + status);
    }

   
}