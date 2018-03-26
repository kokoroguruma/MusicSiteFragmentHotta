package com.kokoroguruma.musicsitefragmenthotta;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
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

	MyApplication application;

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
				Log.d("PlayPlaingView-ment: ", "onClickBack(): ");
				// TODO: Backボタン処理
			}
		});
	}
	MediaPlayer mediaPlayer;
	private void onClickPlayingPlayButton() {
		Button button = getView().findViewById(R.id.playingPlayButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("PlayPlaingView-ment: ", "onClickPlay(): ");
				// TODO: Playボタン処理


//				application.startMusicPlyaService(application.getMainActivity());
				application.startMusicPlyaService(application.getBaseContext());

//				Intent intent = new Intent(getActivity(), MusicPlayService.class);
//				getActivity().startService(intent);

			}
		});
	}

	private void onClickPlayingStopButton() {
		Button button = getView().findViewById(R.id.playingStopButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("PlayPlaingView-ment: ", "onClickStop(): ");
				// TODO: Stopボタン処理



				Intent intent = new Intent(getActivity(), MusicPlayService.class);
				getActivity().stopService(intent);

			}
		});
	}

	private void onClickPlayingPauseButton() {
		Button button = getView().findViewById(R.id.playingPauseButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("PlayPlaingView-ment: ", "onClickPause(): ");
				// TODO: Pauseボタン処理
			}
		});
	}

	private void onClickPlayingNextButton() {
		Button button = getView().findViewById(R.id.playingNextButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("PlayPlaingView-ment: ", "onClickNext(): ");
				// TODO: Nextボタン処理
			}
		});
	}


}
