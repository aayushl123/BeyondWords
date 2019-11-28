package com.beyondwords.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.beyondwords.R;
import com.beyondwords.model.PersonInfo;


public class ProfessionalInfo2Fragment extends Fragment {


    private Button nextBt;
    private ViewPager viewPager;
    private EditText orgTerritory;
    private EditText funcOrg;
    private EditText freqContact;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_professional_info2, container, false);

        nextBt=(Button)getActivity().findViewById(R.id.phase2_next);
        viewPager=(ViewPager)getActivity().findViewById(R.id.view_pager);

        orgTerritory = (EditText)view.findViewById(R.id.org_territory);
        funcOrg = (EditText)view.findViewById(R.id.func_org);
        freqContact = (EditText)view.findViewById(R.id.freq_contact);

        orgTerritory.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    String str = orgTerritory.getText().toString();
                    PersonInfo.getInstance().setmOrganiState(str);
                }
            }
        });

        funcOrg.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    String str = funcOrg.getText().toString();
                    PersonInfo.getInstance().setmOrgnFunction(str);
                }
            }
        });

        freqContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    String str = freqContact.getText().toString();
                    PersonInfo.getInstance().setmFrequency(str);
                }
            }
        });



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
