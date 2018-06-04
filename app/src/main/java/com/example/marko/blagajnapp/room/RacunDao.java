package com.example.marko.blagajnapp.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marko.blagajnapp.model.Racun;

import java.util.List;

@Dao
public interface RacunDao {

    @Insert
    void insertRacun (Racun racun);

    @Query("SELECT * FROM Racun ORDER BY racunId ASC")
    LiveData<List<Racun>> getAllRacuni();

    //dodati query za ispis računa u adminu

}
