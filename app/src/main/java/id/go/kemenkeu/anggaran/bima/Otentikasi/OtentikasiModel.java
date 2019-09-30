package id.go.kemenkeu.anggaran.bima.Otentikasi;

public class OtentikasiModel {

    private String Id;
    private String IdDok;
    private String NmDok;
    private String Desc;
    private int LogoFile;

    public OtentikasiModel() {
    }

    public OtentikasiModel(String id, String idDok, String nmDok, String desc, int logoFile) {
        Id = id;
        IdDok = idDok;
        NmDok = nmDok;
        Desc = desc;
        LogoFile = logoFile;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIdDok() {
        return IdDok;
    }

    public void setIdDok(String idDok) {
        IdDok = idDok;
    }

    public String getNmDok() {
        return NmDok;
    }

    public void setNmDok(String nmDok) {
        NmDok = nmDok;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getLogoFile() {
        return LogoFile;
    }

    public void setLogoFile(int logoFile) {
        LogoFile = logoFile;
    }
}
