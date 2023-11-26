package com.example.dev7.di;

import android.content.Context;

import androidx.room.Room;

import com.example.dev7.data.repo.NotlarDaoRepository;
import com.example.dev7.room.NotlarDao;
import com.example.dev7.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public NotlarDaoRepository providesNotlarDaRepository(NotlarDao ndao){
        return new NotlarDaoRepository(ndao);
    }
    @Provides
    @Singleton
    public NotlarDao provideNotlarDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context,Veritabani.class,"odev7.sqlite")
                .createFromAsset("odev7.sqlite").build();
        return vt.getNotlarDao();
    }
}
