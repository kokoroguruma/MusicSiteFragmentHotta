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

	private int currentPosition = -1;
	private MediaPlayer currentMediaPlayer;
	private List<MediaPlayerData> mediaPlayerDataList;

	/**
	 * コンストラクタ
	 * 中身無しで各部位を準備する。
	 */
	public PlayMusics() {
		this.mediaPlayerDataList = new ArrayList<MediaPlayerData>();
		this.currentPosition = -1;
		this.currentMediaPlayer = null;
	}

/*
	public PlayMusics(int ins_musicId, String ins_musicName, String ins_musicUrl, String ins_musicComment) throws IOException {
		MediaPlayerData mediaPlayerData = new MediaPlayerData(ins_musicId, ins_musicName, ins_musicUrl, ins_musicComment);
		mediaPlayerDataList = new ArrayList<MediaPlayerData>();
		mediaPlayerDataList.add(mediaPlayerData);
		this.setCurrentMediaPlyaer(mediaPlayerDataList.get(0));
		this.setCurrentMediaPlayer(0);
	}
*/

/*
	public PlayMusics(List<MediaPlayerData> ins_mediaPlayerDataList) throws Exception {
		if (ins_mediaPlayerDataList.isEmpty()) {
			throw new Exception("データなし");
		}
		mediaPlayerDataList = ins_mediaPlayerDataList;
//		this.setCurrentMediaPlyaer(mediaPlayerDataList.get(0));
		this.setCurrentMediaPlayer(0);
	}
*/


	// ここから追加削除

	public void addPlayMusic(int ins_musicId, String ins_musicName, String ins_musicUrl, String ins_musicComment) throws IOException {
		MediaPlayerData mediaPlayerData = new MediaPlayerData(ins_musicId, ins_musicName, ins_musicUrl, ins_musicComment);
		this.mediaPlayerDataList.add(mediaPlayerData);
//		this.setCurrentMediaPlyaer(mediaPlayerDataList.get(0));
		if (this.currentPosition < 0) {
			this.currentPosition = 0;
			this.setCurrentMediaPlayer(0);
		}
	}

	public void removePlayMusic(int position) {
		if (this.mediaPlayerDataList.size() < position) {
			return;
		}

		this.mediaPlayerDataList.remove(position);
		if (this.currentPosition >= position) {
			this.currentPosition = this.currentPosition -1;
			this.setCurrentMediaPlayer(this.currentPosition);
		}
	}

	// ここから音声選択

	public void setCurrentMediaPlayer(int position) {
		if (position < this.mediaPlayerDataList.size()) {
			this.currentPosition = position;
			this.currentMediaPlayer = this.mediaPlayerDataList.get(position).getMediaPlayer();
		}
	}



	// ここから再生～ストップ・・・移動等

	public void start() {
		Log.d(TAG, "start(): ");
		if (this.currentMediaPlayer == null) {
			if (this.currentPosition == -1) {
				return;
			} else {
				this.setCurrentMediaPlayer(0);
			}
		}
		this.currentMediaPlayer.start();



	}

	public void stop() {
		Log.d(TAG, "stop(): ");
		if (this.currentMediaPlayer == null) {
			return;
		}

		this.currentMediaPlayer.stop();
		try {
			this.currentMediaPlayer.prepare();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pause() {
		Log.d(TAG, "pause(): ");
		if (this.currentMediaPlayer == null) {
			return;
		}

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
		if (this.currentMediaPlayer == null) {
			return;
		}
		if (this.currentPosition == this.mediaPlayerDataList.size()-1) {
			this.setCurrentMediaPlayer(0);
		} else {
			this.setCurrentMediaPlayer(this.currentPosition + 1);
		}


		this.start();
	}

	public void back() {
		Log.d(TAG, "back(): ");
		if (this.currentMediaPlayer == null) {
			return;
		}

		if (this.currentPosition == 0) {
			this.setCurrentMediaPlayer(this.mediaPlayerDataList.size() - 1);
		}

		this.start();
	}

	public void end() {
		Log.d(TAG, "end(): ");
		if (this.currentMediaPlayer == null) {
			return;
		}

		this.currentMediaPlayer.stop();
		this.currentMediaPlayer.release();
		this.currentMediaPlayer = null;
	}



	/**
	 * 再生のプレイヤーを選択。
	 * @param ins_MediaPlayerData
	 */
//	private void setCurrentMediaPlyaer(MediaPlayerData ins_MediaPlayerData) {
//		this.currentMediaPlayer = ins_MediaPlayerData.getMediaPlayer();
//	}


}
