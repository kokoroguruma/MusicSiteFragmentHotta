package com.kokoroguruma.musicsitefragmenthotta;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kokoroguruma.musicsitefragmenthotta.listPlayCenterList.ListPlayCenterListAdapter;
import com.kokoroguruma.musicsitefragmenthotta.listPlayCenterList.ListPlayCenterListItem;

import java.util.ArrayList;
import java.util.List;


/**
 * 再生予定の音声をリスト表示。
 * リストはカスタマイズで～
 * A simple {@link Fragment} subclass.
 */
public class PlayCenterPlayingListFragment extends Fragment {
	private final static String TAG = PlayCenterPlayingListFragment.class.getSimpleName();

	MyApplication application;

	public PlayCenterPlayingListFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		Log.d(TAG, "onCreateView(): ");

		application = (MyApplication) getActivity().getApplication();

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_play_center_playing_list, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

		this.setList();

		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onResume() {
		Log.d(TAG, "onResume(): ");

		this.application.setPlayCenterPlayingListFragment(this);


		super.onResume();
	}

	private void setList() {
		ListView listView = getView().findViewById(R.id.playCenterList);

		List<ListPlayCenterListItem> listPlayCenterListItemList = application.getListPlayCenterListItemList();

		ListPlayCenterListAdapter listPlayCenterListAdapter = new ListPlayCenterListAdapter(this.getContext(), R.id.playCenterList, this.application.getListPlayCenterListItemList());
		listPlayCenterListAdapter.setApplication(this.application);
		listView.setAdapter(listPlayCenterListAdapter);
	}

	public void updateList() {

		ListView listView = getView().findViewById(R.id.playCenterList);
		ListPlayCenterListAdapter adapter = (ListPlayCenterListAdapter) listView.getAdapter();

		adapter.updataList(this.application.getListPlayCenterListItemList());

		adapter.notifyDataSetChanged();
	}


}
