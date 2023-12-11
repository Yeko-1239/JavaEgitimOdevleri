package com.example.bitirmeprojesi.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeprojesi.data.entity.CRUDCevap;
import com.example.bitirmeprojesi.data.entity.Sepet;
import com.example.bitirmeprojesi.data.entity.SepetCevap;
import com.example.bitirmeprojesi.reftrofit.SepetDao;


import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SepetDaoRepository {
    public MutableLiveData<List<Sepet>> sepetListesi = new MutableLiveData<>();
    private SepetDao sdao;

    public SepetDaoRepository(SepetDao sdao){

        this.sdao = sdao;
    }


    public void sepetYemekler(){
        sdao.sepetimdekiler("yekbun-demir").enqueue(new Callback<SepetCevap>() {
            @Override
            public void onResponse(Call<SepetCevap> call, Response<SepetCevap> response) {
                List<Sepet> liste = response.body().getSepetim();
                if (liste == null){
                    sepetListesi.setValue(null);
                    Log.e("SepetDaoRepository", "Sunucudan boş sepet geldi!"+ String.valueOf(response.code()));
                } else {
                    sepetListesi.setValue(liste);
                    Log.d("SepetDaoRepository", "Sepet başarıyla yüklendi: " + liste.size() + " öğe");
                }

            }
            @Override
            public void onFailure(Call<SepetCevap> call, Throwable t) {
                // Hata durumu
                Log.e("TAG"," Response Error " + t.getMessage());
                t.printStackTrace();

            }
        });
    }



    public void guncelle(String sepet_yemek_id,String yemek_adi,String yemek_resim_adi,String yemek_fiyat,String yemek_siparis_adet,String kullanici_adi){
        sdao.guncelle(sepet_yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,"yekbun-demir").enqueue(new Callback<SepetCevap>() {
            @Override
            public void onResponse(Call<SepetCevap> call, Response<SepetCevap> response) {

            }

            @Override
            public void onFailure(Call<SepetCevap> call, Throwable t) {}
        });
    }

    public void sepettencikar(String sepet_yemek_id,String kullanici_adi){
        sdao.sepettencikar(sepet_yemek_id,kullanici_adi).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                sepetYemekler();
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {}
        });
    }




}
