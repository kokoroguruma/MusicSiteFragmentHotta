package com.kokoroguruma.musicsitefragmenthotta;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


/**
 * 音声の再生機能。
 */
public class MusicPlayService extends Service {
    public MusicPlayService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
