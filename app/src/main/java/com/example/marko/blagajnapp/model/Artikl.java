package com.example.marko.blagajnapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Kategorija.class, parentColumns = "kategorijaId",childColumns = "Kategorija"))
public class Artikl {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "artiklId")
    private int martiklId;

    @ColumnInfo(name = "nazivArtikla")
    private String mNaziv;

    @ColumnInfo(name = "cijenaArtikla")
    private float mCijena;

    @ColumnInfo(name = "Kategorija")
    private int mKategorija;

    @ColumnInfo(name = "KategorijaNaziv")
    private String mKategorijaNaziv;

    public Artikl(int martiklId, String mNaziv, float mCijena, int mKategorija, String mKategorijaNaziv){
        this.martiklId = martiklId;
        this.mNaziv = mNaziv;
        this.mCijena = mCijena;
        this.mKategorija = mKategorija;
        this.mKategorijaNaziv = mKategorijaNaziv;
    }

    @Ignore
    public Artikl(String mNaziv, float mCijena, int mKategorija, String mKategorijaNaziv){
        this.mNaziv = mNaziv;
        this.mCijena = mCijena;
        this.mKategorija = mKategorija;
        this.mKategorijaNaziv = mKategorijaNaziv;
    }

    public int getMartiklId () {
        return martiklId;
    }

    public void setMartiklId(int artiklId) {
        martiklId = artiklId;
    }

    public String getMNaziv() {
        return mNaziv;
    }

    public void setMNaziv(String nazivArtikla) {
        mNaziv = nazivArtikla;
    }

    public float getMCijena() {
        return mCijena;
    }

    public void setMCijena(float cijenaArtikla) {
        mCijena = cijenaArtikla;
    }

    public int getKategorija() {
        return mKategorija;
    }

    public void setKategorija(int Kategorija) {
        mKategorija = Kategorija;
    }

    public String getMKategorijaNaziv() {
        return mKategorijaNaziv;
    }

    public void setMkategorijaNaziv (String mKategorijaNaziv){
        this.mKategorijaNaziv = mKategorijaNaziv;
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
