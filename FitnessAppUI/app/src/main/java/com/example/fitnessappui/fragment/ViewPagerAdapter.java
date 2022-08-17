package com.example.fitnessappui.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fitnessappui.fragment.DetailsFragment;
import com.example.fitnessappui.fragment.FitnessPicturesFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment selectedFragment;

        switch (position){
            case 0: // arraydaki kimi siralama indexi 0 dan baslayir
                selectedFragment = FitnessPicturesFragment.newInstance();
                break;
            case 1:
                selectedFragment = DetailsFragment.newInstance();
                break;
            default:
                return null;
        }
        return selectedFragment;
    }

    @Override
    public int getItemCount() {
        //2 eded fragmentimiz oldugunu yazacagiq
        return 2;
    }




}
