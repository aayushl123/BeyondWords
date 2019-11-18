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
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.SingleAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


public class CountryFragment extends Fragment {


    RecyclerView recyclerView;
    private SingleAdapter adapter;
    ArrayList<String> countries = new ArrayList<String>();
    private Button nextBt;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setCountryAdapter();
        View view= inflater.inflate(R.layout.fragment_survery_fragment3, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView_country);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 0));

        adapter = new SingleAdapter(getContext(), countries);
        recyclerView.setAdapter(adapter);

        nextBt=(Button)getActivity().findViewById(R.id.phase2_next);
        viewPager=(ViewPager)getActivity().findViewById(R.id.view_pager);



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



    private void setCountryAdapter(){
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
        }

        Collections.sort(countries);
        for (String country : countries) {
            System.out.println(country);
        }

    }


}
