package com.beyondwords.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.GenderAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class Phase2Info extends Fragment {


    RecyclerView recyclerView;
    private GenderAdapter adapter;
    String[] genderArray = { "Male", "Female", "Other"};

    ArrayList<String> genderList =
            new ArrayList<String>(Arrays.asList(genderArray));

    private Button nextBt;
    private ViewPager viewPager;

    // Spinner genderSpin,countrySpinner,homeSpinner,languageSpinner, socioEconomicSpinner,ethnicitySpinner,religionSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_phase2_info, container, false);
        //recyclerView=(RecyclerView)view.findViewById(R.id.recyclerViewGender);

        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 0));

        viewPager=(ViewPager)getActivity().findViewById(R.id.view_pager);
        //adapter = new GenderAdapter(getContext(), genderList);

        //nextBt=(Button)getActivity().findViewById(R.id.phase2_next);

        //recyclerView.setAdapter(adapter);
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
