package com.kokoroguruma.musicsitefragmenthotta.listPlayCenterList;

import android.widget.Button;

/**
 * Created by Kokoroguruma on 2018/03/22.
 */

public class ListPlayCenterListItem {
	private final static String TAG = ListPlayCenterListItem.class.getSimpleName();


	private int musicId;

	private String musicName;

	private String musicUrl;

	private String musicComment;

	private Button listPlayingDeleteButton;

	private Button listPlayingPlayButton;

	public ListPlayCenterListItem(int ins_musicId, String ins_musicName, String ins_musicUrl) {
		this(ins_musicId, ins_musicName, ins_musicUrl, "");
	}

	public ListPlayCenterListItem(int ins_musicId, String ins_musicName, String ins_musicUrl, String ins_musicComment) {
		this.musicId = ins_musicId;
		this.musicName = ins_musicName;
		this.musicUrl = ins_musicUrl;
		this.musicComment = ins_musicComment;
	}

	public int getMusicId() {
		return musicId;
	}

	public String getMusicName() {
		return musicName;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public String getMusicComment() {
		return musicComment;
	}


}
