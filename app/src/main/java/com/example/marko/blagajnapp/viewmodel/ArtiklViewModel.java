package com.example.marko.blagajnapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.marko.blagajnapp.repository.ArtiklRepository;
import com.example.marko.blagajnapp.model.Artikl;

import java.util.List;

public class ArtiklViewModel extends ViewModel {

    ArtiklRepository mArtiklRepository;

    public ArtiklViewModel(){
        mArtiklRepository = ArtiklRepository.getINSTANCE();
    }

    public LiveData<List<Artikl>> getArtikliIzKategorije(int kategorijaID){
        return mArtiklRepository.getArtikliIzKategorije(kategorijaID);
    }

    public LiveData<List<Artikl>> getArtikli(){
        return mArtiklRepository.getArtili();
    }

    public LiveData<Artikl> getArtiklByID(int artiklID){
        return mArtiklRepository.getArtiklByID(artiklID);
    }

    public void insertArtikl(Artikl artikl){
        mArtiklRepository.insertArtikl(artikl);
    }

    public void deleteArtikl(Artikl artikl){
        mArtiklRepository.deleteArtikl(artikl);
    }

    public void updateArtikl(Artikl artikl){
        mArtiklRepository.updateArtikl(artikl);
    }
}
