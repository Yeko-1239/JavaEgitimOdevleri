package com.example.dev7.data.repo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dev7.data.entity.Notlar;
import com.example.dev7.room.NotlarDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class NotlarDaoRepository extends ViewModel {

    public MutableLiveData<List<Notlar>> notlarListesi = new MutableLiveData<>();
    private NotlarDao ndao;

    public NotlarDaoRepository(NotlarDao ndao){

        this.ndao=ndao;
    }
    public void kaydet(String not_baslik,String not,String not_tarih){
        Notlar yeniNot = new Notlar(0,not_baslik,not,not_tarih);
        ndao.kaydet(yeniNot).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });

    }
    public void guncelle(int not_id, String not_baslik, String not,String not_tarih) {
        Notlar guncellenenNot = new Notlar(not_id,not_baslik,not,not_tarih);
        ndao.guncelle(guncellenenNot).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });    }

    public void ara(String aramaKelimesi){
        ndao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Notlar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Notlar> notlars) {
                        notlarListesi.setValue(notlars);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void sil(int not_id){
        Notlar silinenNot = new Notlar(not_id,"","","");
        ndao.sil(silinenNot).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {
                        notlariYukle();
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void notlariYukle(){
        ndao.notlariYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Notlar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Notlar> notlars) {
                        notlarListesi.setValue(notlars);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });

    }
}
