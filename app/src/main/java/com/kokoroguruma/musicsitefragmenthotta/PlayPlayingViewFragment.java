package com.kokoroguruma.musicsitefragmenthotta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * PlayFragument上部で表示される。
 * 音声の操作を行う。
 * A simple {@link Fragment} subclass.
 */
public class PlayPlayingViewFragment extends Fragment {


    public PlayPlayingViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_playing_view, container, false);
    }



    // ここからClick処理
    private void onClickList() {

    }

    private void onClickPlayingBackButton() {
        Button button = getActivity().findViewById(R.id.playingBackButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Backボタン処理
            }
        });
    }

    private void onClickPlayingPlayButton() {
        Button button = getActivity().findViewById(R.id.playingPlayButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Playボタン処理
            }
        });
    }

    private void onClickPlayingStopButton() {
        Button button = getActivity().findViewById(R.id.playingStopButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Stopボタン処理
            }
        });
    }

    private void onClickPlayingPauseButton() {
        Button button = getActivity().findViewById(R.id.playingPauseButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Pauseボタン処理
            }
        });
    }

    private void onClickPlayingNextButton() {
        Button button = getActivity().findViewById(R.id.playingNextButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Nextボタン処理
            }
        });
    }






}
