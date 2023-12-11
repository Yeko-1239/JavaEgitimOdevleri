package com.example.bitirmeprojesi.data.repo;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.bitirmeprojesi.data.entity.CRUDCevap;
import com.example.bitirmeprojesi.data.entity.Sepet;
import com.example.bitirmeprojesi.data.entity.SepetCevap;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.data.entity.YemeklerCevap;
import com.example.bitirmeprojesi.reftrofit.YemeklerDao;
import com.example.bitirmeprojesi.ui.fragment.DetayFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YemeklerDaoRepository {
    public MutableLiveData<List<Yemekler>> yemekListesi = new MutableLiveData<>();
    private YemeklerDao ydao;

    public YemeklerDaoRepository(YemeklerDao ydao){

        this.ydao = ydao;
    }

    public void kaydet(String yemek_adi,
                       String yemek_resim_adi,
                       int yemek_fiyat,
                       int yemek_siparis_adet,
                       String kullanici_adi){
        ydao.kaydet(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,"yekbun-demir").enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                if (response.isSuccessful()) {
                    // İşlem başarılı ise
                    Log.d("Kaydetme Başarılı", "Yemek başarıyla kaydedildi"+ yemek_adi+"-"+yemek_resim_adi+"-"+yemek_fiyat+"-"+yemek_siparis_adet+"-"+kullanici_adi);
                } else {
                    // İşlem başarısız ise
                    Log.e("Kaydetme Hatası", "Yemek kaydedilemedi. Hata kodu: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {
                Log.e("Ydao","kaydetme Başarız");
            }
        });
    }




    public void yemekleriYukle(){
        ydao.yemekleriYukle().enqueue(new Callback<YemeklerCevap>() {
            @Override
            public void onResponse(Call<YemeklerCevap> call, Response<YemeklerCevap> response) {
                List<Yemekler> liste = response.body().getYemekler();
                yemekListesi.setValue(liste);
            }

            @Override
            public void onFailure(Call<YemeklerCevap> call, Throwable t) {}
        });
    }

}
