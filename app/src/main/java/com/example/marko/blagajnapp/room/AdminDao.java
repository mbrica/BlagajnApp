package com.example.marko.blagajnapp.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.marko.blagajnapp.model.Admin;

@Dao
public interface AdminDao {

    @Insert
    void insertAdmin(Admin admin);

    //ukoliko je potrebno, poslije dodati funkciju za dohvaćanje admin --> za logiranje imam gettere za username i password
}
