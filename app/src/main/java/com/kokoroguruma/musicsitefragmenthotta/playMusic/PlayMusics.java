package com.kokoroguruma.musicsitefragmenthotta.playMusic;

import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Kokoroguruma on 2018/03/26.
 */

public class PlayMusics {
	private final static String TAG = PlayMusics.class.getSimpleName();

	private MediaPlayer currentMediaPlayer;
	private List<MediaPlayerData> mediaPlayerDataList;


	public PlayMusics(int ins_musicId, String ins_musicName, String ins_musicUrl, String ins_musicComment) throws IOException {
		MediaPlayerData mediaPlayerData = new MediaPlayerData(ins_musicId, ins_musicName, ins_musicUrl, ins_musicComment);
		mediaPlayerDataList = new ArrayList<MediaPlayerData>();
		mediaPlayerDataList.add(mediaPlayerData);
		this.setCurrentMediaPlyaer(mediaPlayerDataList.get(0));
	}


	public PlayMusics(List<MediaPlayerData> ins_mediaPlayerDataList) throws Exception {
		if (ins_mediaPlayerDataList.isEmpty()) {
			throw new Exception("データなし");
		}
		mediaPlayerDataList = ins_mediaPlayerDataList;
		this.setCurrentMediaPlyaer(mediaPlayerDataList.get(0));
	}

	public void addPlayMusic(int ins_musicId, String ins_musicName, String ins_musicUrl, String ins_musicComment) throws IOException {
		MediaPlayerData mediaPlayerData = new MediaPlayerData(ins_musicId, ins_musicName, ins_musicUrl, ins_musicComment);
		mediaPlayerDataList = new ArrayList<MediaPlayerData>();
		mediaPlayerDataList.add(mediaPlayerData);
		this.setCurrentMediaPlyaer(mediaPlayerDataList.get(0));
	}


	public void start() {
		Log.d(TAG, "start(): ");
		this.currentMediaPlayer.start();
	}

	public void stop() {
		Log.d(TAG, "stop(): ");

		this.currentMediaPlayer.stop();
		try {
			this.currentMediaPlayer.prepare();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		this.currentMediaPlayer.pause();
		this.currentMediaPlayer.seekTo(0);
		*/

		/*
		if (this.currentMediaPlayer.isPlaying()) {
			Log.d("PlayMusics: ", "stop(): isPlaying(): ");
			this.currentMediaPlayer.stop();
			try {
				this.currentMediaPlayer.prepare();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
	}

	public void pause() {
		Log.d(TAG, "pause(): ");

		this.currentMediaPlayer.pause();

		/*
		if (this.currentMediaPlayer.isPlaying()) {
			Log.d("PlayMusics: ", "pause(): isPlaying(): ");
			this.currentMediaPlayer.pause();
		}
		*/
	}

	public void next() {
		Log.d(TAG, "next(): ");
		// TODO: 次の音声ファイルへ
	}

	public void back() {
		Log.d(TAG, "back(): ");
		// TODO: 前の音声ファイルへ
	}

	public void end() {
		Log.d(TAG, "end(): ");

		this.currentMediaPlayer.stop();
		this.currentMediaPlayer.release();
		this.currentMediaPlayer = null;
	}




	private void setCurrentMediaPlyaer(MediaPlayerData ins_MediaPlayerData) {
		this.currentMediaPlayer = ins_MediaPlayerData.getMediaPlayer();
	}


}
