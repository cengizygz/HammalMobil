package com.example.firebasego.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebasego.Adaptor.PostAdapter;
import com.example.firebasego.R;
import com.example.firebasego.databinding.ActivityJobListBinding;
import com.example.firebasego.model.Post;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class JobListActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    ArrayList<Post> postArrayList;
    private ActivityJobListBinding binding;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJobListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        firebaseFirestore = FirebaseFirestore.getInstance();
        getData();
        postArrayList= new ArrayList<>();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter=new PostAdapter(postArrayList);
        binding.recyclerView.setAdapter(postAdapter);

    }
    private void getData() {
        firebaseFirestore.collection("Jobseeker").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
            if(error !=null){
                Toast.makeText(JobListActivity.this, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
            if(value != null){
                for(DocumentSnapshot snapshot : value.getDocuments()){

                    Map<String,Object> data = snapshot.getData();
                    String adres = (String) data.get("adres");
                    String deneyim = (String) data.get("deneyim");
                    String iletisim = (String) data.get("iletisim");
                    String imageUrl = (String) data.get("imageUrl");
                    String isim = (String) data.get("isim");
                    String meslek = (String) data.get("meslek");
                    String ogretim = (String) data.get("ogretim");
                    String tanit = (String) data.get("tanit");
                    String yas = (String) data.get("yas");
                    String calismasaat = (String) data.get("çalışma saat");

                    Post post = new Post(adres,deneyim,iletisim,imageUrl,isim,meslek,ogretim,tanit,yas,calismasaat);

                    postArrayList.add(post);
                }
                postAdapter.notifyDataSetChanged();
            }
            }
        });
    }

}