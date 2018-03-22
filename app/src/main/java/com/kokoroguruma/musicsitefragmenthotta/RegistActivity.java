package com.kokoroguruma.musicsitefragmenthotta;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * 新規ユーザー登録が出来る。
 */
public class RegistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);




        this.onClickRegistSubmitButton();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // 何もしないで戻る。
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }




    // ここからClick用

    private void onClickRegistSubmitButton() {
        Button button = findViewById(R.id.registSubmitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 新規登録処理
            }
        });


    }




}
