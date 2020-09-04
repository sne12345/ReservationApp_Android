package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static com.example.myapplication.R.id.toolbar;

public class Frag2 extends Fragment {

    private View view;
    private RelativeLayout frag2_rel1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2, container, false);

//        // 클릭 시, SubActivity1로 넘어가기
//        frag2_rel1 = (RelativeLayout)view.findViewById(R.id.frag2_rel1);
//        frag2_rel1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(getActivity(), SubActivity1.class);
//                startActivity(in);
//            }
//        });

        return view;
    }
}
