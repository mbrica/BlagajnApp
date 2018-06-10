package com.example.marko.blagajnapp.room;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.example.marko.blagajnapp.model.Artikl;
import com.example.marko.blagajnapp.model.Djelatnik;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.model.Racun;
import com.example.marko.blagajnapp.model.StavkeRacuna;

import java.util.concurrent.Executors;


@Database(entities = {Kategorija.class, Artikl.class, Djelatnik.class, Racun.class, StavkeRacuna.class}, version = 1)
public abstract class BlagajnAppDatabase extends RoomDatabase {

    public abstract KategorijaDao kategorijaDao();
    public abstract ArtiklDao artiklDao();
    public abstract DjelatnikDao djelatnikDao();
    public abstract RacunDao racunDao();
    public abstract StavkeRacunaDao stavkeRacunaDao();

    private static BlagajnAppDatabase INSTANCE;
    private static final String DATABASE_NAME = "blagajnapp.db";

    public static BlagajnAppDatabase getInstance(Application application){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(application.getApplicationContext(),BlagajnAppDatabase.class,DATABASE_NAME).addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            INSTANCE.djelatnikDao().insertDjelatnik(new Djelatnik("admin","admin1234",Djelatnik.admin));
                        }
                    });
                }
            }).build();
        }
        return INSTANCE;
    }
}
