package com.example.dev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.dev7.data.repo.NotlarDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NotEkleViewModel extends ViewModel {
    public NotlarDaoRepository nrepo ;
    @Inject
    public NotEkleViewModel(NotlarDaoRepository nrepo){

        this.nrepo = nrepo;
    }
    public void kaydet(String not_baslik,String not,String not_tarih){

        nrepo.kaydet(not_baslik,not,not_tarih);
    }
}