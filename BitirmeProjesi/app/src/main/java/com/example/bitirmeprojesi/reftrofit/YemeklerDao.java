package com.example.bitirmeprojesi.reftrofit;



import com.example.bitirmeprojesi.data.entity.CRUDCevap;
import com.example.bitirmeprojesi.data.entity.SepetCevap;
import com.example.bitirmeprojesi.data.entity.YemeklerCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php
    //http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php
    //http://kasimadalan.pe.hu/yemekler/resimler/

    @GET("yemekler/tumYemekleriGetir.php")
    Call<YemeklerCevap> yemekleriYukle();



    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<CRUDCevap> kaydet(
            @Field("yemek_adi") String yemek_adi,
            @Field("yemek_resim_adi") String yemek_resim_adi,
            @Field("yemek_fiyat") int yemek_fiyat,
            @Field("yemek_siparis_adet") int yemek_siparis_adet,
            @Field("kullanici_adi") String kullanici_adi);
}
