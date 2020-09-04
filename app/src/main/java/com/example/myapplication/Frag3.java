package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Frag3 extends Fragment {

    private View view;

    SearchView mySearchView;
    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);


        // SearchView에 리스트를 담기 위한 시도
        /*
        mySearchView = view.findViewById(R.id.action_search);
        myList = view.findViewById(R.id.myList);

        list.add("김치찌개");
        list.add("된장찌개");
        list.add("제육볶음");
        list.add("삼계탕");
        list.add("오징어무침");

        //adapter = new ArrayAdapter<>((Context)this, android.R.layout.simple_list_item_1);
        myList.setAdapter(adapter);


         */


        return view;
    }
}
