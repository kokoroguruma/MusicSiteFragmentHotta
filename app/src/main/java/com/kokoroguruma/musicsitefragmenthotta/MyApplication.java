package com.kokoroguruma.musicsitefragmenthotta;

import android.app.Application;

/**
 * 各種データ管理。
 * Activitiy全体も管理。
 * Created by Kokoroguruma on 2018/03/20.
 */
public class MyApplication extends Application {

    private MainActivity mainActivity;

    private String userId;
    private String sPass;


    public void setMainActivity(MainActivity ins_mainActivity) {
        this.mainActivity = ins_mainActivity;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }


    /**
     * ログアウト処理
     */
    public void logout() {
        // TODO: ログアウト処理
        this.mainActivity.menuVisibllityFlag = false;
        this.mainActivity.invalidateOptionsMenu();
        this.mainActivity.setMainFragment(new LoginFragment());
    }


    /**
     * ログイン処理
     */
    public void login() {
        // TODO: ログイン処理、判定等
        this.mainActivity.setMainFragment(new PlayFragment());
    }



}
