package com.example.marko.blagajnapp.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.marko.blagajnapp.model.Artikl;

import java.util.List;

@Dao
public interface ArtiklDao {

    @Insert
    void insertArtikl (Artikl artikl);

    @Delete
    void deleteArtikl (Artikl artikl);

    @Update
    void updateArtikl (Artikl artikl);

    @Query("SELECT * FROM Artikl WHERE Kategorija = :Kategorija ORDER BY artiklId ASC;")
    LiveData<List<Artikl>> getArtikliIzKategorije(int Kategorija);

    @Query("SELECT * FROM Artikl ORDER BY artiklId ASC;")
    LiveData<List<Artikl>> getArtikli();

    @Query("SELECT * FROM Artikl WHERE artiklId = :artiklId")
    LiveData<Artikl> getArtiklByID(int artiklId);
}
