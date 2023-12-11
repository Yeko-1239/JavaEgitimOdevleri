package com.example.bitirmeprojesi.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bitirmeprojesi.data.entity.Sepet;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.data.repo.SepetDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SepetViewModel extends ViewModel {
    private SepetDaoRepository srepo;
    public MutableLiveData<List<Sepet>> sepetListesi;

@Inject
    public SepetViewModel(SepetDaoRepository srepo) {
    this.srepo = srepo;
    sepetiYukle();
    sepetListesi = srepo.sepetListesi;
}
    public void sepetiYukle(){
    srepo.sepetYemekler();
    }
    public void guncelle(String sepet_yemek_id,String yemek_adi,String yemek_resim_adi,String yemek_fiyat,String yemek_siparis_adet,String kullanici_adi){
        srepo.guncelle(sepet_yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi);
    }
    public void sepettencikar(String sepet_yemek_id,String kullanici_adi){

    srepo.sepettencikar(sepet_yemek_id,kullanici_adi);
    }

    public LiveData<List<Sepet>> getSepetListesi() {
        return sepetListesi;
    }
}
