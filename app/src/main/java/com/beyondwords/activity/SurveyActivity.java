package com.beyondwords.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.ViewPagerAdapter;
import com.beyondwords.fragment.SurveyFragment4;

public class SurveyActivity extends AppCompatActivity {

    ImageView fowardArrowBt,backwardArrowBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        fowardArrowBt=findViewById(R.id.forward_arrow_bt);
        backwardArrowBt=findViewById(R.id.backward_arrow_bt);

        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));


        fowardArrowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        });

        backwardArrowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });


    }
}
