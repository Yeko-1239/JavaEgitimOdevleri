package com.example.bitirmeprojesi.reftrofit;


import com.example.bitirmeprojesi.data.entity.CRUDCevap;
import com.example.bitirmeprojesi.data.entity.SepetCevap;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SepetDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php
    //http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php
    //http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php
    //http://kasimadalan.pe.hu/yemekler/resimler/

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    Call<SepetCevap> sepetimdekiler(@Field("kullanici_adi") String kullanici_adi);
    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    Call<SepetCevap> guncelle(@Field("sepet_yemek_id") String sepet_yemek_id,
                             @Field("yemek_adi") String yemek_adi,
                             @Field("yemek_resim_adi") String yemek_resim_adi,
                             @Field("yemek_fiyat") String yemek_fiyat,
                             @Field("yemek_siparis_adet") String yemek_siparis_adet,
                             @Field("kullanici_adi") String kullanici_adi);



    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    Call<CRUDCevap> sepettencikar(@Field("sepet_yemek_id") String sepet_yemek_id,
                                  @Field("kullanici_adi") String kullanici_adi);

}
