package com.example.dev7.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dev7.data.entity.Notlar;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface NotlarDao {

    @Query("SELECT * FROM notlar")
    Single<List<Notlar>> notlariYukle();

    @Insert
    Completable kaydet(Notlar not);
    @Update
    Completable guncelle(Notlar not);

    @Delete
    Completable sil(Notlar not);

    @Query("SELECT * FROM notlar WHERE not_baslik like '%'|| :aramaKelimesi ||'%'")
    Single<List<Notlar>> ara(String aramaKelimesi);

}
