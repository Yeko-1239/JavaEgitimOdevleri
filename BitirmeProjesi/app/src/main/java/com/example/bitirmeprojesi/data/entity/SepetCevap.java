package com.example.bitirmeprojesi.data.entity;


import java.util.List;

public class SepetCevap {
    private List<Sepet> sepetim;
    private int success;

    public SepetCevap() {
    }

    public SepetCevap(List<Sepet> sepetim, int success) {
        this.sepetim = sepetim;
        this.success = success;
    }

    public List<Sepet> getSepetim() {
        return sepetim;

    }

    public void setSepetim(List<Sepet> sepetim) {
        this.sepetim = sepetim;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

}
