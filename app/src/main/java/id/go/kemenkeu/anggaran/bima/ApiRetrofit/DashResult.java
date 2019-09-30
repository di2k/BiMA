package id.go.kemenkeu.anggaran.bima.ApiRetrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashResult {

    @SerializedName("iduser")
    @Expose
    private String iduser;
    @SerializedName("rp_pagu")
    @Expose
    private String rpPagu;
    @SerializedName("rp_real")
    @Expose
    private String rpReal;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getRpPagu() {
        return rpPagu;
    }

    public void setRpPagu(String rpPagu) {
        this.rpPagu = rpPagu;
    }

    public String getRpReal() {
        return rpReal;
    }

    public void setRpReal(String rpReal) {
        this.rpReal = rpReal;
    }

}