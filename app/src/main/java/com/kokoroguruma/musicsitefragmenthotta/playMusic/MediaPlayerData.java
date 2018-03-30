package com.kokoroguruma.musicsitefragmenthotta.playMusic;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Kokoroguruma on 2018/03/26.
 */

public class MediaPlayerData {
	private final static String TAG = MediaPlayerData.class.getSimpleName();

	private MediaPlayer mediaPlayer;
	private int musicId;
	private String musicName;
	private String musicUrl;
	private String musicComment;

	public MediaPlayerData(int ins_musicId, String ins_musicName, String ins_musicUrl, String ins_musicComment) throws IOException {
		this.musicId = ins_musicId;
		this.musicName = ins_musicName;
		this.musicUrl = ins_musicUrl;
		this.musicComment = ins_musicComment;

		this.mediaPlayer = new MediaPlayer();
		this.mediaPlayer.setDataSource(this.musicUrl);
		this.mediaPlayer.prepare();
	}

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getMusicComment() {
		return musicComment;
	}

	public void setMusicComment(String musicComment) {
		this.musicComment = musicComment;
	}
}
