package com.beyondwords.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.SingleAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


public class LanguageFragment extends Fragment {


    RecyclerView recyclerView;
    private SingleAdapter adapter;
    ArrayList<String> languages = new ArrayList<String>();
    private Button nextBt;
    private ViewPager viewPager;

    private SearchView searchView;
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
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 0));

        adapter = new SingleAdapter(getContext(), languages);
        recyclerView.setAdapter(adapter);
        nextBt=(Button)getActivity().findViewById(R.id.phase2_next);
        viewPager=(ViewPager)getActivity().findViewById(R.id.view_pager);


        searchView=(SearchView) view.findViewById(R.id.language_search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (adapter != null){
                    adapter.getFilter().filter(newText);
                }

                return true;
            }
        });

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
