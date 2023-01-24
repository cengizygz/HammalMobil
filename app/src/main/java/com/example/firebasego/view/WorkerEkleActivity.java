package com.example.firebasego.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebasego.R;
import com.example.firebasego.databinding.ActivityWorkerEkleBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class WorkerEkleActivity extends AppCompatActivity {

    private FirebaseStorage firebaseStorage;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;
    Uri data;
    ActivityResultLauncher<Intent> activityResultLauncher;
    ActivityResultLauncher<String > permissionLauncher;
    private ActivityWorkerEkleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityWorkerEkleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

    }








    public  void isciilanbtn(View view){
        String sirketAdi =  binding.sirketadi.getText().toString();
        String calismasekli = binding.calismasekli.getText().toString();
        String nitelik = binding.nitelik.getText().toString();
        String adres = binding.adres.getText().toString();
        String aciklama = binding.aciklama.getText().toString();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        String email = user.getEmail();
        HashMap<String,Object> postData = new HashMap<>();
        postData.put("sirketAdi",sirketAdi);
        postData.put("calismasekli",calismasekli);
        postData.put("nitelik",nitelik);
        postData.put("adres",adres);
        postData.put("aciklama",aciklama);
        postData.put("date", FieldValue.serverTimestamp());

        firebaseFirestore.collection("Worker").add(postData).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Intent intent = new Intent(WorkerEkleActivity.this,HomeActivity2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(WorkerEkleActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }




























    public void workerback (View view){
        Intent Intent = new Intent(WorkerEkleActivity.this, HomeActivity2.class);
        startActivity(Intent);
        finish();
    }
}