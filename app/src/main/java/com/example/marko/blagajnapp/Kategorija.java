package com.example.marko.blagajnapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Kategorija {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kategorijaId")
    //ne radi(ne pronalazi getter) kada je ova varijabla private ???
    public int mkategorijaId;

    @ColumnInfo(name = "nazivKategorije")
    private String mNazivKategorije;

    //Prazan konstruktor, bez njega ne radi
    public Kategorija (){}

    public Kategorija (int kategorijaId, String nazivKategorije){
        mkategorijaId = kategorijaId;
        mNazivKategorije = nazivKategorije;
    }


    public int getKategorijaId(){
        return mkategorijaId;
    }

    public void setKategorijaId(int kategorijaId){
        mkategorijaId = kategorijaId;
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
