package com.example.marko.blagajnapp.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.example.marko.blagajnapp.BlagajnApp;
import com.example.marko.blagajnapp.model.Kategorija;
import com.example.marko.blagajnapp.room.BlagajnAppDatabase;
import com.example.marko.blagajnapp.room.KategorijaDao;

import java.util.List;

public class KategorijaRepository {

    private static KategorijaRepository INSTANCE;

    private BlagajnAppDatabase mDatabase;

    private KategorijaRepository(Application application){
        mDatabase = BlagajnAppDatabase.getInstance(application);
    }

    public static KategorijaRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new KategorijaRepository(BlagajnApp.getINSTANCE());
        }
        return INSTANCE;
    }

    public LiveData<List<Kategorija>> getAllKategorije(){
        return mDatabase.kategorijaDao().getAllKategorije();
    }

    public LiveData<Kategorija> getKategorijaByID(int kategorijaId){
        return mDatabase.kategorijaDao().getKategorijaByID(kategorijaId);
    }

    //Dodavaje kategroije u bazu
    public void insertKategorija(Kategorija kategorija){
        new insertKategorijaAsyncTask(mDatabase.kategorijaDao()).execute(kategorija);
    }

    //Brisanje kategorije iz baze
    public void deleteKategorija(Kategorija kategorija){
        new deleteKategorijaAsyncTask(mDatabase.kategorijaDao()).execute(kategorija);
    }

    //updateanje kategorije iz baze
    public void updateKategorija(Kategorija kategorija){
        new updateKategorijaAsyncTask(mDatabase.kategorijaDao()).execute(kategorija);
    }



    //klasa za dodavanje
    private class insertKategorijaAsyncTask extends AsyncTask<Kategorija, Void, Void>{

        private KategorijaDao mKategorijaDao;

        public insertKategorijaAsyncTask(KategorijaDao kategorijaDao) {
            mKategorijaDao = kategorijaDao;
        }

        @Override
        protected Void doInBackground(Kategorija... kategorije) {
            mKategorijaDao.insertKategorija(kategorije[0]);
            return null;
        }
    }

    //klasa za brisanje
    private class deleteKategorijaAsyncTask extends AsyncTask<Kategorija, Void, Void>{

        private KategorijaDao mKategorijaDao;

        public deleteKategorijaAsyncTask(KategorijaDao kategorijaDao){
            mKategorijaDao = kategorijaDao;
        }

        @Override
        protected Void doInBackground(Kategorija... kategorije) {
            mKategorijaDao.deleteKategorija(kategorije[0]);
            return null;
        }
    }

    //klasa za updatanje
    private class updateKategorijaAsyncTask extends AsyncTask<Kategorija, Void, Void>{

        private KategorijaDao mKategorijaDao;

        public updateKategorijaAsyncTask(KategorijaDao kategorijaDao){
            mKategorijaDao = kategorijaDao;
        }

        @Override
        protected Void doInBackground(Kategorija... kategorije) {
            mKategorijaDao.updateKategorija(kategorije[0]);
            return null;
        }
    }
}
