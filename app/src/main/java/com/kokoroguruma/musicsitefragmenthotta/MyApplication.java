package com.kokoroguruma.musicsitefragmenthotta;

import android.app.Application;

/**
 * Created by Kokoroguruma on 2018/03/20.
 */

public class MyApplication extends Application {

    private MainActivity mainActivity;


    public void setMainActivity(MainActivity ins_mainActivity) {
        this.mainActivity = ins_mainActivity;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }




}
