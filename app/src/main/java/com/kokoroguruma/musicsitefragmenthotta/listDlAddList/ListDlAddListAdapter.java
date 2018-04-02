package com.kokoroguruma.musicsitefragmenthotta.listDlAddList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.kokoroguruma.musicsitefragmenthotta.MyApplication;
import com.kokoroguruma.musicsitefragmenthotta.R;

import java.util.ArrayList;
import java.util.List;

/**
 * カスタムListViewのAdapter
 * Created by Kokoroguruma on 2018/03/23.
 */

public class ListDlAddListAdapter extends BaseAdapter {
	private final static String TAG = ListDlAddListAdapter.class.getSimpleName();

	Context context;
	int resource;
	LayoutInflater layoutInflater;
	List<ListDlAddListItem> listDlAddListItemArrayList;

	MyApplication application;

	public ListDlAddListAdapter(Context context, int resource, List<ListDlAddListItem> listDlAddListItemArrayList) {
		this.context = context;
		this.resource = resource;
		this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.listDlAddListItemArrayList = listDlAddListItemArrayList;
	}

	public void setApplication(MyApplication application) {
		this.application = application;
	}

	public void updateList(List<ListDlAddListItem> listDlAddListItemArrayList) {
		this.listDlAddListItemArrayList = listDlAddListItemArrayList;
	}


	@Override
	public int getCount() {
		return this.listDlAddListItemArrayList.size();
	}

	@Override
	public Object getItem(int position) {
		return this.listDlAddListItemArrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, final ViewGroup parent) {
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.list_dl_list, parent, false);
		}

		TextView listDlAddTitleView = convertView.findViewById(R.id.listDlAddTitle);
		listDlAddTitleView.setText(this.listDlAddListItemArrayList.get(position).getMusicName());

		TextView listDlAddCommentView = convertView.findViewById(R.id.listDlAddComment);
		listDlAddCommentView.setText(this.listDlAddListItemArrayList.get(position).getMusicComment());

		Button dlAddButton = convertView.findViewById(R.id.listDlAddButton);
		dlAddButton.setTag(position);
		dlAddButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "listDlAddButton押された。" + v.getTag());
				// 音声ファイルの再生リストへ追加

				ListView listView = (ListView) parent;
				application.addListPlayCenterListItemByListDlAddListAdapter(position);


			}
		});

		return convertView;
	}
}
