package com.example.marko.blagajnapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class DjelatnikViewModel extends ViewModel {

    DjelatnikRepository mDjelatnikRepository;

    public DjelatnikViewModel(){
        mDjelatnikRepository = DjelatnikRepository.getINSTANCE();
    }

    public LiveData<List<Djelatnik>> getAllDjelatnik(){
        return mDjelatnikRepository.getAllDjelatnik();
    }

    public void insertDjelatnik(Djelatnik djelatnik){
        mDjelatnikRepository.insertDjelatnik(djelatnik);
    }

    public void deleteDjelatnik(Djelatnik djelatnik){
        mDjelatnikRepository.deleteDjelatnik(djelatnik);
    }

    public void updateDjelatnik(Djelatnik djelatnik){
        mDjelatnikRepository.updateDjelatnik(djelatnik);
    }
}
