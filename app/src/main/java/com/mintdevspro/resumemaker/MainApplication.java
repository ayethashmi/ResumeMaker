package com.mintdevspro.resumemaker;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;


public class MainApplication extends Application {


    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(1);
    }
}
