package com.example.activitylifecyclemethodcalls.services;

import android.app.IntentService;
import android.content.Intent;

public class ServiceUsingIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     *
     */

    public ServiceUsingIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(final Intent intent) {

    }
}
