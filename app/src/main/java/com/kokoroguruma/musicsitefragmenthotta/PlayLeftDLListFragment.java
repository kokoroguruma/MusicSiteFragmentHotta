package com.kokoroguruma.musicsitefragmenthotta;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.kokoroguruma.musicsitefragmenthotta.access.Access;
import com.kokoroguruma.musicsitefragmenthotta.listDlAddList.ListDlAddListAdapter;
import com.kokoroguruma.musicsitefragmenthotta.listDlAddList.ListDlAddListItem;
import com.kokoroguruma.musicsitefragmenthotta.listPlayCenterList.ListPlayCenterListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 左から出てくるフラグメント
 * Listに登録出来る音声リストが出てくる。
 * リストはカスタマイズで～
 * A simple {@link Fragment} subclass.
 */
public class PlayLeftDLListFragment extends Fragment {
	private final static String TAG = PlayLeftDLListFragment.class.getSimpleName();

	MyApplication application;

	public PlayLeftDLListFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {


		application = (MyApplication) getActivity().getApplication();

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_play_left_dllist, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onResume() {

		this.setComponent();

		super.onResume();
	}

	// ここから各コンポーネントの実装

	private void setComponent() {
		this.onClickPlayLeftSearchButton();
		this.setList();
	}

	// 検索ボタン
	private void onClickPlayLeftSearchButton() {
		Log.d(TAG, "onClickPlay-SearchButton: v(): " + getView());
		Button button = getView().findViewById(R.id.playLeftSearchButton);
		Log.d(TAG, "onClickPlay-SearchButton: button: " + getView().findViewById(R.id.playLeftSearchButton));
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateList();
			}
		});
	}

	// リストのデフォルト表示
	private void setList() {
		ListView listView = getView().findViewById(R.id.playLeftList);


		String addUrl = "searchMusic?s_pass=" + application.getSPass();
		Access access = new Access(addUrl);
		String jsonData = access.startAcsess();

		Map<String, Object> resultMap = access.jsonObjectParser(jsonData);
System.out.println(resultMap);


		// TODO: Listデータの引き出し。
		ArrayList<ListDlAddListItem> arrayList = new ArrayList<ListDlAddListItem>();
		for (int i = 0; i < 20; i++) {
			ListDlAddListItem listItem = new ListDlAddListItem(i, "name" + i, "url" + i, "comment" + i);
			arrayList.add(listItem);
		}

		ListDlAddListAdapter adapter = new ListDlAddListAdapter(this.getContext(), R.id.playLeftList, arrayList);
		listView.setAdapter(adapter);
	}


	private void updateList() {
		// TODO: 検索機能。Listをアップデート

		Log.d(TAG, "updateList()");
		ListView listView = getView().findViewById(R.id.playLeftList);

		ListDlAddListAdapter adapter = (ListDlAddListAdapter) listView.getAdapter();
		Log.d(TAG, "updateList(): adapter: " + adapter);

		ArrayList<ListDlAddListItem> arrayList = new ArrayList<ListDlAddListItem>();
		for (int i = 0; i < 30; i++) {
			ListDlAddListItem listItem = new ListDlAddListItem(i, "name2:" + i, "url" + i, "comment" + i);
			arrayList.add(listItem);
		}


		adapter.updateList(arrayList);
		adapter.notifyDataSetChanged();
	}


	private void tachPlayCenterPlayingListFragment() {

		List<ListPlayCenterListItem> list = application.getListPlayCenterListItemList();
		list.clear();
		for (int i=0; i<10; i++) {

			ListPlayCenterListItem item = new ListPlayCenterListItem(i, "name" + i, "url" + i);
			list.add(item);
		}




	}


}
