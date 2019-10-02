package id.go.kemenkeu.anggaran.bima.Referensi;

public class BASModel {
    private String kode;
    private String uraian;
    private String deskripsi;

    public BASModel(){

    }

    public BASModel(String kode, String uraian, String deskripsi) {
        this.kode = kode;
        this.uraian = uraian;
        this.deskripsi = deskripsi;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
