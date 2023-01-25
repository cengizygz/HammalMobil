package com.example.firebasego.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebasego.JobList.Adapter;
import com.example.firebasego.JobList.WorkAdapter;
import com.example.firebasego.R;
import com.example.firebasego.databinding.ActivityWorkerListBinding;
import com.example.firebasego.model.PostWorker;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class WorkerListActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    ArrayList<PostWorker> postWorkerArrayList;
    private ActivityWorkerListBinding binding;
    WorkAdapter workAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWorkerListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        firebaseFirestore= FirebaseFirestore.getInstance();
        getData();
        postWorkerArrayList = new ArrayList<>();

        binding.recyclerViewWorker.setLayoutManager(new LinearLayoutManager(this));
        workAdapter = new WorkAdapter(postWorkerArrayList);
        binding.recyclerViewWorker.setAdapter(workAdapter);
    }


    private void  getData(){
        firebaseFirestore.collection("Worker").orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error !=null){
                    Toast.makeText(WorkerListActivity.this, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
                if (value != null) {
                    for (DocumentSnapshot snapshot : value.getDocuments()){

                        Map<String,Object> data = snapshot.getData();
                        String sirketAdi = (String) data.get("sirketAdi");
                        String calismasekli = (String) data.get("calismasekli");
                        String nitelik =(String) data.get("nitelik");
                        String adres = (String) data.get("adres");
                        String aciklama = (String) data.get("aciklama");

                        PostWorker postWorker = new PostWorker(sirketAdi,calismasekli,nitelik,adres,aciklama);
                        postWorkerArrayList.add(postWorker);
                    }
                    workAdapter.notifyDataSetChanged();
                }
            }
        });
    }







    public void workerback (View view){

        Intent intent = new Intent(WorkerListActivity.this, HomeActivity2.class);
        startActivity(intent);
        finish();
    }
}