package com.example.marko.blagajnapp;

import android.app.Application;

public class BlagajnApp extends Application {

    private static BlagajnApp INSTANCE;

    public static BlagajnApp getINSTANCE(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
