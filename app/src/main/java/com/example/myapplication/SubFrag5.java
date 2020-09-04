package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SubFrag5 extends Fragment {

    private View view;

    public static SubFrag5 newInstance(){
        SubFrag5 subfrag1_5 = new SubFrag5();
        return subfrag1_5;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.subfrag5, container, false);
        return view;
    }
}
