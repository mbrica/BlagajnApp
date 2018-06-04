package com.example.marko.blagajnapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.example.marko.blagajnapp.model.Djelatnik;

@Entity(foreignKeys = @ForeignKey(entity = Djelatnik.class, parentColumns = "djelatnikId", childColumns = "djelatnik"))
public class Racun {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "racunId")
    private int mRacunId;

    @ColumnInfo(name = "vrijemeIzdavanja")
    private String mVrijemeIzdavanja;

    @ColumnInfo(name = "iznosRacuna")
    private String mIznosRacuna;

    @ColumnInfo(name = "djelatnik")
    private int mDjelatnik;

    public Racun(){}

    public Racun (int mRacunId, String mVrijemeIzdavanja, String mIznosRacuna, int mDjelatnik){
        this.mRacunId = mRacunId;
        this.mVrijemeIzdavanja = mVrijemeIzdavanja;
        this.mIznosRacuna = mIznosRacuna;
        this.mDjelatnik = mDjelatnik;
    }

    @Ignore
    public Racun(String mVrijemeIzdavanja, String mIznosRacuna, int mDjelatnik){
        this.mVrijemeIzdavanja = mVrijemeIzdavanja;
        this.mIznosRacuna = mIznosRacuna;
        this.mDjelatnik = mDjelatnik;
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

    public String getIznosRacuna(){
        return mIznosRacuna;
    }

    public void setIznosRacuna(String iznosRacuna){
        mIznosRacuna = iznosRacuna;
    }

    public int getDjelatnik(){
        return mDjelatnik;
    }

    public void setDjelatnik(int djelatnik){
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
