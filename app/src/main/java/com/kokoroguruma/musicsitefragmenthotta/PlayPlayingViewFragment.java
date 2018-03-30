package com.kokoroguruma.musicsitefragmenthotta;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kokoroguruma.musicsitefragmenthotta.playMusic.MusicPlayService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * PlayFragument上部で表示される。
 * 音声の操作を行う。
 * A simple {@link Fragment} subclass.
 */
public class PlayPlayingViewFragment extends Fragment {
	private final static String TAG = PlayPlayingViewFragment.class.getSimpleName();

	MyApplication application;

	private Intent musicPlayServiceIntent;

	public PlayPlayingViewFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		application = (MyApplication) getActivity().getApplication();

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_play_playing_view, container, false);
	}

	@Override
	public void onResume() {

		this.onClickList();


		// 音声サービスの開始。
		application.startMusicPlyaService(application);
		musicPlayServiceIntent = new Intent(application, MusicPlayService.class);

		super.onResume();
	}




	// ここからClick処理
	private void onClickList() {
		this.onClickPlayingBackButton();
		this.onClickPlayingPlayButton();
		this.onClickPlayingStopButton();
		this.onClickPlayingPauseButton();
		this.onClickPlayingNextButton();
	}

	private void onClickPlayingBackButton() {
		Button button = getView().findViewById(R.id.playingBackButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClickBack(): ");

				ServiceConnection serviceConnection = new ServiceConnection() {
					@Override
					public void onServiceConnected(ComponentName name, IBinder service) {
						Log.d(TAG, "onClickPlayingBackButton(): on-Connected: ComponentName: " + name);
						Log.d(TAG, "onClickPlayingBackButton(): on-Connected: IBinder: " + service);
						Log.d(TAG, "onClickPlayingBackButton(): on-Connected: GetClass: " + service.getClass());

						MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
						musicPlayService.musicBack();
					}

					@Override
					public void onServiceDisconnected(ComponentName name) {
						Log.d(TAG, "onClickPlayingBackButton(): on-Disonnected: ComponentName: " + name);

					}
				};

				application.bindService(musicPlayServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);


			}
		});
	}

	private void onClickPlayingPlayButton() {
		Button button = getView().findViewById(R.id.playingPlayButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClickPlayingPlayButton(): ");

				ServiceConnection serviceConnection = new ServiceConnection() {
					@Override
					public void onServiceConnected(ComponentName name, IBinder service) {
						Log.d(TAG, "onClickPlayingPlayButton(): on-Connected: ComponentName: " + name);
						Log.d(TAG, "onClickPlayingPlayButton(): on-Connected: IBinder: " + service);
						Log.d(TAG, "onClickPlayingPlayButton(): on-Connected: GetClass: " + service.getClass());

						MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
						musicPlayService.musicStart();
					}

					@Override
					public void onServiceDisconnected(ComponentName name) {
						Log.d(TAG, "onClickPlayingPlayButton(): on-Disonnected: ComponentName: " + name);

					}
				};

				application.bindService(musicPlayServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);

			}
		});
	}

	private void onClickPlayingStopButton() {
		Button button = getView().findViewById(R.id.playingStopButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClickStop(): ");

				ServiceConnection serviceConnection = new ServiceConnection() {
					@Override
					public void onServiceConnected(ComponentName name, IBinder service) {
						Log.d(TAG, "onClickPlayingStopButton(): on-Connected: ComponentName: " + name);
						Log.d(TAG, "onClickPlayingStopButton(): on-Connected: IBinder: " + service);
						Log.d(TAG, "onClickPlayingStopButton(): on-Connected: GetClass: " + service.getClass());

						MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
						musicPlayService.musicStop();
					}

					@Override
					public void onServiceDisconnected(ComponentName name) {
						Log.d(TAG, "onClickPlayingStopButton(): on-Disonnected: ComponentName: " + name);

					}
				};

				application.bindService(musicPlayServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);

			}
		});
	}

	private void onClickPlayingPauseButton() {
		Button button = getView().findViewById(R.id.playingPauseButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClickPause(): ");

				ServiceConnection serviceConnection = new ServiceConnection() {
					@Override
					public void onServiceConnected(ComponentName name, IBinder service) {
						Log.d(TAG, "onClickPlayingPauseButton(): on-Connected: ComponentName: " + name);
						Log.d(TAG, "onClickPlayingPauseButton(): on-Connected: IBinder: " + service);
						Log.d(TAG, "onClickPlayingPauseButton(): on-Connected: GetClass: " + service.getClass());

						MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
						musicPlayService.musicPause();
					}

					@Override
					public void onServiceDisconnected(ComponentName name) {
						Log.d(TAG, "onClickPlayingPauseButton(): on-Disonnected: ComponentName: " + name);

					}
				};

				application.bindService(musicPlayServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);

			}
		});
	}

	private void onClickPlayingNextButton() {
		Button button = getView().findViewById(R.id.playingNextButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("PlayPlaingView-ment: ", "onClickNext(): ");

				ServiceConnection serviceConnection = new ServiceConnection() {
					@Override
					public void onServiceConnected(ComponentName name, IBinder service) {
						Log.d("PlayPlaingView-ment: ", "onClickPlayingNextButton(): on-Connected: ComponentName: " + name);
						Log.d("PlayPlaingView-ment: ", "onClickPlayingNextButton(): on-Connected: IBinder: " + service);
						Log.d("PlayPlaingView-ment: ", "onClickPlayingNextButton(): on-Connected: GetClass: " + service.getClass());

						MusicPlayService musicPlayService = ((MusicPlayService.MusicPlayServiceBinder) service).getService();
						musicPlayService.musicNext();
					}

					@Override
					public void onServiceDisconnected(ComponentName name) {
						Log.d("PlayPlaingView-ment: ", "onClickPlayingNextButton(): on-Disonnected: ComponentName: " + name);

					}
				};

				application.bindService(musicPlayServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);

			}
		});
	}


}
