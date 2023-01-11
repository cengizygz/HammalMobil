package com.example.firebasego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
    }

    public void back_btn (View view){
        Intent Intent = new Intent(ProfileEditActivity.this, HomeActivity2.class);
        startActivity(Intent);
        finish();
    }
}