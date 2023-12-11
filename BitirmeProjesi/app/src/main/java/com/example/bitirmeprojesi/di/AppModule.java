package com.example.bitirmeprojesi.di;

import com.example.bitirmeprojesi.data.repo.SepetDaoRepository;
import com.example.bitirmeprojesi.data.repo.YemeklerDaoRepository;
import com.example.bitirmeprojesi.reftrofit.ApiUtils;
import com.example.bitirmeprojesi.reftrofit.SepetDao;
import com.example.bitirmeprojesi.reftrofit.YemeklerDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public YemeklerDaoRepository provideYemeklerDaoRepository(YemeklerDao ydao){
        return new YemeklerDaoRepository(ydao);
    }
    @Provides
    @Singleton
    public YemeklerDao provideYemeklerDao(){
        return ApiUtils.getYemeklerDao();
    }

    @Provides
    @Singleton
    public SepetDaoRepository provideSepetDaoRepository(SepetDao sdao){
        return new SepetDaoRepository(sdao);
    }

    @Provides
    @Singleton
    public SepetDao provideSepetDao(){
        return ApiUtils.getSepetDao();
    }
}
