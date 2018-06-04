package com.example.marko.blagajnapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Racun.class, parentColumns = "racunId", childColumns = "IdRacuna"))
public class StavkeRacuna {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "StavkaRacunaID")
    private int mStavkaRacunaID;

    @ColumnInfo(name = "IdRacuna")
    private int mIdRacuna;

    @ColumnInfo(name = "NazivArtikla")
    private String mNazivArtikla;

    @ColumnInfo(name = "Kolicina")
    private int mKolicina;

    @ColumnInfo(name = "CijenaArtikla")
    private float mCijenaArtikla;

    @ColumnInfo(name = "Iznos")
    private float mIznos;

    public StavkeRacuna(){}

    public StavkeRacuna(int mStavkaRacunaID, int mIdRacuna, String mNazivArtikla, int mKolicina, float mCijenaArtikla, float mIznos){
        this.mStavkaRacunaID = mStavkaRacunaID;
        this.mIdRacuna = mIdRacuna;
        this.mNazivArtikla = mNazivArtikla;
        this.mKolicina = mKolicina;
        this.mCijenaArtikla = mCijenaArtikla;
        this.mIznos = mIznos;
    }

    @Ignore
    public StavkeRacuna(String mNazivArtikla, int mKolicina, float mCijenaArtikla, float mIznos){
        this.mNazivArtikla = mNazivArtikla;
        this.mKolicina = mKolicina;
        this.mCijenaArtikla = mCijenaArtikla;
        this.mIznos = mIznos;
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
