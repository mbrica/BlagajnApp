package com.example.marko.blagajnapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class RacunRepository {

    private static RacunRepository INSTANCE;

    private BlagajnAppDatabase mDatabase;
    private LiveData<List<Racun>> mData;

    private RacunRepository(Application application){
        mDatabase = BlagajnAppDatabase.getInstance(application);
        mData = mDatabase.racunDao().getAllRacuni();
    }

    public static RacunRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new RacunRepository(BlagajnApp.getINSTANCE());
        }
        return INSTANCE;
    }

    public LiveData<List<Racun>> getAllRacuni() {
        return mData;
    }

    public void insertRacun (Racun racun){
        new insertRacunAsyncTask(mDatabase.racunDao()).execute(racun);
    }

    private class insertRacunAsyncTask extends AsyncTask<Racun, Void, Void>{

        private RacunDao mRacunDao;

        public insertRacunAsyncTask(RacunDao racunDao){
            mRacunDao = racunDao;
        }

        @Override
        protected Void doInBackground(Racun... racuni) {
            mRacunDao.insertRacun(racuni[0]);
            return null;
        }
    }
}
