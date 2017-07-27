package com.johnriggs.digitalturbine.horizontal.application;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by johnriggs on 7/26/17.
 */

public class DTApp extends Application {
    private static DTApp app;

    public DTApp(){
        app = this;
    }

    public static DTApp getApp(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
