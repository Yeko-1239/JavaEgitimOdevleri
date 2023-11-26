package com.example.dev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.dev7.data.repo.NotlarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class NotDetayViewModel extends ViewModel {
    public NotlarDaoRepository nrepo;
    @Inject
    public NotDetayViewModel(NotlarDaoRepository nrepo){

        this.nrepo = nrepo;
    }
    public void guncelle(int not_id,String not_baslik,String not,String not_tarih){
        nrepo.guncelle(not_id,not_baslik,not,not_tarih);
    }
}