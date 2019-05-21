package com.example.activitylifecyclemethodcalls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("u r in :","inside CREATE_B method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("u r in :","inside START_B method");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("u r in :","inside RESUME_B method");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("u r in :","inside PAUSE_B method");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("u r in :","inside STOP_B method");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("u r in :","inside DESTROY_B method");
    }
}
