package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Frag1 extends Fragment {

    private View view;
    private RelativeLayout relative1;
    private RelativeLayout relative2;
    private ImageView img2;
    private ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag1, container, false);

        // 뷰페이저 구현하기
        viewPager2 = view.findViewById(R.id.viewPagerImageSlider);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.slide2));
        sliderItems.add(new SliderItem(R.drawable.slide1));
        sliderItems.add(new SliderItem(R.drawable.slide1));

        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));

        /*
        // 클릭 시, SubActivity1로 넘어가기
        RelativeLayout relative1 = (RelativeLayout)view.findViewById(R.id.relative1);
        relative1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), SubActivity1.class);
                in.putExtra("some","somedata");
                startActivity(in);
            }
        });



        // 클릭 시, SubActivity2로 넘어가기
        RelativeLayout relative2 = (RelativeLayout)view.findViewById(R.id.relative2);
        relative2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), SubActivity2.class);
                in.putExtra("some2","somedata2");
                startActivity(in);
            }
        });

         */


        return view;
    }
}
