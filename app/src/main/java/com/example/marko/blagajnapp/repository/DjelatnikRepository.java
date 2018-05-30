package com.example.marko.blagajnapp.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.example.marko.blagajnapp.BlagajnApp;
import com.example.marko.blagajnapp.model.Djelatnik;
import com.example.marko.blagajnapp.room.BlagajnAppDatabase;
import com.example.marko.blagajnapp.room.DjelatnikDao;

import java.util.List;

public class DjelatnikRepository {

    private static DjelatnikRepository INSTANCE;

    private BlagajnAppDatabase mDatabase;

    private DjelatnikRepository(Application application){
        mDatabase = BlagajnAppDatabase.getInstance(application);
    }

    public static DjelatnikRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new DjelatnikRepository(BlagajnApp.getINSTANCE());
        }
        return INSTANCE;
    }

    public LiveData<List<Djelatnik>> getAllDjelatnik(){
        return mDatabase.djelatnikDao().getAllDjelatnik();
    }

    public LiveData<Djelatnik> getDjelatnik(String username, String password){
        return mDatabase.djelatnikDao().getDjelatnik(username,password);
    }

    public LiveData<Djelatnik> getDjelatnikByID(int djelatnikId){
        return mDatabase.djelatnikDao().getDjelatnikByID(djelatnikId);
    }

    public void insertDjelatnik(Djelatnik djelatnik){
        new insertDjelatnikAsyncTask(mDatabase.djelatnikDao()).execute(djelatnik);
    }

    public void deleteDjelatnik(Djelatnik djelatnik){
        new deleteDjelatnikAsyncTask(mDatabase.djelatnikDao()).execute(djelatnik);
    }

    public void updateDjelatnik(Djelatnik djelatnik){
        new updateDjelatnikAsyncTask(mDatabase.djelatnikDao()).execute(djelatnik);
    }


    private class insertDjelatnikAsyncTask extends AsyncTask<Djelatnik, Void, Void>{

        private DjelatnikDao mDjelatnikDao;

        public insertDjelatnikAsyncTask(DjelatnikDao djelatnikDao){
            mDjelatnikDao = djelatnikDao;
        }
        @Override
        protected Void doInBackground(Djelatnik... djelatnici) {
            mDjelatnikDao.insertDjelatnik(djelatnici[0]);
            return null;
        }
    }

    private class deleteDjelatnikAsyncTask extends AsyncTask<Djelatnik, Void, Void>{

        private DjelatnikDao mDjelatnikDao;

        public deleteDjelatnikAsyncTask(DjelatnikDao djelatnikDao){
            mDjelatnikDao = djelatnikDao;
        }

        @Override
        protected Void doInBackground(Djelatnik... djelatnici) {
            mDjelatnikDao.deleteDjelatnik(djelatnici[0]);
            return null;
        }
    }

    private class updateDjelatnikAsyncTask extends AsyncTask<Djelatnik, Void, Void>{

        private DjelatnikDao mDjelatnikDao;

        public updateDjelatnikAsyncTask(DjelatnikDao djelatnikDao){
            mDjelatnikDao = djelatnikDao;
        }
        @Override
        protected Void doInBackground(Djelatnik... djelatnici) {
            mDjelatnikDao.updateDjelatnik(djelatnici[0]);
            return null;
        }
    }
}
