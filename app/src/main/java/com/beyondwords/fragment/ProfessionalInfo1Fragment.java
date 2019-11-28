package com.beyondwords.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.beyondwords.R;
import com.beyondwords.model.PersonInfo;

public class ProfessionalInfo1Fragment extends Fragment {

    private EditText profTraining;
    private EditText profStatus;
    private EditText orgType;

    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_professional_info1, container, false);

        profTraining = (EditText)view.findViewById(R.id.prof_training_text);
        profStatus = (EditText)view.findViewById(R.id.profession_status_text);
        orgType = (EditText)view.findViewById(R.id.organisation_ed_view);

        profTraining.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    String str = profTraining.getText().toString();
                    PersonInfo.getInstance().setmProfessionalTraining(str);
                }
            }
        });

        profStatus.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    String str = profStatus.getText().toString();
                    PersonInfo.getInstance().setmProfessionalStatus(str);
                }
            }
        });

        orgType.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    String str = orgType.getText().toString();
                    PersonInfo.getInstance().setmOrgnaization(str);
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
