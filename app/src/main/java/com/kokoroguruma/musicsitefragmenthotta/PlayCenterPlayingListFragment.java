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

	MyApplication application;

	ListPlayCenterListAdapter listPlayCenterListAdapter;

	public PlayCenterPlayingListFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		Log.d("PlayCenter: ", "onCreateView(): ");

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
		Log.d("PlayCenter: ", "onResume(): ");



		super.onResume();
	}

	private void setList() {
		ListView listView = getView().findViewById(R.id.playCenterList);

		List<ListPlayCenterListItem> listPlayCenterListItemList = application.getListPlayCenterListItemList();


		listPlayCenterListAdapter = new ListPlayCenterListAdapter(this.getContext(), R.id.playCenterList, listPlayCenterListItemList);
		listView.setAdapter(listPlayCenterListAdapter);
	}

	public void updateList() {
		listPlayCenterListAdapter.notifyDataSetChanged();

	}


}
