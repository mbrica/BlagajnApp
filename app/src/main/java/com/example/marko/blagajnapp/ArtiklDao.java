package com.example.marko.blagajnapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ArtiklDao {

    @Insert
    void insertArtikl (Artikl artikl);

    @Delete
    void deleteArtikl (Artikl artikl);

    @Update
    void updateArtikl (Artikl artikl);

    //Prepraviti ovaj query
    @Query("SELECT * FROM Artikl WHERE Kategorija = Kategorija ORDER BY artiklId ASC;")
    LiveData<List<Artikl>> getArtikliIzKategorije();
}
