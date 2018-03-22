package com.kokoroguruma.musicsitefragmenthotta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 左から出てくるフラグメント
 * Listに登録出来る音声リストが出てくる。
 * リストはカスタマイズで～
 * A simple {@link Fragment} subclass.
 */
public class PlayLeftDLListFragment extends Fragment {


    public PlayLeftDLListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_left_dllist, container, false);
    }

}
