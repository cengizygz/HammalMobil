package com.example.firebasego.Adaptor;

import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasego.databinding.RecylerRowBinding;
import com.example.firebasego.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private ArrayList<Post> postArrayList;

    public PostAdapter(ArrayList<Post> postArrayList) {

        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerRowBinding recylerRowBinding = RecylerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PostHolder(recylerRowBinding);
      //  DesignJoblistBinding designJoblistBinding = DesignJoblistBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
       // return new PostHolder(designJoblistBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        holder.recylerRowBinding.recyclerView0.setText(postArrayList.get(position).adres);
        holder.recylerRowBinding.recyclerView1.setText(postArrayList.get(position).deneyim);
        holder.recylerRowBinding.recyclerView2.setText(postArrayList.get(position).iletisim);
        holder.recylerRowBinding.recyclerView3.setText(postArrayList.get(position).isim);
        holder.recylerRowBinding.recyclerView4.setText(postArrayList.get(position).yas);
        holder.recylerRowBinding.recyclerView5.setText(postArrayList.get(position).meslek);
        holder.recylerRowBinding.recyclerView6.setText(postArrayList.get(position).calismasaat);
        holder.recylerRowBinding.recyclerView7.setText(postArrayList.get(position).ogretim);
        holder.recylerRowBinding.recyclerView8.setText(postArrayList.get(position).tanit);
        Picasso.get().load(postArrayList.get(position).imageUrl).into(holder.recylerRowBinding.recyclerViewImage);
         /*
        holder.designJoblistBinding.recyclerView0.setText(postArrayList.get(position).isim);
        holder.designJoblistBinding.recyclerView1.setText(postArrayList.get(position).meslek);
        holder.designJoblistBinding.recyclerView2.setText(postArrayList.get(position).yas);
        holder.designJoblistBinding.recyclerView3.setText(postArrayList.get(position).calismasaat);
        */
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    class PostHolder extends  RecyclerView.ViewHolder{
       // DesignJoblistBinding designJoblistBinding;
        RecylerRowBinding recylerRowBinding;

        public PostHolder(RecylerRowBinding recylerRowBinding) {
            super(recylerRowBinding.getRoot());
            this.recylerRowBinding= recylerRowBinding;
        }/*
        public  PostHolder(DesignJoblistBinding designJoblistBinding){
            super(designJoblistBinding.getRoot());
            this.designJoblistBinding=designJoblistBinding;
        }*/
    }
}
