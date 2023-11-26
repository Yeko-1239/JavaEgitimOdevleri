package com.example.dev7.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.dev7.data.entity.Notlar;

@Database(entities = {Notlar.class},version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract NotlarDao getNotlarDao();

}
