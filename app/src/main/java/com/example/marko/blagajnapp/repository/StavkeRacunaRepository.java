package com.example.marko.blagajnapp.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.marko.blagajnapp.BlagajnApp;
import com.example.marko.blagajnapp.model.StavkeRacuna;
import com.example.marko.blagajnapp.room.BlagajnAppDatabase;
import com.example.marko.blagajnapp.room.StavkeRacunaDao;

import java.util.List;

public class StavkeRacunaRepository {

    public static StavkeRacunaRepository INSTANCE;

    private BlagajnAppDatabase mDatabase;

    private StavkeRacunaRepository(Application application){
        mDatabase = BlagajnAppDatabase.getInstance(application);
    }

    public static StavkeRacunaRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new StavkeRacunaRepository(BlagajnApp.getINSTANCE());
        }
        return INSTANCE;
    }

    public LiveData<List<StavkeRacuna>> getAllStavkeRacuna(){
        return mDatabase.stavkeRacunaDao().getAllStavkeRacuna();
    }

    public void insertStavkeRacuna(List<StavkeRacuna> stavkeRacuna){
        new insertStavkeRacunaAsyncTask(mDatabase.stavkeRacunaDao()).execute(stavkeRacuna);
    }

    private class insertStavkeRacunaAsyncTask extends AsyncTask<List<StavkeRacuna>, Void, Void>{

        private StavkeRacunaDao mStavkeRacunaDao;

        public insertStavkeRacunaAsyncTask(StavkeRacunaDao stavkeRacunaDao){
            mStavkeRacunaDao = stavkeRacunaDao;
        }

        @Override
        protected Void doInBackground(List<StavkeRacuna>... stavkeRacuna) {
            mStavkeRacunaDao.insertStavkeRacuna(stavkeRacuna[0]);
            return null;
        }
    }
}
