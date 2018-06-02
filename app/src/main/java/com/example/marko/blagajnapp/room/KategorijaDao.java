package com.example.marko.blagajnapp.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import com.example.marko.blagajnapp.model.Kategorija;

import java.util.List;

@Dao
public interface KategorijaDao {

    @Insert
    void insertKategorija(Kategorija kategorija);

    @Delete
    void deleteKategorija(Kategorija kategorija);

    @Update
    void updateKategorija(Kategorija kategorija);

    @Query("SELECT * FROM Kategorija ORDER BY kategorijaId ASC")
    LiveData<List<Kategorija>> getAllKategorije();

    @Query("SELECT * FROM Kategorija WHERE kategorijaId = :kategorijaId")
    LiveData<Kategorija> getKategorijaByID(int kategorijaId);
}
