package com.kokoroguruma.musicsitefragmenthotta.listPlayCenterList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.kokoroguruma.musicsitefragmenthotta.MyApplication;
import com.kokoroguruma.musicsitefragmenthotta.R;

import java.util.ArrayList;
import java.util.List;

/**
 * カスタムListViewのAdapter
 * Created by Kokoroguruma on 2018/03/22.
 */

public class ListPlayCenterListAdapter extends BaseAdapter {
	private final static String TAG = ListPlayCenterListAdapter.class.getSimpleName();

	Context context;
	int resource;
	LayoutInflater layoutInflater;
	List<ListPlayCenterListItem> listPlayCenterListItemList;

	MyApplication application;

	public ListPlayCenterListAdapter(Context context, int resource, List<ListPlayCenterListItem> listPlayCenterListItemList) {
		this.context = context;
		this.resource = resource;
		this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.listPlayCenterListItemList = listPlayCenterListItemList;
	}

	public void setApplication(MyApplication application) {
		this.application = application;
	}

	public void updataList(List<ListPlayCenterListItem> listPlayCenterListItemList) {
		this.listPlayCenterListItemList = listPlayCenterListItemList;
	}


	@Override
	public int getCount() {
		return this.listPlayCenterListItemList.size();
	}

	@Override
	public Object getItem(int position) {
		return this.listPlayCenterListItemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.list_playing_list, parent, false);
		}

		TextView listPlayingTitleView = convertView.findViewById(R.id.listPlayingTitle);
		listPlayingTitleView.setText(this.listPlayCenterListItemList.get(position).getMusicName());

		TextView listPlayingCommentView = convertView.findViewById(R.id.listPlayingComment);
		listPlayingCommentView.setText(this.listPlayCenterListItemList.get(position).getMusicComment());


		Button deleteButton = convertView.findViewById(R.id.listPlayingDeleteButton);
		deleteButton.setTag(position);
		deleteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "listPlayingDeleteButton押された。deleteButton: " + v.getTag());

				application.deleteListPlayCenterItem(position);

			}
		});

		Button playButton = convertView.findViewById(R.id.listPlayingPlayButton);
		playButton.setTag(position);
		playButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "listPlayingPlayButton押された。playButton: " + v.getTag());

				application.playingListPlayCenterItem(position);
			}
		});


		return convertView;
	}


}
