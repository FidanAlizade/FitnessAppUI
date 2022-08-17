package com.example.fitnessappui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fitnessappui.FitnessMove;
import com.example.fitnessappui.databinding.FragmentPopupBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PopupFragment extends Fragment {

    private FitnessMove fitnessMove;
    private FragmentPopupBinding binding;

    public static PopupFragment newInstance(){
        return new PopupFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentPopupBinding.inflate(getLayoutInflater());

        fitnessMove = getActivity().getIntent().getParcelableExtra("INFO");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding.fragmentPopupNameText.setText(fitnessMove.getFitnessName());
        binding.fragmentPopupDescriptionText.setText(fitnessMove.getFitnessDescription());
        binding.fragmentPopupCalorieText.setText("" + fitnessMove.getFitnessCalorie());

        Picasso.get().load(fitnessMove.getFitnessPicture()).fit().centerCrop().into(binding.fragmentPopupImageView, new Callback(){

            @Override
            public void onSuccess() {
                binding.fragmentPopupProgressbar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {

            }
        });

        return binding.getRoot();
    }
}
