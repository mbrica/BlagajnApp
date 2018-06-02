package com.example.marko.blagajnapp.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.example.marko.blagajnapp.BlagajnApp;
import com.example.marko.blagajnapp.model.Artikl;
import com.example.marko.blagajnapp.room.ArtiklDao;
import com.example.marko.blagajnapp.room.BlagajnAppDatabase;

import java.util.List;

public class ArtiklRepository {

    public static ArtiklRepository INSTANCE;

    private BlagajnAppDatabase mDatabase;

    private ArtiklRepository(Application application){
        mDatabase = BlagajnAppDatabase.getInstance(application);
    }

    public static ArtiklRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new ArtiklRepository(BlagajnApp.getINSTANCE());
        }
        return INSTANCE;
    }

    public LiveData<List<Artikl>> getArtikliIzKategorije(int kategorijaID) {
        return mDatabase.artiklDao().getArtikliIzKategorije(kategorijaID);
    }

    public LiveData<List<Artikl>> getArtili(){
        return mDatabase.artiklDao().getArtikli();
    }

    public LiveData<Artikl> getArtiklByID(int artiklId){
        return mDatabase.artiklDao().getArtiklByID(artiklId);
    }

    public void insertArtikl(Artikl artikl){
        new insertArtiklAsyncTask(mDatabase.artiklDao()).execute(artikl);
    }

    public void deleteArtikl(Artikl artikl){
        new deleteArtiklAsyncTask(mDatabase.artiklDao()).execute(artikl);
    }

    public void updateArtikl(Artikl artikl){
        new updateArtiklAsyncTask(mDatabase.artiklDao()).execute(artikl);
    }


    private class insertArtiklAsyncTask extends AsyncTask<Artikl, Void, Void>{

        private ArtiklDao mArtiklDao;

        public insertArtiklAsyncTask(ArtiklDao artiklDao){
            mArtiklDao = artiklDao;
        }

        @Override
        protected Void doInBackground(Artikl... artikli) {
            mArtiklDao.insertArtikl(artikli[0]);
            return null;
        }
    }

    private class deleteArtiklAsyncTask extends AsyncTask<Artikl, Void, Void>{

        private ArtiklDao mArtiklDao;

        public deleteArtiklAsyncTask(ArtiklDao artiklDao){
            mArtiklDao = artiklDao;
        }

        @Override
        protected Void doInBackground(Artikl... artikli) {
            mArtiklDao.deleteArtikl(artikli[0]);
            return null;
        }
    }

    private class updateArtiklAsyncTask extends AsyncTask<Artikl, Void, Void>{

        private ArtiklDao mArtiklDao;

        public updateArtiklAsyncTask(ArtiklDao artiklDao){
            mArtiklDao = artiklDao;
        }

        @Override
        protected Void doInBackground(Artikl... artikli) {
            mArtiklDao.updateArtikl(artikli[0]);
            return null;
        }
    }
}
