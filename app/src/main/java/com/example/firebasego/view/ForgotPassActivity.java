package com.example.firebasego.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebasego.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassActivity extends AppCompatActivity {
    private String emailtext;
    private Button resetButon;
    private EditText editEmail;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        editEmail=(EditText)findViewById(R.id.emailBox);
        resetButon= (Button)findViewById(R.id.btnReset);
        auth = FirebaseAuth.getInstance();

    }
    public void resetbtn(View view) {

        emailtext = editEmail.getText().toString();
        auth.sendPasswordResetEmail(emailtext).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(ForgotPassActivity.this,"Email adresinizi kontrol ediniz",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ForgotPassActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ForgotPassActivity.this, "gönderilemedi,Hata", Toast.LENGTH_SHORT).show();
            }
        });


    }







    public void cancelbtn(View view){
        Intent intent = new Intent(ForgotPassActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}