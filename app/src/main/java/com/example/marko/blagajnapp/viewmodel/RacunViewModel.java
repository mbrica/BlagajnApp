package com.example.marko.blagajnapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.marko.blagajnapp.repository.RacunRepository;
import com.example.marko.blagajnapp.model.Racun;

import java.util.List;

public class RacunViewModel extends ViewModel {

    RacunRepository mRacunRepository;

    public RacunViewModel(){
        mRacunRepository = RacunRepository.getINSTANCE();
    }

    public LiveData<List<Racun>> getAllRacuni(){
        return mRacunRepository.getAllRacuni();
    }

    public void insertRacun(Racun racun){
        mRacunRepository.insertRacun(racun);
    }


}
