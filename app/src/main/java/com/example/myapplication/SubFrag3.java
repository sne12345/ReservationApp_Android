package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SubFrag3 extends Fragment {

    private View view;

    public static SubFrag3 newInstance(){
        SubFrag3 subfrag1_3 = new SubFrag3();
        return subfrag1_3;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.subfrag3, container, false);
        return view;
    }
}
