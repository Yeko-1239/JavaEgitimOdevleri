package com.example.bitirmeprojesi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.data.repo.YemeklerDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
@HiltViewModel
public class AnasayfaViewModel extends ViewModel {

    public YemeklerDaoRepository yrepo;
    public MutableLiveData<List<Yemekler>> yemekListesi ;

    @Inject
    public AnasayfaViewModel(YemeklerDaoRepository yrepo){
        this.yrepo = yrepo;
        yemekleriYukle();
        yemekListesi = yrepo.yemekListesi;
    }
    public void yemekYukle() {
        yrepo.yemekleriYukle();
    }
    public void kaydet(String yemek_adi,String yemek_resim_adi,int yemek_fiyat,int yemek_siparis_adet,String kullanici_adi){
        yrepo.kaydet(yemek_adi,yemek_resim_adi,yemek_fiyat,1,kullanici_adi);
    }

    public void araYemek(String arananYemek) {
        List<Yemekler> yemekListes = yemekListesi.getValue();
        List<Yemekler> bulunanYemekler = new ArrayList<>();
        if (yemekListes != null) {
            for (Yemekler yemek : yemekListes) {
                if (yemek.getYemek_adi().toLowerCase().contains(arananYemek.toLowerCase())) {
                    bulunanYemekler.add(yemek);
                }
            }
        }
        Log.e("Aranan Yemek -->", bulunanYemekler.get(0).getYemek_adi());
        List<Yemekler> filteredList = new ArrayList<>(bulunanYemekler);
        yemekListesi.postValue(filteredList);
    }



    public LiveData<List<Yemekler>> yemekleriYukle(){

        return yemekListesi;
    }

}
