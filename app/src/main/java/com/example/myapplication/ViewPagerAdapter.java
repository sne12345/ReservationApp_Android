package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new SubFrag1();
            case 1:
                return new SubFrag2();
            case 2:
                return new SubFrag3();
            case 3:
                return new SubFrag4();
            default:
                return new SubFrag5();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
