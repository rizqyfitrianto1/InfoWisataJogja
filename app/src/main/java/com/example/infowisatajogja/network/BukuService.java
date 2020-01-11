package com.example.infowisatajogja.network;

import com.example.infowisatajogja.model.BukuPostPutDel;
import com.example.infowisatajogja.model.BukuResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BukuService {
    @GET("buku/search/{pengarang}")
    Call<BukuResult> getBuku(@Path("pengarang") String pengarang);

    @FormUrlEncoded
    @POST("buku")
    Call<BukuPostPutDel> postBuku(@Field("sampul") String sampul,
                                  @Field("nama") String nama,
                                  @Field("pengarang") String pengarang,
                                  @Field("tahun_terbit") String tahun_terbit,
                                  @Field("isbn") String isbn
                                  );
    @FormUrlEncoded
    @PUT("buku/{buku}")
    Call<BukuPostPutDel> putBuku(@Field("id") String id,
                                 @Field("sampul") String sampul,
                                 @Field("nama") String nama,
                                 @Field("pengarang") String pengarang,
                                 @Field("tahun_terbit") String tahun_terbit,
                                 @Field("isbn") String isbn
                                 );
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "buku/{buku}", hasBody = true)
    Call<BukuPostPutDel> deleteBuku(@Field("id") String id);
}
