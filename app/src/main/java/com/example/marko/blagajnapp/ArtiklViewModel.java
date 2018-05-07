package com.example.marko.blagajnapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class ArtiklViewModel extends ViewModel {

    ArtiklRepository mArtiklRepository;

    public ArtiklViewModel(){
        mArtiklRepository = ArtiklRepository.getINSTANCE();
    }

    public LiveData<List<Artikl>> getArtikliIzKategorije(){
        return mArtiklRepository.getArtikliIzKategorije();
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
