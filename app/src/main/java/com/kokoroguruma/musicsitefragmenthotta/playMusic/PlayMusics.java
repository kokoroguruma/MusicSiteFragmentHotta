package com.kokoroguruma.musicsitefragmenthotta.playMusic;

import android.media.MediaPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Kokoroguruma on 2018/03/26.
 */

public class PlayMusics {

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
		this.currentMediaPlayer.start();
	}

	public void stop() {
		this.currentMediaPlayer.stop();
	}






	private void setCurrentMediaPlyaer(MediaPlayerData ins_MediaPlayerData) {
		this.currentMediaPlayer = ins_MediaPlayerData.getMediaPlayer();
	}





}
