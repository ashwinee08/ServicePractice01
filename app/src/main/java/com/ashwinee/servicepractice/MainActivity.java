package com.ashwinee.servicepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ashwinee.servicepractice.services.ServiceImplementer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startServiceThread(View view){
        Intent intent=new Intent(this, ServiceImplementer.class);
        startService(intent);
        finish();
    }
}
