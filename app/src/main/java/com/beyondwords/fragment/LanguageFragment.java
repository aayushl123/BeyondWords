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

import com.beyondwords.R;
import com.beyondwords.activity.adapter.SingleAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


public class LanguageFragment extends Fragment {


    RecyclerView recyclerView;
    private SingleAdapter adapter;
    ArrayList<String> languages = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setLanguageAdapter();
        View view= inflater.inflate(R.layout.fragment_language, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView_language);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        adapter = new SingleAdapter(getContext(), languages);
        recyclerView.setAdapter(adapter);
        return view;
    }


    private void setLanguageAdapter(){
        Locale[] locales = Locale.getAvailableLocales();
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
