package com.kokoroguruma.musicsitefragmenthotta;

import android.app.Application;

/**
 * 各種データ管理。
 * Activitiy全体も管理。
 * Created by Kokoroguruma on 2018/03/20.
 */
public class MyApplication extends Application {

    private MainActivity mainActivity;

    private Boolean loginFlag = false;

    private String userId;
    private String sPass;


    // Getter, Setter

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Boolean getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(Boolean loginFlag) {
        this.loginFlag = loginFlag;
    }

    // /Getter, Setter



    /**
     * ログアウト処理
     */
    public void logout() {
        // TODO: ログアウト処理

        // オプションメニューの解除
        this.mainActivity.menuVisibllityFlag = false;
        this.mainActivity.invalidateOptionsMenu();

        this.loginFlag = false;
        // MainActivity以外からの操作用に try-catch
        try {
            this.mainActivity.setMainFragment(new LoginFragment());
        } catch (IllegalStateException e) {

        }
    }


    /**
     * ログイン処理
     */
    public void login() {
        // TODO: ログイン処理、判定等
        this.loginFlag = true;
        this.mainActivity.setMainFragment(new PlayFragment());
    }



}
