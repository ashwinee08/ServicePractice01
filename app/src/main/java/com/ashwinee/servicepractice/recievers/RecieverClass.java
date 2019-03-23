package com.ashwinee.servicepractice.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import com.ashwinee.servicepractice.SecondActivity;

/**
 * Created by Ashwinee on 23-Mar-19.
 */

public class RecieverClass extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentNew=new Intent(context, SecondActivity.class);
        context.startActivity(intentNew);
    }
}
