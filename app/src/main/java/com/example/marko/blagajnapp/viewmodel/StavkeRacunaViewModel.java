package com.example.marko.blagajnapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.marko.blagajnapp.model.StavkeRacuna;
import com.example.marko.blagajnapp.repository.StavkeRacunaRepository;

import java.util.List;

public class StavkeRacunaViewModel extends ViewModel {

    StavkeRacunaRepository mStavkeRacunaRepository;

    public StavkeRacunaViewModel (){
        mStavkeRacunaRepository = StavkeRacunaRepository.getINSTANCE();
    }

    public LiveData<List<StavkeRacuna>> getAllStavkeRacuna(){
        return mStavkeRacunaRepository.getAllStavkeRacuna();
    }

    public void insertStavkeRacuna(List<StavkeRacuna> stavkeRacuna){
        mStavkeRacunaRepository.insertStavkeRacuna(stavkeRacuna);
    }
}
