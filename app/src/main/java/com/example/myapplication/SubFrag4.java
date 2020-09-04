package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SubFrag4 extends Fragment {

    private View view;

    public static SubFrag4 newInstance(){
        SubFrag4 subfrag1_4 = new SubFrag4();
        return subfrag1_4;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.subfrag4, container, false);
        return view;
    }
}
