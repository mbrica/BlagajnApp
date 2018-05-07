package com.example.marko.blagajnapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ArtiklRepository {

    public static ArtiklRepository INSTANCE;

    private BlagajnAppDatabase mDatabase;
    private LiveData<List<Artikl>> mData;

    private ArtiklRepository(Application application){
        mDatabase = BlagajnAppDatabase.getInstance(application);
        mData = mDatabase.artiklDao().getArtikliIzKategorije();
    }

    public static ArtiklRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new ArtiklRepository(BlagajnApp.getINSTANCE());
        }
        return INSTANCE;
    }

    public LiveData<List<Artikl>> getArtikliIzKategorije() {
        return mData;
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
