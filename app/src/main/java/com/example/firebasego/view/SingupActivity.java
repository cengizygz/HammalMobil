package com.example.firebasego.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebasego.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SingupActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText editEmail,editSifre,editIsim,editDate;
    private String txtEmail,txtSifre,txtIsim,txtDate;
    private HashMap<String,Object> mData;
    private FirebaseFirestore firestore;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        editIsim=(EditText)findViewById(R.id.editTextTextPersonName2);
        editEmail=(EditText)findViewById(R.id.editTextTextPersonName3);
        editSifre=(EditText)findViewById(R.id.editTextTextPassword);
        editDate=(EditText)findViewById(R.id.editTextDate);
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

    }
    public void KayitTik (View view){

        txtIsim = editIsim.getText().toString();
        txtEmail = editEmail.getText().toString();
        txtSifre = editSifre.getText().toString();
        txtDate = editDate.getText().toString();

        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre) && !TextUtils.isEmpty(txtIsim) && !TextUtils.isEmpty(txtDate)){
            auth.createUserWithEmailAndPassword(txtEmail,txtSifre)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                user = auth.getCurrentUser();

                                mData = new HashMap<>();
                                mData.put("kullanıcı adı",txtIsim);
                                mData.put("kullanıcı Email",txtEmail);
                                mData.put("kullanıcı Şifre",txtSifre);
                                mData.put("kullanıcı Date",txtDate);
                                mData.put("kullanıcıId",user.getUid());

                                firestore.collection("Kullanıcılar").document(user.getUid())
                                        .set(mData)
                                        .addOnCompleteListener(SingupActivity.this, new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(SingupActivity.this,"Kayıt Başarılı",Toast.LENGTH_SHORT).show();
                                            }else
                                                Toast.makeText(SingupActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                            else
                                Toast.makeText(SingupActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
        }else
            Toast.makeText(this, "Lütfen Tüm Alanları Doldurunuz", Toast.LENGTH_SHORT).show();



    /*    String isim = binding.editTextTextPersonName2.getText().toString();
        String email = binding.editTextTextPersonName3.getText().toString();
        String sifre = binding.editTextTextPassword.getText().toString();
        String date = binding.editTextDate.getText().toString();

        if(email.equals("")|| isim.equals("")|| sifre.equals("")||date.equals("")){
            Toast.makeText(this, "Lütfen Tüm Alanları Doldurunuz", Toast.LENGTH_LONG).show();
        } else{
            auth.createUserWithEmailAndPassword(email,sifre).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(SingupActivity.this,MainActivity.class);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SingupActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }*/
    }
}