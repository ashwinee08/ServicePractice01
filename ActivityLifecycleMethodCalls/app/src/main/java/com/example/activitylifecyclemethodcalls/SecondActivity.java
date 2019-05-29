package com.example.activitylifecyclemethodcalls;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.activitylifecyclemethodcalls.services.ServiceUsingServiceClass;

public class SecondActivity extends AppCompatActivity implements ServiceConnection {

    private EditText numberOneEditText, numberTwoEditText;
    private TextView resultTextView;
    private IService serviceInterface=null;
    boolean bound=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("u r in :","inside CREATE_B method");

        getHold();
    }

    private void getHold(){
        numberOneEditText =findViewById(R.id.number_one);
        numberTwoEditText =findViewById(R.id.number_two);
        resultTextView=findViewById(R.id.result);
    }

    public void addWhenClicked(View view){
        if((!numberOneEditText.getText().toString().isEmpty())&&(!numberTwoEditText.getText().toString().isEmpty()))
        if(bound){
            Long  result=serviceInterface.
                    add(
                            Long.parseLong(numberOneEditText.getText().toString()),
                            Long.parseLong(numberTwoEditText.getText().toString())
                    );
            resultTextView.setText(String.valueOf(result));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("u r in :","inside START_B method");
        Intent intent=new Intent(this, ServiceUsingServiceClass.class);
        bindService(intent,this,BIND_AUTO_CREATE);
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

        unbindService(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("u r in :","inside DESTROY_B method");
    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        bound=true;
        serviceInterface=((ServiceUsingServiceClass.InnerClassForBinder)service).getInstance();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        bound=false;
        serviceInterface=null;
    }
}
