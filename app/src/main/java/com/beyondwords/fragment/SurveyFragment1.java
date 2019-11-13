    package com.beyondwords.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.beyondwords.R;



public class SurveyFragment1 extends Fragment {


    String[] country = { "India", "USA", "China", "Japan", "Other"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_survery_fragment1, container, false);

        Spinner genderSpin = (Spinner)view.findViewById(R.id.gender_spinner);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter  genderAdapter = new ArrayAdapter(getContext(),R.layout.spinner_item_layout,country);
        genderAdapter.setDropDownViewResource(R.layout.spinner_item_layout);
        //Setting the ArrayAdapter data on the Spinner
        genderSpin.setAdapter(genderAdapter);

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
