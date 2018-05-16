package com.example.marko.blagajnapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.marko.blagajnapp.BlagajnApp;
import com.example.marko.blagajnapp.model.Admin;
import com.example.marko.blagajnapp.room.AdminDao;
import com.example.marko.blagajnapp.room.BlagajnAppDatabase;

public class AdminRepository {

    public static AdminRepository INSTANCE;

    private BlagajnAppDatabase mDatabase;

    private AdminRepository(Application application){
        mDatabase = BlagajnAppDatabase.getInstance(application);
    }

    public static AdminRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new AdminRepository(BlagajnApp.getINSTANCE());
        }
        return INSTANCE;
    }

    public void insertAdmin(Admin admin){
        new insertAdminAsyncTask(mDatabase.adminDao()).execute(admin);
    }

    private class insertAdminAsyncTask extends AsyncTask<Admin, Void, Void>{

        private AdminDao mAdminDao;

        public insertAdminAsyncTask(AdminDao adminDao){
            mAdminDao = adminDao;
        }

        @Override
        protected Void doInBackground(Admin... admini) {
             mAdminDao.insertAdmin(admini[0]);
             return null;
        }
    }
}
