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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


    public class SurveyFragment1 extends Fragment {


    String[] genderArray = { "Male", "Female", "Other"};


    Spinner genderSpin,countrySpinner,homeSpinner,languageSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_survery_fragment1, container, false);
        initiliaseViews(view);
        setGenderArray();
        setCountryAdapter();
        setLanguageAdapter();
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

    }

    private void setGenderArray(){
        //Creating the ArrayAdapter instance having the gender list
        ArrayAdapter  genderAdapter = new ArrayAdapter(getContext(),R.layout.spinner_item_layout,genderArray);
        genderAdapter.setDropDownViewResource(R.layout.spinner_item_layout);
        //Setting the ArrayAdapter data on the Spinner
        genderSpin.setAdapter(genderAdapter);

    }

    private void setCountryAdapter(){
        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
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

        ArrayAdapter  countryAdapter = new ArrayAdapter(getContext(),R.layout.spinner_item_layout,countries);
        countryAdapter.setDropDownViewResource(R.layout.spinner_item_layout);
        // Apply the adapter to the your spinner
        countrySpinner.setAdapter(countryAdapter);
        homeSpinner.setAdapter(countryAdapter);
    }

    private void setLanguageAdapter(){
            Locale[] locales = Locale.getAvailableLocales();
            ArrayList<String> languages = new ArrayList<String>();
            for (Locale locale : locales) {
                String language = locale.getDisplayLanguage();
                System.out.println(language);
                if (language.trim().length() > 0 && !languages.contains(language)) {
                    languages.add(language);
                }
            }

            Collections.sort(languages);
            for (String language : languages) {
                System.out.println(language);
            }

            ArrayAdapter  languageAdapter = new ArrayAdapter(getContext(),R.layout.spinner_item_layout,languages);
            languageAdapter.setDropDownViewResource(R.layout.spinner_item_layout);
            // Apply the adapter to the your spinner
            languageSpinner.setAdapter(languageAdapter);
    }


}
