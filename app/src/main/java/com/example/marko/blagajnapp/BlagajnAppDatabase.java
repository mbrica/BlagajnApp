package com.example.marko.blagajnapp;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Kategorija.class, Artikl.class, Djelatnik.class, Racun.class}, version = 1)
public abstract class BlagajnAppDatabase extends RoomDatabase {

    public abstract KategorijaDao kategorijaDao();
    public abstract ArtiklDao artiklDao();
    public abstract DjelatnikDao djelatnikDao();
    public abstract RacunDao racunDao();

    private static BlagajnAppDatabase INSTANCE;
    private static final String DATABASE_NAME = "blagajnapp.db";

    public static BlagajnAppDatabase getInstance(Application application){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(application.getApplicationContext(),BlagajnAppDatabase.class,DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}
