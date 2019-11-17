package com.beyondwords.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class SurveyActivity extends AppCompatActivity {

    ImageView fowardArrowBt,backwardArrowBt;
    Button phase2_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fowardArrowBt=findViewById(R.id.forward_arrow_bt);
        backwardArrowBt=findViewById(R.id.backward_arrow_bt);
        phase2_next=findViewById(R.id.phase2_next);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);

        final ViewPager viewPager = findViewById(R.id.view_pager);


        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));


        fowardArrowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                if(viewPager.getCurrentItem()==10){
                    phase2_next.setText("Submit");
                    phase2_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"Response Submitted",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else {

                    phase2_next.setText("Next");
                    phase2_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                            if(viewPager.getCurrentItem()==10){
                                phase2_next.setText("Submit");
                                phase2_next.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(),"Response Submitted",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                            else {

                                phase2_next.setText("Next");
                                phase2_next.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                });
                            }
                        }
                    });
                }
            }
        });

        backwardArrowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                if(viewPager.getCurrentItem()==10){
                    phase2_next.setText("Submit");
                    phase2_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"Response Submitted",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else {

                    phase2_next.setText("Next");
                    phase2_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                            if(viewPager.getCurrentItem()==10){
                                phase2_next.setText("Submit");
                                phase2_next.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(),"Response Submitted",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                            else {

                                phase2_next.setText("Next");
                                phase2_next.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                });
                            }

                        }
                    });
                }
            }
        });

        phase2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                if(viewPager.getCurrentItem()==10){
                    phase2_next.setText("Submit");


                    phase2_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"Response Submitted",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else {

                    phase2_next.setText("Next");
                    phase2_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }
            }
        });


    }
}
