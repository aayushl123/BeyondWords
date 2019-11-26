package com.beyondwords.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.SingleAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class AgeFragment  extends Fragment {


    RecyclerView recyclerView;
    private SingleAdapter adapter;
    String[] age = { "<20", "20-40", "40-60",">60","Other"};

    ArrayList<String> genderList =
            new ArrayList<String>(Arrays.asList(age));




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_age, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.age_recycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 0));

        adapter = new SingleAdapter(getContext(), genderList);



        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }



}
