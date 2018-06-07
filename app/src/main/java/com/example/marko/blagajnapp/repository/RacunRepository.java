package com.example.marko.blagajnapp.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.example.marko.blagajnapp.BlagajnApp;
import com.example.marko.blagajnapp.model.Racun;
import com.example.marko.blagajnapp.model.RacunData;
import com.example.marko.blagajnapp.room.BlagajnAppDatabase;
import com.example.marko.blagajnapp.room.RacunDao;

import java.util.List;

public class RacunRepository {

    private static RacunRepository INSTANCE;

    private BlagajnAppDatabase mDatabase;

    private RacunRepository(Application application){
        mDatabase = BlagajnAppDatabase.getInstance(application);
    }

    public static RacunRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new RacunRepository(BlagajnApp.getINSTANCE());
        }
        return INSTANCE;
    }

    public LiveData<List<Racun>> getAllRacuni() {
        return mDatabase.racunDao().getAllRacuni();
    }

    public LiveData<List<RacunData>> getAllRacuniIStavkeRacuna(){
        return mDatabase.racunDao().getAllRacuniIStavkeRacuna();
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
