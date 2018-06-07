package com.example.marko.blagajnapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Djelatnik {
    public static final int djelatnik = 0;
    public static final int admin = 1;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "djelatnikId")
    private int mDjelatnikId;

    @ColumnInfo(name = "username")
    public String mUsernme;

    @ColumnInfo(name = "password")
    private String mPassword;

    @ColumnInfo(name = "imeDjelatnika")
    private String mImeDjelatnika;

    @ColumnInfo(name = "prezimeDjelatnika")
    private String mPrezimeDjelatnika;

    @ColumnInfo(name = "OIB")
    private String mOIB;

    @ColumnInfo(name = "vrstaDjelatnika")
    private int mVrstaDjelatnika;

    public Djelatnik (){}

    public Djelatnik(int mDjelatnikId, String mUsername, String mPassword, String mImeDjelatnika, String mPrezimeDjelatnika, String mOIB, int mVrstaDjelatnika){
        this.mDjelatnikId = mDjelatnikId;
        this.mUsernme = mUsername;
        this.mPassword = mPassword;
        this.mImeDjelatnika = mImeDjelatnika;
        this.mPrezimeDjelatnika = mPrezimeDjelatnika;
        this.mOIB = mOIB;
        this.mVrstaDjelatnika = mVrstaDjelatnika;
    }

    @Ignore
    public Djelatnik(String mUsernme, String mPassword, String mImeDjelatnika, String mPrezimeDjelatnika, String mOIB, int mVrstaDjelatnika){
        this.mDjelatnikId = mDjelatnikId;
        this.mUsernme = mUsernme;
        this.mPassword = mPassword;
        this.mImeDjelatnika = mImeDjelatnika;
        this.mPrezimeDjelatnika = mPrezimeDjelatnika;
        this.mOIB = mOIB;
        this.mVrstaDjelatnika = mVrstaDjelatnika;
    }

    @Ignore
    public Djelatnik(String mUsernme, String mPassword, int mVrstaDjelatnika){
        this.mUsernme = mUsernme;
        this.mPassword = mPassword;
        this.mVrstaDjelatnika = mVrstaDjelatnika;
    }

    public int getDjelatnikId(){
        return mDjelatnikId;
    }

    public void setDjelatnikId(int mDjelatnikId){
        this.mDjelatnikId = mDjelatnikId;
    }

    public String getUsername(){
        return mUsernme;
    }

    public void setUsername(String mUsername){
        this.mUsernme = mUsername;
    }

    public String getPassword(){
        return mPassword;
    }

    public void setPassword(String mPassword){
        this.mPassword = mPassword;
    }

    public String getImeDjelatnika(){
        return mImeDjelatnika;
    }

    public void setImeDjelatnika(String mImeDjelatnika){
        this.mImeDjelatnika = mImeDjelatnika;
    }

    public String getPrezimeDjelatnika(){
        return mPrezimeDjelatnika;
    }

    public void setPrezimeDjelatnika(String mPrezimeDjelatnika){
        this.mPrezimeDjelatnika = mPrezimeDjelatnika;
    }

    public String getOIB(){
        return mOIB;
    }

    public void  setOIB(String mOIB){
        this.mOIB = mOIB;
    }

    public int getVrstaDjelatnika(){
        return mVrstaDjelatnika;
    }

    public void setVrstaDjelatnika(int mVrstaDjelatnika){
        this.mVrstaDjelatnika = mVrstaDjelatnika;
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
