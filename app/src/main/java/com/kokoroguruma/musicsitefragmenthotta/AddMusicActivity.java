package com.kokoroguruma.musicsitefragmenthotta;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/**
 * 音声の追加用アクティビティ
 */
public class AddMusicActivity extends AppCompatActivity {

	MyApplication application;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_music);

		application = (MyApplication) this.getApplication();

		this.onClickAddMusicSubmitButton();


		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);


	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menuLogout:
				// ログアウト
				application.logout();
				finish();
				break;
			case android.R.id.home:
				// 何もしないで戻る。
				finish();
				break;
		}

		return super.onOptionsItemSelected(item);
	}


	// ここからmenu管理
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_add_music, menu);
		return super.onCreateOptionsMenu(menu);
	}


	// ここからClick用


	private void onClickAddMusicSubmitButton() {
		Button button = findViewById(R.id.addMusicSubmitButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO: Music新規登録作業
			}
		});
	}


}
