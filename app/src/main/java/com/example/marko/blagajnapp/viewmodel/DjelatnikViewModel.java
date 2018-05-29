package com.example.marko.blagajnapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.marko.blagajnapp.repository.DjelatnikRepository;
import com.example.marko.blagajnapp.model.Djelatnik;

import java.util.List;

public class DjelatnikViewModel extends ViewModel {

    DjelatnikRepository mDjelatnikRepository;

    public DjelatnikViewModel(){
        mDjelatnikRepository = DjelatnikRepository.getINSTANCE();
    }

    public LiveData<List<Djelatnik>> getAllDjelatnik(){
        return mDjelatnikRepository.getAllDjelatnik();
    }

    public Djelatnik getDjelatnik(String username, String password){
        return mDjelatnikRepository.getDjelatnik(username,password).getValue();
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
