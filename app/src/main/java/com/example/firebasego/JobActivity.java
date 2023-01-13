package com.example.firebasego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firebasego.AddJob.Adapter;
import com.example.firebasego.AddJob.ItemDataModel;

import java.util.ArrayList;

public class JobActivity extends AppCompatActivity {

    private static ArrayList<ItemDataModel> data;
    ItemDataModel itemDatamodel;
    // list of Expensesname
    String[] Expensesname = {"Rent","Coffee","Lunch","Dinner","Transport","Other"};
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_expenses);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<>();

        // generate ArrayList and store in data model
        for(int i =0;i<Expensesname.length;i++){
            itemDatamodel = new ItemDataModel(
                    i,
                    Expensesname[i]
            );
            data.add(itemDatamodel);
        }
        // call Adapter class by passing ArrayList data
        adapter = new Adapter(data);
        // set adapter to recyclerview
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}