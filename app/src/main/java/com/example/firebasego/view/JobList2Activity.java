package com.example.firebasego.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebasego.JobList.Adapter;
import com.example.firebasego.R;
import com.example.firebasego.databinding.ActivityJobList2Binding;
import com.example.firebasego.model.PostJob;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class JobList2Activity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    ArrayList<PostJob> postJobArrayList;
    private ActivityJobList2Binding binding;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJobList2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        firebaseFirestore= FirebaseFirestore.getInstance();
        getData();
        postJobArrayList = new ArrayList<>();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Adapter(postJobArrayList);
        binding.recyclerView.setAdapter(adapter);

    }
    //.orderBy("date", Query.Direction.DESCENDING)
    private void getData(){
        firebaseFirestore.collection("Jobseeker").orderBy("adres", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error !=null){
                    Toast.makeText(JobList2Activity.this, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
                if(value != null){
                    for(DocumentSnapshot snapshot : value.getDocuments()){

                        Map<String,Object> data = snapshot.getData();
                        String adres = (String) data.get("adres");
                        String imageUrl = (String) data.get("imageUrl");
                        String isim = (String) data.get("isim");
                        String meslek = (String) data.get("meslek");


                        PostJob postjob = new PostJob(adres,imageUrl,isim,meslek);

                        postJobArrayList.add(postjob);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
    public void jobback (View view){

        Intent intent = new Intent(JobList2Activity.this, HomeActivity2.class);
        startActivity(intent);
        finish();
    }
}