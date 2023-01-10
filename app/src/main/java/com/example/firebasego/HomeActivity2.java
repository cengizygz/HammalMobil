package com.example.firebasego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebasego.Adaptor.CategoryAdaptor;
import com.example.firebasego.Adaptor.PopularAdaptor;
import com.example.firebasego.Domain.CategoryDomain;
import com.example.firebasego.Domain.JobDomain;
import com.example.firebasego.databinding.ActivityHome2Binding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity2 extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    ActivityHome2Binding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
    auth = FirebaseAuth.getInstance();
        recyclerViewCategory();
        recyclerViewPopular();

        replaceFragment(new HomeFragment());


        binding=ActivityHome2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.Introitm:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profileitm:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.homeitm:
                    replaceFragment(new Home2Fragment());
                    break;
                case R.id.settingitm:
                    replaceFragment(new SettingFragment());
                    break;

            }

            return true;
        });

    }
    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    private  void  recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);


        ArrayList<JobDomain> jobList =new ArrayList<>();
        jobList.add(new JobDomain("Muhasebe Elemanı","pizza","başka ne var",9.50));
        jobList.add(new JobDomain("Mühendis","pizza","burda ne yazıyor",8.79));
        jobList.add(new JobDomain("Kurye","pizza","burda ne yazıyor",8.78));

        adapter2= new PopularAdaptor(jobList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }



    public void singoutBtn (View view){

        auth.signOut();

        Intent intent = new Intent(HomeActivity2.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void aboutBtn (View view){

        Intent intent = new Intent(HomeActivity2.this, AboutActivity.class);
        startActivity(intent);
        finish();
    }
    public  void  languageBtn (View view){
        Intent intent = new Intent(HomeActivity2.this, LanguageActivity.class);
        startActivity(intent);
        finish();
    }
}