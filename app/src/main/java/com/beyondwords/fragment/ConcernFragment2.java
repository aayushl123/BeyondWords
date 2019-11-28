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
import android.widget.Toast;

import com.beyondwords.R;
import com.beyondwords.model.PersonInfo;


public class ConcernFragment2 extends Fragment {

    private EditText phase3Response;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_survey_fragment5, container, false);

        phase3Response = (EditText)view.findViewById(R.id.phase3_response);
        phase3Response.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    String str = phase3Response.getText().toString();
                    PersonInfo.getInstance().setmConcern(str);
                }
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}

