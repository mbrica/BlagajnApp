package com.example.marko.blagajnapp.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.marko.blagajnapp.model.Djelatnik;

import java.util.List;

@Dao
public interface DjelatnikDao {

    @Insert
    void insertDjelatnik(Djelatnik djelatnik);

    @Delete
    void deleteDjelatnik(Djelatnik djelatnik);

    @Update
    void updateDjelatnik(Djelatnik djelatnik);

    @Query("SELECT * FROM Djelatnik WHERE vrstaDjelatnika = 0 ORDER BY djelatnikId ASC")
    LiveData<List<Djelatnik>> getAllDjelatnik();

    @Query("SELECT * FROM Djelatnik WHERE username = :username AND password = :password")
    LiveData<Djelatnik> getDjelatnik(String username, String password);

    @Query("SELECT * FROM Djelatnik WHERE djelatnikId = :djelatnikId")
    LiveData<Djelatnik> getDjelatnikByID(int djelatnikId);
}
