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
import com.beyondwords.activity.adapter.EthnicityAdapter;
import com.beyondwords.activity.adapter.SingleAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class EtnicityFragment extends Fragment {


    RecyclerView recyclerView;
    private EthnicityAdapter adapter;
    String[] ethnicity={"African","Asian","Caribbean","North American","North American Indian", "Chinese", "Filipino", "Japanese", "Korean", "Latin American", "South Asian", "South East Asian", "Other"};
    ArrayList<String> ethnicityArrayList =
            new ArrayList<String>(Arrays.asList(ethnicity));
    private Button nextBt;

    private SearchView searchView;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_etnicity, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView_ethic);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 0));

        nextBt=(Button)getActivity().findViewById(R.id.phase2_next);
        viewPager=(ViewPager)getActivity().findViewById(R.id.view_pager);


        searchView=(SearchView) view.findViewById(R.id.ethnic_search);

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

        adapter = new EthnicityAdapter(getContext(), ethnicityArrayList);
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
