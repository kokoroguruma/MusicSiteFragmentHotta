package com.kokoroguruma.musicsitefragmenthotta.listDlAddList;

import android.widget.Button;

/**
 * Created by Kokoroguruma on 2018/03/23.
 */

public class ListDlAddListItem {
	private final static String TAG = ListDlAddListItem.class.getSimpleName();


	private int musicId;

	private String musicName;

	private String musicUrl;

	private String musicComment;

	private Button listDlAddButton;


	public ListDlAddListItem(int ins_musicId, String ins_musicName, String ins_musicUrl) {
		this(ins_musicId, ins_musicName, ins_musicUrl, "");
	}

	public ListDlAddListItem(int ins_musicId, String ins_musicName, String ins_musicUrl, String ins_musicComment) {
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
