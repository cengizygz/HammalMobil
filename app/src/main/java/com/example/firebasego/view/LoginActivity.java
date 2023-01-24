package com.example.firebasego.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.firebasego.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private EditText editEmail,editSifre;
    private String txtEmail,txtSifre;
    private FirebaseUser user ;
    TextView kayitBtn;
    TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        auth = FirebaseAuth.getInstance();
        editEmail=(EditText)findViewById(R.id.emailText);
        editSifre=(EditText)findViewById(R.id.sifreText);
        forgotPassword= findViewById(R.id.forgot_password);
        kayitBtn = findViewById(R.id.KayitOlButton);

        // Kayıt ol sekmesi
        kayitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SingupActivity.class));
            }
        });
        // Şifremi unuttum sekmesi
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot,null);
                EditText emailBox = dialogView.findViewById(R.id.emailBox);

                builder.setView(dialogView);
                AlertDialog dialog = builder.create();

                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String userEmail = emailBox.getText().toString();

                        if (TextUtils.isEmpty(userEmail)&& !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                            Toast.makeText(LoginActivity.this,"E mail adresinizi giriniz",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this,"Email adresinizi kontrol ediniz",Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                } else {
                                    Toast.makeText(LoginActivity.this, "gönderilemedi,Hata", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        dialogView.findViewById(R.id.btcCancel).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        if (dialog.getWindow() !=null){
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        dialog.show();
                    }
                });*/
            }
        });








        // Kullanıcı kayıtlı ise
        user = auth.getCurrentUser();
        if(user != null){
            Intent intent=new Intent(LoginActivity.this,HomeActivity2.class);
            startActivity(intent);
            finish();
            ///////
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