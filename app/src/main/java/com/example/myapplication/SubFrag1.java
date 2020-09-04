package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SubFrag1 extends Fragment {

    private View view;
    private RelativeLayout subfrag1_rel1;
    private RelativeLayout subfrag1_rel2;
    private Context mContext;

    public SubFrag1(){

    }

    public SubFrag1(Context context) {
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.subfrag1, container, false);
        subfrag1_rel1 = (RelativeLayout)view.findViewById(R.id.subfrag1_rel1);

        // 클릭 시, SubActivity1로 넘어가기
        subfrag1_rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), SubFrag1Activity.class);
                //in.putExtra("something","somedata");
                startActivity(in);
            }
        });

        return view;
    }
}
