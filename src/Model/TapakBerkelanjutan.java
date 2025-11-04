package Model;

import Model.Fasilitas;

public class TapakBerkelanjutan extends Fasilitas {
    private double luas_lahan;
    private String kondisi;

    public TapakBerkelanjutan() {
        super();
    }

    public TapakBerkelanjutan(int id_fasilitas, String nama_fasilitas, String jenis_fasilitas,
                              String lokasi, String id_kelurahan, double latitude, double longitude,
                              double luas_lahan, String kondisi) {
        super(id_fasilitas, nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan, latitude, longitude);
        this.luas_lahan = luas_lahan;
        this.kondisi = kondisi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Tapak Berkelanjutan: " + getNama_fasilitas());
        System.out.println("Luas Lahan: " + luas_lahan + " m² | Kondisi: " + kondisi);
    }

}