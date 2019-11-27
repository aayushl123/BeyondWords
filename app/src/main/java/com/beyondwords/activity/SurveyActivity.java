package com.beyondwords.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.ViewPagerAdapter;
import com.beyondwords.database.UserDatabase;
import com.beyondwords.model.PersonInfo;
import com.google.android.material.tabs.TabLayout;

public class SurveyActivity extends AppCompatActivity {

    ImageView fowardArrowBt,backwardArrowBt;
    Button phase2_next;
     ViewPager viewPager;
     LinearLayout linearLayout;
     UserDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        fowardArrowBt=findViewById(R.id.forward_arrow_bt);
        backwardArrowBt=findViewById(R.id.backward_arrow_bt);
        phase2_next=findViewById(R.id.phase2_next);
        linearLayout=findViewById(R.id.emoji);
        viewPager = findViewById(R.id.view_pager);




        final View submitView = getLayoutInflater().inflate( R.layout.dialog_layout_submit, null);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }

        });


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);






        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));


        backwardArrowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
              /*  System.out.println(viewPager.getCurrentItem());
                if(viewPager.getCurrentItem()==9){
                    phase2_next.setText("Next");
                    onNextBtClick();
                }
*/
            }
        });

        fowardArrowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

              /*  //Log.e("here",""+viewPager.getCurrentItem());
                System.out.println("here"+viewPager.getCurrentItem());

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
                    onNextBtClick();

                }*/
            }
        });

       /* phase2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                System.out.println(viewPager.getCurrentItem());
               // Log.e("here",""+viewPager.getCurrentItem());

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

                }
            }
        });*/

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                closeKeyboard();

                System.out.println(position);
                if(position==11){

                    System.out.println("here at last");

                    linearLayout.setVisibility(View.GONE);
                    phase2_next.setVisibility(View.VISIBLE);

                }
                else {

                    linearLayout.setVisibility(View.VISIBLE);
                    phase2_next.setVisibility(View.GONE);

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        db=new UserDatabase(SurveyActivity.this);
       onSubmitBtClick();
    }

    private void onSubmitBtClick(){



        phase2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("here");
                Dialog dialog = new Dialog(SurveyActivity.this, android.R.style.Theme_Translucent_NoTitleBar);

                dialog.setContentView(R.layout.dialog_layout_submit);
                Button btn_close=(Button)dialog.findViewById(R.id.btn_close);
                dialog.show();
                PersonInfo personInfo=PersonInfo.getInstance();
                db.insertData(personInfo.getmGender(),personInfo.getmAge(), personInfo.getmCitizenShip(), personInfo.getmCountry(),
                        personInfo.getmLanguage(), personInfo.getmEthnicity(), personInfo.getmReligion(), personInfo.getmSocio(),
                        null,
                        null,null,null,
                        null,null,null,null);

                btn_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            SurveyActivity.this.finishAffinity();
                        } else{
                            SurveyActivity.this.finish();
                            System.exit(0);
                        }
                    }
                });

            }
        });
    }

    private void closeKeyboard() {

        Activity activity = this;

        View view = activity.getCurrentFocus();


        if (view != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

}
