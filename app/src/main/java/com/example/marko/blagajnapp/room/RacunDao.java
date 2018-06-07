package com.example.marko.blagajnapp.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.marko.blagajnapp.model.Racun;
import com.example.marko.blagajnapp.model.RacunData;


import java.util.List;

@Dao
public interface RacunDao {

    @Insert
    void insertRacun (Racun racun);

    @Query("SELECT * FROM Racun ORDER BY racunId ASC")
    LiveData<List<Racun>> getAllRacuni();

    @Query("SELECT Racun.racunId, Racun.vrijemeIzdavanja, Racun.iznosRacuna, Djelatnik.imeDjelatnika, StavkeRacuna.* FROM Racun " +
            "INNER JOIN Djelatnik ON Racun.djelatnik = Djelatnik.djelatnikId " +
            "INNER JOIN StavkeRacuna ON Racun.racunId = StavkeRacuna.IdRacuna ORDER BY racunId ASC")
    LiveData<List<RacunData>> getAllRacuniIStavkeRacuna();
}
