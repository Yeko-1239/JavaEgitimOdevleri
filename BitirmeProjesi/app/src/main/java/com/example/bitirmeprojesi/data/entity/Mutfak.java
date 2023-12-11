package com.example.bitirmeprojesi.data.entity;

import java.io.Serializable;

public class Mutfak implements Serializable {
    private int mutfak_id;
    private String mutfak_ad;
    private String mutfak_resim;


    public Mutfak() {
    }

    public Mutfak(int mutfak_id, String mutfak_ad, String mutfak_resim) {
        this.mutfak_id = mutfak_id;
        this.mutfak_ad = mutfak_ad;
        this.mutfak_resim = mutfak_resim;
    }

    public int getMutfak_id() {
        return mutfak_id;
    }

    public void setMutfak_id(int mutfak_id) {
        this.mutfak_id = mutfak_id;
    }

    public String getMutfak_ad() {
        return mutfak_ad;
    }

    public void setMutfak_ad(String mutfak_ad) {
        this.mutfak_ad = mutfak_ad;
    }

    public String getMutfak_resim() {
        return mutfak_resim;
    }

    public void setMutfak_resim(String mutfak_resim) {
        this.mutfak_resim = mutfak_resim;
    }
}
