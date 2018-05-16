package com.example.marko.blagajnapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Admin {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "adminUsername")
    String mAdminUsername;

    @ColumnInfo(name = "adminPassword")
    String mAdminPassword;

    public Admin(){}

    public Admin(String adminUsername, String adminPassword){
        mAdminUsername = adminUsername;
        mAdminPassword = adminPassword;
    }

    public String getAdminUsername(){
        return mAdminUsername;
    }

    public void setAdminUsername(String adminUsername){
        mAdminUsername = adminUsername;
    }

    public String getAdminPassword(){
        return mAdminPassword;
    }

    public void setAdminPassword(String adminPassword){
        mAdminPassword = adminPassword;
    }
}
