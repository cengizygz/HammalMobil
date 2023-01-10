package com.example.firebasego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebasego.Language.Versions;
import com.example.firebasego.Language.VersionsAdapter;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Versions> versionsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    
    recyclerView=findViewById(R.id.recyclerView);
    
    initData();
    setRecylerView();
    
    }

    private void setRecylerView() {
        VersionsAdapter versionsAdapter = new VersionsAdapter(versionsList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        versionsList=new ArrayList<>();
        versionsList.add(new Versions("Hammal","içerik"));
        versionsList.add(new Versions("Hammal2","içerik"));
        versionsList.add(new Versions("Hammal3","içerik"));
        versionsList.add(new Versions("Hammal4","içerik"));
        versionsList.add(new Versions("Hammal5","içerik"));
    }
    public void back_btn (View view){
        Intent Intent = new Intent(AboutActivity.this, HomeActivity2.class);
        startActivity(Intent);
        finish();
    }
}