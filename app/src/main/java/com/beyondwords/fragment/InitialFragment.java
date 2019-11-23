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


public class InitialFragment extends Fragment {


    RecyclerView recyclerView,recyclerView2;
    private SingleAdapter adapter;
    String[] genderArray = { "Male", "Female", "Other"};

    ArrayList<String> genderList =
            new ArrayList<String>(Arrays.asList(genderArray));

    private Button nextBt;
    private ViewPager viewPager;

    Spinner genderSpin,countrySpinner,homeSpinner,languageSpinner, socioEconomicSpinner,ethnicitySpinner,religionSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_initial, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerViewGender);
        recyclerView2=(RecyclerView)view.findViewById(R.id.recyclerViewGender1);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 0));

        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.addItemDecoration(new DividerItemDecoration(getContext(), 0));

        adapter = new SingleAdapter(getContext(), genderList);
        nextBt=(Button)getActivity().findViewById(R.id.phase2_next);
        viewPager=(ViewPager)getActivity().findViewById(R.id.view_pager);



        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter);
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
