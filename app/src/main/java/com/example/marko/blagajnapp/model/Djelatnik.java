package com.example.marko.blagajnapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Djelatnik {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "djelatnikId")
    private int mDjelatnikId;

    @ColumnInfo(name = "username")
    public String mUsernme;

    //neka enkripcija za password
    @ColumnInfo(name = "password")
    public String mPassword;

    @ColumnInfo(name = "imeDjelatnika")
    private String mImeDjelatnika;

    @ColumnInfo(name = "prezimeDjelatnika")
    private String mPrezimeDjelatnika;

    @ColumnInfo(name = "OIB")
    public String mOIB;

    public Djelatnik(){}

    public Djelatnik(int djelatnikId, String username, String password, String imeDjelatnika, String prezimeDjelatnika, String OIB){
        mDjelatnikId = djelatnikId;
        mUsernme = username;
        mPassword = password;
        mImeDjelatnika = imeDjelatnika;
        mPrezimeDjelatnika = prezimeDjelatnika;
        mOIB = OIB;
    }

    public int getDjelatnikId(){
        return mDjelatnikId;
    }

    public void setDjelatnikId(int djelatnikId){
        mDjelatnikId = djelatnikId;
    }

    public String getUsername(){
        return mUsernme;
    }

    public void setUsername(String username){
        mUsernme = username;
    }

    public String getPassword(){
        return mPassword;
    }

    public void setPassword(String password){
        mPassword = password;
    }

    public String getImeDjelatnika(){
        return mImeDjelatnika;
    }

    public void setImeDjelatnika(String imeDjelatnika){
        mImeDjelatnika = imeDjelatnika;
    }

    public String getPrezimeDjelatnika(){
        return mPrezimeDjelatnika;
    }

    public void setPrezimeDjelatnika(String prezimeDjelatnika){
        mPrezimeDjelatnika = prezimeDjelatnika;
    }

    public String getOIB(){
        return mOIB;
    }

    public void  setOIB(String OIB){
        mOIB = OIB;
    }

    @Override
    public String toString() {
        return "Djelatnik{" +
                "djelatnikId= " + mDjelatnikId +
                ", username= " + mUsernme +
                ", password= " + mPassword +
                ", imeDjelatnika= " + mImeDjelatnika +
                ", prezimeDjelatnika= " + mPrezimeDjelatnika +
                ", OIB= " + mOIB +
                "}";
    }
}
