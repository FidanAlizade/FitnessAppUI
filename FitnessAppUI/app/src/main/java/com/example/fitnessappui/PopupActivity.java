package com.example.fitnessappui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fitnessappui.databinding.ActivityPopupBinding;
import com.example.fitnessappui.fragment.PopupFragment;

public class PopupActivity extends AppCompatActivity {
    ActivityPopupBinding binding ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPopupBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.popup_activity_frame_layout);
//Layoutun icinde tek bir frame layoutdaki fragment istifade olunacaq deye adapter yaratmadan activitylr fragmenti bu sekilde bagladiq
        if (fragment == null){
            //popup fragmentle popup activityni birbirine bagladiq
            fragment = PopupFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.popup_activity_frame_layout,fragment)
                    .commit();
        }
    }

    public static Intent newIntent(Context context, FitnessMove fitnessMove){
        Intent intent = new Intent(context, PopupActivity.class);
        intent.putExtra("INFO", fitnessMove);
        return intent;
    }
}
