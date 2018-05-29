package com.example.marko.blagajnapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Kategorija {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kategorijaId")
    public int mkategorijaId;

    @ColumnInfo(name = "nazivKategorije")
    private String mNazivKategorije;

    public Kategorija (){}

    public Kategorija ( String nazivKategorije){
        mNazivKategorije = nazivKategorije;
    }


    public int getMKategorijaId(){
        return mkategorijaId;
    }

    public void setMKategorijaId(int kategorijaId){
        this.mkategorijaId = kategorijaId;
    }

    public String getNazivKategorije(){
        return mNazivKategorije;
    }

    public void setNazivKategorije(String nazivKategorije){
         mNazivKategorije = nazivKategorije;
    }

    @Override
    public String toString(){
        return "Kategorija{" +
                "kategorijaId=" + mkategorijaId +
                ", nazivKategorije=" + mNazivKategorije +
                "}";
    }
}
