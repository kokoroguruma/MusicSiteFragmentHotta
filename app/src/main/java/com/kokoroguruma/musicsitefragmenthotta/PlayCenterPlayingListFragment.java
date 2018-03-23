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


/**
 * 再生予定の音声をリスト表示。
 * リストはカスタマイズで～
 * A simple {@link Fragment} subclass.
 */
public class PlayCenterPlayingListFragment extends Fragment {


    public PlayCenterPlayingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("PlayCenter: ", "onCreateView: ");


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_center_playing_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        this.setList();


        super.onViewCreated(view, savedInstanceState);
    }

    private void setList() {
        ListView listView = getView().findViewById(R.id.playCenterList);

        ArrayList<ListPlayCenterListItem> arrayList = new ArrayList<ListPlayCenterListItem>();

        // TODO: Listのデータ引き出し、構築
        for (int i=0; i<10; i++) {
            ListPlayCenterListItem listItem = new ListPlayCenterListItem(i, "aaa" + i, "url" + i, "com" + i);
            arrayList.add(listItem);
        }

        ListPlayCenterListAdapter adapter = new ListPlayCenterListAdapter(this.getContext(), R.id.playCenterList, arrayList);
        listView.setAdapter(adapter);



    }



}
