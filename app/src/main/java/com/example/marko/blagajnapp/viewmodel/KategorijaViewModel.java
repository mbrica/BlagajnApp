package com.example.marko.blagajnapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import com.example.marko.blagajnapp.repository.KategorijaRepository;
import com.example.marko.blagajnapp.model.Kategorija;

import java.util.List;




public class KategorijaViewModel extends ViewModel {

    KategorijaRepository mKategorijaRepository;

    public KategorijaViewModel(){
        mKategorijaRepository = KategorijaRepository.getINSTANCE();
    }

    public LiveData<List<Kategorija>> getAllKategorije(){
        return mKategorijaRepository.getAllKategorije();
    }

    public LiveData<Kategorija> getKategorijaByID(int kategorijaId){
        return mKategorijaRepository.getKategorijaByID(kategorijaId);
    }

    public void insertKategorija(Kategorija kategorija){
        mKategorijaRepository.insertKategorija(kategorija);
    }

    public void deleteKategorija(Kategorija kategorija){
        mKategorijaRepository.deleteKategorija(kategorija);
    }

    public void updateKategorija(Kategorija kategorija){
        mKategorijaRepository.updateKategorija(kategorija);
    }
}
