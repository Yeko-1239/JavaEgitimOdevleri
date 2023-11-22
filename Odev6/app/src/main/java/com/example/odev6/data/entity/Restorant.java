package com.example.odev6.data.entity;

import java.io.Serializable;

public class Restorant implements Serializable {
    private int restorant_id;
    private String restorant_ad;
    private String restorant_resim;

    public Restorant() {
    }

    public Restorant(int restorant_id, String restorant_ad, String restorant_resim) {
        this.restorant_id = restorant_id;
        this.restorant_ad = restorant_ad;
        this.restorant_resim = restorant_resim;
    }

    public int getRestorant_id() {
        return restorant_id;
    }

    public void setRestorant_id(int restorant_id) {
        this.restorant_id = restorant_id;
    }

    public String getRestorant_ad() {
        return restorant_ad;
    }

    public void setRestorant_ad(String restorant_ad) {
        this.restorant_ad = restorant_ad;
    }

    public String getRestorant_resim() {
        return restorant_resim;
    }

    public void setRestorant_resim(String restorant_resim) {
        this.restorant_resim = restorant_resim;
    }
}
