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
		Log.d("MusicPlayService: ", "onBind(): intent: " + intent);
		Log.d("MusicPlayService: ", "onBind(): iBinder: " + iBinder);

		return iBinder;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("MusicPlayService: ", "onUnbind(): intent: " + intent);
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		Log.d("MusicPlayService: ", "onCreate(): ");

		// TODO: これはテストです。修正すべし。
		String url = "http://listen.kibo.fm:8000/kibofm";
		try {
			this.playMusics = new PlayMusics(0, "Title", url, "");
		} catch (IOException e) {
			e.printStackTrace();
		}

		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("MusicPlayService: ", "onStartCommand(): ");

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.d("MusicPlayService: ", "onDestroy(): ");
		super.onDestroy();
	}


	public void musicStart() {
		this.playMusics.start();
	}

	public void musicStop() {
		this.playMusics.stop();
	}

}
