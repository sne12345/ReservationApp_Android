package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapterSub1Act extends FragmentStateAdapter {

    public ViewPagerAdapterSub1Act(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new SubFrag1ActFrag1();
            case 1:
                return new SubFrag1ActFrag2();
            case 2:
                return new SubFrag1ActFrag3();
            default:
                return new SubFrag1ActFrag4();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
