package com.example.fitnessappui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.fitnessappui.databinding.ActivityMainBinding;
import com.example.fitnessappui.fragment.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private String[] fitnessTabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fitnessTabs = new String[]{"Picttures", "Details"};


        TabLayout tabLayout = binding.activityMainTabLayout;
        ViewPager2 viewPager2 = binding.viewPager;

        //Adapterle de viewPageri birbirine bagladiq
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);


//        Tabla viewPageri birbirine bagladiq
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) ->
                        tab.setText(fitnessTabs[position])
                        //tab.setText("OBJECT " + (position + 1))
        ).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}