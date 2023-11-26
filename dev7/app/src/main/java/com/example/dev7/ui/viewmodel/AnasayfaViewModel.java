package com.example.dev7.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dev7.data.entity.Notlar;
import com.example.dev7.data.repo.NotlarDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public NotlarDaoRepository nrepo;
    public MutableLiveData<List<Notlar>> notlarListesi;

    @Inject
    public AnasayfaViewModel(NotlarDaoRepository nrepo){
        this.nrepo = nrepo;
        notlariYukle();
        notlarListesi = nrepo.notlarListesi;
    }
    public void ara(String aramaKelimesi){

        nrepo.ara(aramaKelimesi);
    }

    public void sil(int not_id){
        nrepo.sil(not_id);
    }

    public void notlariYukle(){

        nrepo.notlariYukle();
    }
}
