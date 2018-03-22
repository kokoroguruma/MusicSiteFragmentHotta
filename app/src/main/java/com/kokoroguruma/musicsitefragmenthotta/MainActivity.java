package com.kokoroguruma.musicsitefragmenthotta;

import android.app.ActionBar;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyApplication application;

    ActionBar actionBar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        application = (MyApplication) this.getApplication();
        application.setMainActivity(this);

        actionBar = getActionBar();
        fragmentManager = getSupportFragmentManager();

        this.startMainFragment();

//        this.onClickImplementsList();

    }


    // 開始時画面
    private void startMainFragment() {
        this.setMainFragment(new LoginFragment());
    }





    // ここからOnClick系列
    private void onClickImplementsList() {
        this.onClickLoginSubmitButton();
        this.onClickLoginIntentRegistButton();
        this.onClickRegistSubmitButton();

    }



    private void onClickLoginSubmitButton() {
        // 文字チェックしてPlayに切り替え
    }


    private void onClickLoginIntentRegistButton() {
        Button button = findViewById(R.id.loginIntentRegistButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMainFragment(new RegistFragment());
            }
        });
    }


    private void onClickRegistSubmitButton() {
        Button button = findViewById(R.id.registSubmitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMainFragment(new LoginFragment());
            }
        });
    }








    // ここからFragmentの管理


    /**
     * mainFragmentの切り替え用
     * @param fragment セットされるフラグメント
     */
    public void setMainFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFragment, fragment);
        fragmentTransaction.commit();
    }


    private void showRegistFragment() {
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void unShowRegistFragment() {
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // 戻る。
                this.setMainFragment(new LoginFragment());
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
