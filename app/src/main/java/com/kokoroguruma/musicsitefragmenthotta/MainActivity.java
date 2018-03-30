package com.kokoroguruma.musicsitefragmenthotta;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
	private final static String TAG = MainActivity.class.getSimpleName();

	MyApplication application;

	FragmentManager fragmentManager;

	Boolean menuVisibllityFlag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		application = (MyApplication) this.getApplication();
		application.setMainActivity(this);


		fragmentManager = getSupportFragmentManager();


	}


	@Override
	protected void onResume() {
		this.mainFragment();
		super.onResume();
	}


	// ここからmenu管理
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (menuVisibllityFlag) {
			MenuInflater menuInflater = getMenuInflater();
			menuInflater.inflate(R.menu.menu, menu);
		}
		return super.onCreateOptionsMenu(menu);
	}

	public void setMenuVisibllityFlag(Boolean ins_menuVisibllityFlag) {
		this.menuVisibllityFlag = ins_menuVisibllityFlag;
	}


	// ここからFragmentの管理

	// 開始時画面
	private void mainFragment() {
		if (application.getLoginFlag()) {
			this.setMainFragment(new PlayFragment());
		} else {
			this.setMainFragment(new LoginFragment());
		}
	}

	// PlayCenterのListの更新。
	public void updateCenterList() {

	}


	/**
	 * mainFragmentの切り替え用
	 *
	 * @param fragment セットされるフラグメント
	 */
	public void setMainFragment(Fragment fragment) {
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.mainFragment, fragment);
		fragmentTransaction.commit();
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menuAddMusic:
				// 音声追加画面へ
				Intent intent = new Intent(getApplicationContext(), AddMusicActivity.class);
				startActivity(intent);
				break;
			case R.id.menuLogout:
				// ログアウト
				application.logout();
				break;
			case android.R.id.home:
				// 戻る。
				this.setMainFragment(new LoginFragment());
				break;
		}

		return super.onOptionsItemSelected(item);
	}
}
