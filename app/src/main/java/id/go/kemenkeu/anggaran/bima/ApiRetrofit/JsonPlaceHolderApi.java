package id.go.kemenkeu.anggaran.bima.ApiRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("dash?iduser=630931")
    Call<DashResult> getDash();
}
