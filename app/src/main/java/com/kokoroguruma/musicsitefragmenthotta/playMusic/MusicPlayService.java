package com.kokoroguruma.musicsitefragmenthotta.playMusic;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;


/**
 * 音声の再生機能。
 */
public class MusicPlayService extends Service {
	private final static String TAG = MusicPlayService.class.getSimpleName();

	private PlayMusics playMusics;

	public MusicPlayService() {
	}



	public class MusicPlayServiceBinder extends Binder {
		public MusicPlayService getService() {
			return MusicPlayService.this;
		}
	}

	// Binderの生成
	private IBinder iBinder = new MusicPlayServiceBinder();

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind(): intent: " + intent);
		Log.d(TAG, "onBind(): iBinder: " + iBinder);

		return iBinder;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d(TAG, "onUnbind(): intent: " + intent);
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate(): ");

		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStartCommand(): ");

		// TODO: これはテストです。修正すべし。音声ファイルの仮置き
		String url = "http://www.ne.jp/asahi/music/myuu/wave/menuettm.mp3";
		try {
			this.playMusics = new PlayMusics(0, "Title", url, "");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy(): ");
		super.onDestroy();
	}


	public void musicStart() {
		this.playMusics.start();
	}

	public void musicStop() {
		this.playMusics.stop();
	}

	public void musicPause() {
		this.playMusics.pause();
	}

	public void musicNext() {
		this.playMusics.next();
	}

	public void musicBack() {
		this.playMusics.back();
	}


	public void musicEnd() {
		this.playMusics.end();
	}

}
