package com.example.marko.blagajnapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Djelatnik.class, parentColumns = "djelatnikId", childColumns = "djelatnik"))
public class Racun {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "racunId")
    private int mRacunId;

    @ColumnInfo(name = "vrijemeIzdavanja")
    private String mVrijemeIzdavanja;  //potreban convert type

    @ColumnInfo(name = "iznosRacuna")
    private int mIznosRacuna;

    @ColumnInfo(name = "djelatnik")
    private String mDjelatnik;

    public Racun(){}

    public Racun(int racunId, String vrijemeIzdavanja, int iznosRacuna, String djelatnik){
        mRacunId = racunId;
        mVrijemeIzdavanja = vrijemeIzdavanja;
        mIznosRacuna = iznosRacuna;
        mDjelatnik = djelatnik;
    }

    public int getRacunId(){
        return mRacunId;
    }

    public void setRacunId(int racunId){
        mRacunId = racunId;
    }

    public String getVrijemeIzdavanja(){
        return mVrijemeIzdavanja;
    }

    public void setVrijemeIzdavanja(String vrijemeIzdavanja){
        mVrijemeIzdavanja = vrijemeIzdavanja;
    }

    public int getIznosRacuna(){
        return mIznosRacuna;
    }

    public void setIznosRacuna(int iznosRacuna){
        mIznosRacuna = iznosRacuna;
    }

    public String getDjelatnik(){
        return mDjelatnik;
    }

    public void setDjelatnik(String djelatnik){
        mDjelatnik = djelatnik;
    }

    @Override
    public String toString() {
        return "Racuna{" +
                "racunId= " + mRacunId +
                ", vrijemeIzdavanja = " + mVrijemeIzdavanja +
                ", iznosRacuna = " + mIznosRacuna +
                ", djelatnik= " + mDjelatnik +
                "}";
    }
}
