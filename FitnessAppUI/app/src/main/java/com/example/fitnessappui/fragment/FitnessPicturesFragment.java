package com.example.fitnessappui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.fitnessappui.FitnessMove;
import com.example.fitnessappui.PopupActivity;
import com.example.fitnessappui.databinding.FragmentFitnessPicturesBinding;
import com.example.fitnessappui.recyclerview.FitnessPictureAdapter;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class FitnessPicturesFragment extends Fragment implements FitnessPictureAdapter.MyListener{
    private FragmentFitnessPicturesBinding binding;
    private FitnessPictureAdapter fitnessPictureAdapter;
    private ArrayList<FitnessMove> fitnessMoveArrayList;

    public static FitnessPicturesFragment newInstance(){
        return new FitnessPicturesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFitnessPicturesBinding.inflate(getLayoutInflater());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fitnessPictureAdapter = new FitnessPictureAdapter( (AppCompatActivity) getActivity(),this);
        fitnessMoveArrayList = fitnessPictureAdapter.getFitnessMoves();
        binding.fitnessPictureRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));



        if(isAdded()){
            binding.fitnessPictureRecyclerView.setAdapter(fitnessPictureAdapter);
        }

        getFitnessMoves(fitnessMoveArrayList);

        return  binding.getRoot();
    }

    private ArrayList<FitnessMove> getFitnessMoves(ArrayList<FitnessMove> fitnessMoveArrayList){

        for(int i = 0; i < 32; i++){

            fitnessMoveArrayList.add(new FitnessMove("Fitness Move Name " + i,
                    "https://images.pexels.com/photos/841130/pexels-photo-841130.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                    "Fitness Move Description " + i,
                    100));
        }

        return fitnessMoveArrayList;
    }

    @Override
    public void MyListener(FitnessMove fitnessMove) {
        System.out.println("Fitness Move:" + fitnessMove.getFitnessName());

        Intent intent = PopupActivity.newIntent(getActivity(),fitnessMove);
        startActivity(intent);
    }
}
