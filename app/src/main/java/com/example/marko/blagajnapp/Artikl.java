package com.example.marko.blagajnapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Kategorija.class, parentColumns = "kategorijaId",childColumns = "Kategorija"))
public class Artikl {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "artiklId")
    public int martiklId;

    @ColumnInfo(name = "nazivArtikla")
    public String mNaziv;

    @ColumnInfo(name = "cijenaArtikla")
    public float mCijena;

    @ColumnInfo(name = "Kategorija")
    private int mKategorija;

    public Artikl(){}

    public Artikl(int artiklId, String nazivArtikla, float cijenaArtikla, int Kategorija){
        martiklId = artiklId;
        mNaziv = nazivArtikla;
        mCijena = cijenaArtikla;
        mKategorija = Kategorija;
    }

    public int getArtiklId() {
        return martiklId;
    }

    public void setArtiklId(int artiklId) {
        martiklId = artiklId;
    }

    public String getNazivArtikla() {
        return mNaziv;
    }

    public void setNazivArtikla(String nazivArtikla) {
        mNaziv = nazivArtikla;
    }

    public float getCijenaArtikla() {
        return mCijena;
    }

    public void setCijenaArtikla(float cijenaArtikla) {
        mCijena = cijenaArtikla;
    }

    public int getKategorija() {
        return mKategorija;
    }

    public void setKategorija(int Kategorija) {
        mKategorija = Kategorija;
    }

    @Override
    public String toString() {
        return "Artikl{" +
                "martiklId= " + martiklId +
                ", nazivArtikla= " + mNaziv +
                ", cijenaArtikla= " + mCijena +
                ", Kategorija= " + mKategorija +
                "}";
    }
}
