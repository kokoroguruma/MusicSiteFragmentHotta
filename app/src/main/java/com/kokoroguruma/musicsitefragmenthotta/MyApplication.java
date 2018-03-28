package com.kokoroguruma.musicsitefragmenthotta;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.kokoroguruma.musicsitefragmenthotta.access.Access;
import com.kokoroguruma.musicsitefragmenthotta.listPlayCenterList.ListPlayCenterListItem;
import com.kokoroguruma.musicsitefragmenthotta.playMusic.MusicPlayService;

import java.util.ArrayList;
import java.util.List;

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

	private List<ListPlayCenterListItem> listPlayCenterListItemList;


	private Intent musicPlayServiceIntent;

	@Override
	public void onCreate() {

		listPlayCenterListItemList = new ArrayList<ListPlayCenterListItem>();


		super.onCreate();
	}


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

	public String getSPass() {
		return sPass;
	}

	public void setSPass(String sPass) {
		this.sPass = sPass;
	}

	public List<ListPlayCenterListItem> getListPlayCenterListItemList() {
		return listPlayCenterListItemList;
	}

	public void setListPlayCenterListItemList(List<ListPlayCenterListItem> listPlayCenterListItemList) {
		this.listPlayCenterListItemList = listPlayCenterListItemList;
	}

// /Getter, Setter

	public void startMusicPlyaService(Context ins_Context) {
		Log.d("MyApplication: ", "startMusicPlayService()1: " + musicPlayServiceIntent);
		musicPlayServiceIntent = new Intent(ins_Context, MusicPlayService.class);
		Log.d("MyApplication: ", "startMusicPlayService()2: " + musicPlayServiceIntent);
		startService(musicPlayServiceIntent);
		this.bindPlay();
	}

	public void bindMusicPlayService(ServiceConnection ins_serviceConnection) {
		Log.d("MyApplication: ", "bindMusicPlayService():");

		bindService(musicPlayServiceIntent, ins_serviceConnection, Context.BIND_AUTO_CREATE);
		unbindService(ins_serviceConnection);


	}



	// TODO: これは削除予定bind(ServiceConnection s)に変えて　各動作は呼び出し元で
	public void bindPlay() {
		Log.d("MyApplication: ", "bind():");
		ServiceConnection serviceConnection = new ServiceConnection() {
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				Log.d("MyApplication: ", "bind(): on-Connected: ");
				Log.d("MyApplication: ", "bind(): on-Connected: ComponentName: " + name);
				Log.d("MyApplication: ", "bind(): on-Connected: IBinder: " + service);
				Log.d("MyApplication: ", "bind(): on-Connected: GetClass: " + service.getClass());

				MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
				musicPlayService.musicStart();
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				Log.d("MyApplication: ", "bind(): on-Disonnected: ");
				Log.d("MyApplication: ", "bind(): on-Disonnected: ComponentName: " + name);

			}
		};



		bindService(musicPlayServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
//		unbindService(serviceConnection);
	}


	/**
	 * ログアウト処理
	 */
	public void logout() {

		// オプションメニューの解除
		this.mainActivity.menuVisibllityFlag = false;
		this.mainActivity.invalidateOptionsMenu();


		// サーバのログアウト処理
		String addUrl = "logout?s_pass=" + this.sPass;
		Access access = new Access(addUrl);
		access.startAcsess();


		this.userId = null;
		this.sPass = null;
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
	public void login(String ins_userId, String ins_sPass) {

		this.userId = ins_userId;
		this.sPass = ins_sPass;

		this.loginFlag = true;


		this.mainActivity.setMainFragment(new PlayFragment());
	}


}
