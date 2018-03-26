package com.kokoroguruma.musicsitefragmenthotta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * 再生中の音声の追加コメントリストが表示される。
 * また、自分から追加も出来る。
 * A simple {@link Fragment} subclass.
 */
public class PlayRightCommentListFragment extends Fragment {


	public PlayRightCommentListFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_play_right_comment_list, container, false);
	}

	@Override
	public void onResume() {

		this.setComponent();

		super.onResume();
	}


	// ここからコンポーネント実装

	private void setComponent() {
		this.setClickPlayRightCommentAddButton();
		this.setList();
	}

	private void setClickPlayRightCommentAddButton() {
		Button button = getView().findViewById(R.id.playRightCommentAddButton);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("PlayRightCom-Fragment: ", "setClickPlay-AddButton: " + v);
				// TODO: コメント追加
				updateList();
			}
		});
	}

	private void setList() {
		ListView listView = getView().findViewById(R.id.playRightList);


		// TODO: Listデータ引き出し
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			String string = "Comment: " + i;
			arrayList.add(string);
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(adapter);

	}

	private void updateList() {
		// TODO: List更新

		ListView listView = getView().findViewById(R.id.playRightList);
		ArrayAdapter<String> adapter = (ArrayAdapter<String>) listView.getAdapter();

		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			String string = "Comment2: " + i;
			arrayList.add(string);
		}

		adapter.clear();
		adapter.addAll(arrayList);
		adapter.notifyDataSetChanged();
	}


}
