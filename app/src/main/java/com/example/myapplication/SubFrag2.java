package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SubFrag2 extends Fragment {

    private View view;


    public static SubFrag2 newInstance(){
        SubFrag2 subfrag1_2 = new SubFrag2();
        return subfrag1_2;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.subfrag2, container, false);
        return view;
    }
}
