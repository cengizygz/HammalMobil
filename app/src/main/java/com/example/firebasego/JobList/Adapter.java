package com.example.firebasego.JobList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasego.databinding.DesignJoblistBinding;
import com.example.firebasego.model.PostJob;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.PostHolder> {
    private ArrayList<PostJob> postJobArrayList;

    public Adapter(ArrayList<PostJob> postJobArrayList) {
        this.postJobArrayList = postJobArrayList;
    }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DesignJoblistBinding designJoblistBinding = DesignJoblistBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
         return new PostHolder(designJoblistBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.designJoblistBinding.recyclerView0.setText(postJobArrayList.get(position).meslek);
        holder.designJoblistBinding.recyclerView1.setText(postJobArrayList.get(position).isim);
        holder.designJoblistBinding.recyclerView2.setText(postJobArrayList.get(position).adres);
        Picasso.get().load(postJobArrayList.get(position).imageUrl).into(holder.designJoblistBinding.recyclerViewImage);
    }


    @Override
    public int getItemCount() {
        return postJobArrayList.size();
    }

    class PostHolder extends  RecyclerView.ViewHolder{
         DesignJoblistBinding designJoblistBinding;
      //  RecylerRowBinding recylerRowBinding;
/*
        public PostHolder(RecylerRowBinding recylerRowBinding) {
            super(recylerRowBinding.getRoot());
            this.recylerRowBinding= recylerRowBinding;
        }*/
        public  PostHolder(DesignJoblistBinding designJoblistBinding){
            super(designJoblistBinding.getRoot());
            this.designJoblistBinding=designJoblistBinding;
        }
    }
}
