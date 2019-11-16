    package com.beyondwords.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.SingleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;


    public class SurveyFragment1 extends Fragment {


    RecyclerView recyclerView;
    private SingleAdapter adapter;
    String[] genderArray = { "Male", "Female", "Other"};

    ArrayList<String> genderList =
                new ArrayList<String>(Arrays.asList(genderArray));

    Spinner genderSpin,countrySpinner,homeSpinner,languageSpinner, socioEconomicSpinner,ethnicitySpinner,religionSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_survery_fragment1, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerViewGender);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

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

    private void initiliaseViews(View view){
        genderSpin = (Spinner)view.findViewById(R.id.gender_spinner);
        countrySpinner =(Spinner)view.findViewById(R.id.citinzen_spinner);
        homeSpinner=(Spinner)view.findViewById(R.id.home_spinner);
        languageSpinner=(Spinner)view.findViewById(R.id.language_spinner);
        socioEconomicSpinner=(Spinner)view.findViewById(R.id.socio_economic_spinner);
        ethnicitySpinner=(Spinner)view.findViewById(R.id.ethnic_spinner);
        religionSpinner=(Spinner)view.findViewById(R.id.religion_spinner);

    }

}
