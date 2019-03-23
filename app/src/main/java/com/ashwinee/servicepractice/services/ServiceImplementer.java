package com.ashwinee.servicepractice.services;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by Ashwinee on 23-Mar-19.
 */

public class ServiceImplementer extends Service {


    private final String ACTION="com.ashwinee.servicepractice.recievers";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent1=new Intent();
                intent1.setAction(ACTION);
                sendBroadcast(intent1);
            }
        }).start();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
