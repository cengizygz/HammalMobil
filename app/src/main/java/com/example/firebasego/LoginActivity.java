package com.example.firebasego;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private EditText editEmail,editSifre;
    private String txtEmail,txtSifre;
    private FirebaseUser user ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        auth = FirebaseAuth.getInstance();
        editEmail=(EditText)findViewById(R.id.emailText);
        editSifre=(EditText)findViewById(R.id.sifreText);
        TextView KayitBtn = findViewById(R.id.KayitOlButton);
        KayitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SingupActivity.class));
            }
        });

         user = auth.getCurrentUser();
        if(user != null){
            Intent intent=new Intent(LoginActivity.this,HomeActivity2.class);
            startActivity(intent);
            finish();
        }

    }
        public void GirisTik(View view){
        txtEmail = editEmail.getText().toString();
        txtSifre = editSifre.getText().toString();

        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre)){
            auth.signInWithEmailAndPassword(txtEmail,txtSifre).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    user = auth.getCurrentUser();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity2.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }else
            Toast.makeText(this, "Email ve Şifre Boş Olamaz", Toast.LENGTH_SHORT).show();

        }

}