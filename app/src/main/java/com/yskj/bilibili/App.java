package com.yskj.bilibili;

import android.app.Application;

/**
 * Created by saber on 2018/1/4
 */

public class App extends Application {
    public static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static App getInstance(){
        return mApp;
    }
}
