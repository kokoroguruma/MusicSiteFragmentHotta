package com.kokoroguruma.musicsitefragmenthotta;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;


/**
 * 音声の再生機能。
 */
public class MusicPlayService extends Service {
    public MusicPlayService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        Log.d("MusicPlayService: ", "onCreate(): ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MusicPlayService: ", "onStartCommand(): ");

        this.playMusic();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("MusicPlayService: ", "onDestroy(): ");
        super.onDestroy();
    }

    // 音声再生
    private void playMusic() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        String url = "https://soundeffect-lab.info/sound/environment/mp3/town1.mp3";



        try {

            mediaPlayer.setDataSource(url);
            Log.d("MusicPlayService: ", "plyaMusic: 1");
            mediaPlayer.start();
            Log.d("MusicPlayService: ", "plyaMusic: 2");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mediaPlayer.stop();
        this.onDestroy();
    }



}
