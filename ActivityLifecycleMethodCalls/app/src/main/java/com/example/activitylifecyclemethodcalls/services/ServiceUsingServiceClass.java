package com.example.activitylifecyclemethodcalls.services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;

import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class ServiceUsingServiceClass extends Service {


    private MediaPlayer mediaPlayer;
    private final  String url="https://www.watertower-music.com/songclips/WTM39470/23_lostbutwon_30secclip.mp3";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    {
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
