package com.kokoroguruma.musicsitefragmenthotta;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.kokoroguruma.musicsitefragmenthotta.access.Access;
import com.kokoroguruma.musicsitefragmenthotta.listDlAddList.ListDlAddListItem;
import com.kokoroguruma.musicsitefragmenthotta.listPlayCenterList.ListPlayCenterListItem;
import com.kokoroguruma.musicsitefragmenthotta.playMusic.MediaPlayerData;
import com.kokoroguruma.musicsitefragmenthotta.playMusic.MusicPlayService;
import com.kokoroguruma.musicsitefragmenthotta.playMusic.PlayMusics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 各種データ管理。
 * Activitiy全体も管理。
 * Created by Kokoroguruma on 2018/03/20.
 */
public class MyApplication extends Application {
	private final static String TAG = MyApplication.class.getSimpleName();

	private MainActivity mainActivity;

	private PlayPlayingViewFragment playPlayingViewFragment;
	private PlayCenterPlayingListFragment playCenterPlayingListFragment;

	private Boolean loginFlag = false;

	private String userId;
	private String sPass;

	private List<ListPlayCenterListItem> listPlayCenterListItemList;
	private List<ListDlAddListItem> listDlAddListItemList;

	PlayMusics playMusics;

	private Intent musicPlayServiceIntent;

	@Override
	public void onCreate() {

		this.listPlayCenterListItemList = new ArrayList<ListPlayCenterListItem>();
		this.listDlAddListItemList = new ArrayList<ListDlAddListItem>();


		super.onCreate();
	}


	// Getter, Setter

	public MainActivity getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	public PlayCenterPlayingListFragment getPlayCenterPlayingListFragment() {
		return playCenterPlayingListFragment;
	}

	public void setPlayCenterPlayingListFragment(PlayCenterPlayingListFragment playCenterPlayingListFragment) {
		this.playCenterPlayingListFragment = playCenterPlayingListFragment;
	}

	public PlayPlayingViewFragment getPlayPlayingViewFragment() {
		return playPlayingViewFragment;
	}

	public void setPlayPlayingViewFragment(PlayPlayingViewFragment playPlayingViewFragment) {
		this.playPlayingViewFragment = playPlayingViewFragment;
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

	public List<ListDlAddListItem> getListDlAddListItemList() {
		return listDlAddListItemList;
	}

	public void setListDlAddListItemList(List<ListDlAddListItem> listDlAddListItemList) {
		this.listDlAddListItemList = listDlAddListItemList;
	}

	// /Getter, Setter

	public void startMusicPlyaService(Context ins_Context) {
		musicPlayServiceIntent = new Intent(ins_Context, MusicPlayService.class);
		Log.d(TAG, "startMusicPlayService(): " + musicPlayServiceIntent);
		startService(musicPlayServiceIntent);
	}

	public void bindMusicPlayService(ServiceConnection ins_serviceConnection) {
		Log.d(TAG, "bindMusicPlayService():");

		bindService(musicPlayServiceIntent, ins_serviceConnection, Context.BIND_AUTO_CREATE);
		unbindService(ins_serviceConnection);


	}

	// ここから：List操作

	/**
	 * 左に表示されるリストから中央のリストに追加する。
	 * @param ins_position
	 */
	public void addListPlayCenterListItemByListDlAddListAdapter(int ins_position) {
		ListDlAddListItem listDlAddListItem = listDlAddListItemList.get(ins_position);

		ListPlayCenterListItem listPlayCenterListItem = new ListPlayCenterListItem(
				listDlAddListItem.getMusicId(),
				listDlAddListItem.getMusicName(),
				listDlAddListItem.getMusicUrl(),
				listDlAddListItem.getMusicComment()
		);

		this.listPlayCenterListItemList.add(listPlayCenterListItem);

		this.playCenterPlayingListFragment.updateList();

		// TODO: PlayMusicsをBindサービスで撮ってきて追加追加
		try {
			MediaPlayerData mediaPlayerData = new MediaPlayerData(
					listDlAddListItem.getMusicId(),
					listDlAddListItem.getMusicName(),
					listDlAddListItem.getMusicUrl(),
					listDlAddListItem.getMusicComment()
			);

			ServiceConnection serviceConnection = new ServiceConnection() {
				@Override
				public void onServiceConnected(ComponentName name, IBinder service) {
					MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
					musicPlayService.getPlayMusics(); // TODO: ここ最優先！！！！！！！！！！！
				}

				@Override
				public void onServiceDisconnected(ComponentName name) {

				}
			};



		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
		PlayCenterPlayingListFragment playCenterPlayingListFragment = (PlayCenterPlayingListFragment) fragmentManager.findFragmentByTag(PlayCenterPlayingListFragment.class.getSimpleName());
		Log.d(TAG, "addListPlayCen--Adapter: " + playCenterPlayingListFragment);

		playCenterPlayingListFragment.updateList();
		*/
	}

	public void deleteListPlayCenterItem(int ins_position) {

		listPlayCenterListItemList.remove(ins_position);

		this.playCenterPlayingListFragment.updateList();
	}

	public void playingListPlayCenterItem(int ins_position) {
		// TODO: 音声再生。


	}


	// ここまで：List操作


	// TODO: これは削除予定bind(ServiceConnection s)に変えて　各動作は呼び出し元で
	public void bindPlay() {
		Log.d(TAG, "bind():");
		ServiceConnection serviceConnection = new ServiceConnection() {
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				Log.d(TAG, "bind(): on-Connected: ");
				Log.d(TAG, "bind(): on-Connected: ComponentName: " + name);
				Log.d(TAG, "bind(): on-Connected: IBinder: " + service);
				Log.d(TAG, "bind(): on-Connected: GetClass: " + service.getClass());

				MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
				musicPlayService.musicStart();
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				Log.d(TAG, "bind(): on-Disonnected: ");
				Log.d(TAG, "bind(): on-Disonnected: ComponentName: " + name);

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

		// サービスの停止
		ServiceConnection serviceConnection = new ServiceConnection() {
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				Log.d(TAG, "logout(): on-Connected: ComponentName: " + name);
				Log.d(TAG, "logout(): on-Connected: IBinder: " + service);
				Log.d(TAG, "logout(): on-Connected: GetClass: " + service.getClass());

				MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
				musicPlayService.musicEnd();
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				Log.d(TAG, "logout(): on-Disonnected: ComponentName: " + name);

			}
		};

		bindService(musicPlayServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);

		this.stopService(musicPlayServiceIntent);


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
