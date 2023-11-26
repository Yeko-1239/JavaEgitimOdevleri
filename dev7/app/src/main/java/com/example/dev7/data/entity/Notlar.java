package com.example.dev7.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "notlar")
public class Notlar implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "not_id")
    @NonNull
    private int not_id;
    @ColumnInfo(name = "not_baslik")
    @NonNull
    private String not_baslik;

    @ColumnInfo(name = "not")
    @NonNull
    private String not;

    @ColumnInfo(name = "not_tarih")
    @NonNull
    private String not_tarih;

    public Notlar() {
    }

    public Notlar(int not_id, @NonNull String not_baslik, @NonNull String not, @NonNull String not_tarih) {
        this.not_id = not_id;
        this.not_baslik = not_baslik;
        this.not = not;
        this.not_tarih = not_tarih;
    }

    public int getNot_id() {
        return not_id;
    }

    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }

    @NonNull
    public String getNot_baslik() {
        return not_baslik;
    }

    public void setNot_baslik(@NonNull String not_baslik) {
        this.not_baslik = not_baslik;
    }

    @NonNull
    public String getNot() {
        return not;
    }

    public void setNot(@NonNull String not) {
        this.not = not;
    }

    @NonNull
    public String getNot_tarih() {
        return not_tarih;
    }

    public void setNot_tarih(@NonNull String not_tarih) {
        this.not_tarih = not_tarih;
    }
}
