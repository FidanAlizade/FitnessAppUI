package com.example.fitnessappui.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessappui.FitnessMove;
import com.example.fitnessappui.PopupActivity;
import com.example.fitnessappui.R;
import com.example.fitnessappui.databinding.FitnessPicturesRecyclerviewItemBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FitnessPictureAdapter extends RecyclerView.Adapter<FitnessPictureAdapter.FitnessPictureViewHolder> implements View.OnClickListener {

    private ArrayList<FitnessMove> fitnessMoves;
    private AppCompatActivity appCompatActivity;
    private MyListener myListener;
    private FitnessMove fitnessMove;

    public FitnessPictureAdapter(AppCompatActivity appCompatActivity, MyListener myListener) {
        this.appCompatActivity = appCompatActivity;
        this.myListener = myListener;
        fitnessMoves = new ArrayList<>();
    }

    public ArrayList<FitnessMove> getFitnessMoves() {
        return fitnessMoves;
    }

    @NonNull
    @Override
    public FitnessPictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FitnessPicturesRecyclerviewItemBinding binding = FitnessPicturesRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new FitnessPictureViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessPictureViewHolder holder, int position) {
        holder.getMoves(appCompatActivity,fitnessMoves.get(position));
        holder.itemView.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return fitnessMoves.size();
    }
    @Override
    public void onClick(View v) {

        if (v.getTag() instanceof FitnessMove) {
            FitnessMove fitnessMove = (FitnessMove) v.getTag();
            myListener.MyListener(fitnessMove);
        }
    }

    public interface MyListener {
        void MyListener(FitnessMove fitnessMove);
    }


    public class FitnessPictureViewHolder extends RecyclerView.ViewHolder {
        private FitnessPicturesRecyclerviewItemBinding binding;

        public FitnessPictureViewHolder(FitnessPicturesRecyclerviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

        public void getMoves(Context context, FitnessMove fitnessMove) {
            itemView.setTag(fitnessMove);
            Picasso.get().load(fitnessMove.getFitnessPicture()).fit().centerCrop().into(binding.fitnessPicRecyclerViewItemPicture, new Callback() {
                @Override
                public void onSuccess() {
                    binding.recyclerViewPictureProgressBar.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onError(Exception e) {

                }
            });

        }
    }


    }


