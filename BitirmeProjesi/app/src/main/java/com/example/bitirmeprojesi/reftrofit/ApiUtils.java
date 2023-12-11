package com.example.bitirmeprojesi.reftrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://kasimadalan.pe.hu/";

    public static YemeklerDao getYemeklerDao(){
        return RetrofitClient.getClient(BASE_URL).create(YemeklerDao.class);

    }

    public static SepetDao getSepetDao() {
        return RetrofitClient.getClient(BASE_URL).create(SepetDao.class);
    }
}
