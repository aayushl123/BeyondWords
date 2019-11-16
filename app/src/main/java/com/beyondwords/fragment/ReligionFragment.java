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
import java.util.Arrays;


public class ReligionFragment extends Fragment {


    RecyclerView recyclerView;
    private SingleAdapter adapter;
    String[] religion={"Austroasiatic","Buddhism","Chinese","Christianity","Druze","Gnosticism","Hinduism","Islam","Jainism","Judaism",
            "Korean","Meivazhi","Manichaeism","Mazdakism","Nepalese religion","Paganism","Sarnaism","Sikhism","Taoism","No Religion"};
    ArrayList<String> religionArrayList =
            new ArrayList<String>(Arrays.asList(religion));
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_religion, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView_religion);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 0));

        adapter = new SingleAdapter(getContext(), religionArrayList);
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
