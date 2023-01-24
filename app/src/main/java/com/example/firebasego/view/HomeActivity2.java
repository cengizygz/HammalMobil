package com.example.firebasego.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebasego.Home2Fragment;
import com.example.firebasego.HomeFragment;
import com.example.firebasego.ProfileFragment;
import com.example.firebasego.R;
import com.example.firebasego.SettingFragment;
import com.example.firebasego.databinding.ActivityHome2Binding;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity2 extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    ActivityHome2Binding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //    setContentView(R.layout.activity_home2);
    auth = FirebaseAuth.getInstance();


        replaceFragment(new HomeFragment());


        binding=ActivityHome2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
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


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }


    public void islistbtn(View view){
        Intent intent = new Intent(HomeActivity2.this, JobList2Activity.class);
        startActivity(intent);
        finish();
    }
    public void iscilistbtn(View view){
        Intent intent = new Intent(HomeActivity2.this, JobList2Activity.class);
        startActivity(intent);
        finish();
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

    public void editBtn (View view){

        Intent intent = new Intent(HomeActivity2.this, ProfileEditActivity.class);
        startActivity(intent);
        finish();
    }
    public  void  languageBtn (View view){
        Intent intent = new Intent(HomeActivity2.this, LanguageActivity.class);
        startActivity(intent);
        finish();
    }
    public  void  editJobbtn (View view){
        Intent intent = new Intent(HomeActivity2.this, IsEkleActivity.class);
        startActivity(intent);
        finish();
    }
    public  void  editworkerbtn (View view){
        Intent intent = new Intent(HomeActivity2.this, WorkerEkleActivity.class);
        startActivity(intent);
        finish();
    }
}