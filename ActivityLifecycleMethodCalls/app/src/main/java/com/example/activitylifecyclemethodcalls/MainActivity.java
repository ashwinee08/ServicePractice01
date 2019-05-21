package com.example.activitylifecyclemethodcalls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.activitylifecyclemethodcalls.services.ServiceUsingServiceClass;

public class MainActivity extends AppCompatActivity {


    TextView serviceStartedTextView,serviceStoppedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getHold();
        Log.d("u r in :","inside CREATE_A method");
    }

    private void getHold(){
        serviceStartedTextView=(TextView)findViewById(R.id.service_started);
        serviceStoppedTextView=(TextView)findViewById(R.id.service_stopped);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("u r in :","inside START_A method");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("u r in :","inside RESUME_A method");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("u r in :","inside PAUSE_A method");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("u r in :","inside STOP_A method");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("u r in :","inside DESTROY_A method");
    }

    public void onClick(View view){
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void startServiceDesired(View view){
        serviceStartedTextView.setVisibility(View.VISIBLE);
        serviceStoppedTextView.setVisibility(View.GONE);
        startService(new Intent(this, ServiceUsingServiceClass.class));
    }

    public void stopServiceRequested(View view){
        serviceStartedTextView.setVisibility(View.GONE);
        serviceStoppedTextView.setVisibility(View.VISIBLE);
        stopService(new Intent(this,ServiceUsingServiceClass.class));
    }
}
