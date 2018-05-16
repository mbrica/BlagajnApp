package com.example.marko.blagajnapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity
//dodati strane ključeve
public class StavkeRacuna {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "StavkaRacunaID")
    private int mStavkaRacunaID;

    @ColumnInfo(name = "IdRacuna")
    private int mIdRacuna;

    @ColumnInfo(name = "artikl")
    private int mArtikl;

    @ColumnInfo(name = "NazivArtikla")
    private String mNazivArtikla;

    @ColumnInfo(name = "Kolicina")
    private int mKolicina;

    @ColumnInfo(name = "CijenaArtikla")
    private float mCijenaArtikla;

    @ColumnInfo(name = "Iznos")
    private float mIznos;

    public StavkeRacuna(){}

    public StavkeRacuna(int StavkeRacunaID, int IdRacuna, int artikl, String NazivArtikla, int Kolicina, float CijenaArtikla, float Iznos){
        mStavkaRacunaID = StavkeRacunaID;
        mIdRacuna = IdRacuna;
        mArtikl = artikl;
        mNazivArtikla = NazivArtikla;
        mKolicina = Kolicina;
        mCijenaArtikla = CijenaArtikla;
        mIznos = Iznos;
    }

    public int getStavkaRacunaID() {
        return mStavkaRacunaID;
    }

    public void setStavkaRacunaID(int StavkaRacunaID) {
        this.mStavkaRacunaID = StavkaRacunaID;
    }

    public int getIdRacuna() {
        return mIdRacuna;
    }

    public void setIdRacuna(int IdRacuna) {
        this.mIdRacuna = IdRacuna;
    }

    public int getArtikl() {
        return mArtikl;
    }

    public void setArtikl(int Artikl) {
        this.mArtikl = Artikl;
    }

    public String getNazivArtikla() {
        return mNazivArtikla;
    }

    public void setNazivArtikla(String NazivArtikla) {
        this.mNazivArtikla = NazivArtikla;
    }

    public int getKolicina() {
        return mKolicina;
    }

    public void setKolicina(int Kolicina) {
        this.mKolicina = Kolicina;
    }

    public float getCijenaArtikla() {
        return mCijenaArtikla;
    }

    public void setCijenaArtikla(float CijenaArtikla) {
        this.mCijenaArtikla = CijenaArtikla;
    }

    public float getIznos() {
        return mIznos;
    }

    public void setIznos(float Iznos) {
        this.mIznos = Iznos;
    }
}
