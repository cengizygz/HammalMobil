package com.example.firebasego.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.firebasego.R;

public class MainActivitySplash extends AppCompatActivity {
    Handler h =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivitySplash.this,JobList2Activity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}