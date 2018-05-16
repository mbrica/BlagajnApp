package com.example.marko.blagajnapp.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marko.blagajnapp.model.StavkeRacuna;

import java.util.List;

@Dao
public interface StavkeRacunaDao {

    @Insert
    void insertStavkeRacuna (StavkeRacuna stavkeRacuna);

    @Query("SELECT * FROM StavkeRacuna")
    LiveData<List<StavkeRacuna>> getAllStavkeRacuna();
}
