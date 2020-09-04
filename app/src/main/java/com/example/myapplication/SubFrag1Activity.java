package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SubFrag1Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_frag1);

        ViewPager2 viewPager2 = findViewById(R.id.sub1act_viewPager);
        viewPager2.setAdapter(new ViewPagerAdapterSub1Act(this));

        TabLayout tabLayout = findViewById(R.id.sub1act_tab_layout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch(position){
                    case 0:
                        tab.setText("수업소개");
                        break;
                    case 1:
                        tab.setText("커리큘럼");
                        break;
                    case 2:
                        tab.setText("일정/장소");
                        break;
                    case 3:
                        tab.setText("리뷰");
                        break;
                }
            }
        }
        );
        tabLayoutMediator.attach();
    }
}