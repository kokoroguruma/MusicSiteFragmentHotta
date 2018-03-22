package com.kokoroguruma.musicsitefragmenthotta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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

}
