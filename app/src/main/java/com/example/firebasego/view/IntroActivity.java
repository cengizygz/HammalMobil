package com.example.firebasego.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.firebasego.R;

public class IntroActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
     /*   Button GirisBtn2 = findViewById(R.id.buttongiris);
        GirisBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this,LoginActivity.class));
            }
        });
        Button KayitBtn2 = findViewById(R.id.buttonkayit);
        KayitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this,SingupActivity.class));
            }
        });
*/



    }
    public void GirisTik(View view){
        Intent intent = new Intent(IntroActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void KayitTik(View view){
        Intent intent = new Intent(IntroActivity.this,SingupActivity.class);
        startActivity(intent);
        finish();
    }
}