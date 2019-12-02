package com.beyondwords.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.ViewPagerAdapter;
import com.beyondwords.database.CSVWriter;
import com.beyondwords.database.UserDatabase;
import com.beyondwords.model.PersonInfo;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileWriter;

public class SurveyActivity extends AppCompatActivity {

    ImageView fowardArrowBt,backwardArrowBt;
    Button phase2_next;
     ViewPager viewPager;
     LinearLayout linearLayout,linearLayout2;
     UserDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        fowardArrowBt=findViewById(R.id.forward_arrow_bt);
        backwardArrowBt=findViewById(R.id.backward_arrow_bt);
        phase2_next=findViewById(R.id.phase2_next);
        linearLayout=findViewById(R.id.emoji);
        linearLayout2=(LinearLayout)findViewById(R.id.linear2);
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
                if(position==13){

                    System.out.println("here at last");

                    linearLayout.setVisibility(View.GONE);
                    phase2_next.setVisibility(View.VISIBLE);
                    linearLayout2.setVisibility(View.VISIBLE);


                }
                else if(position==0 || position==10 || position==12 ||position==11) {
                    linearLayout.setVisibility(View.GONE);
                    phase2_next.setVisibility(View.GONE);
                    linearLayout2.setVisibility(View.GONE);
                }
                else {

                    linearLayout.setVisibility(View.VISIBLE);
                    phase2_next.setVisibility(View.GONE);

                    linearLayout2.setVisibility(View.VISIBLE);


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

                if(checkCitizenValidation()){


                    final Dialog dialog = new Dialog(SurveyActivity.this, android.R.style.Theme_Translucent_NoTitleBar);
                    dialog.setContentView(R.layout.dialog_layout_submit);
                    Button btn_close = (Button) dialog.findViewById(R.id.btn_close);
                    dialog.show();

                    PersonInfo personInfo = PersonInfo.getInstance();
                    db.insertData(personInfo.getmGender(), personInfo.getmAge(), personInfo.getmCitizenShip(), personInfo.getmCountry(),
                            personInfo.getmLanguage(), personInfo.getmEthnicity(), personInfo.getmReligion(), personInfo.getmSocio(),
                            personInfo.getmProfessionalTraining(), personInfo.getmProfessionalStatus(), personInfo.getmOrgnaization(),
                            personInfo.getmOrganiState(), personInfo.getmOrgnFunction(), personInfo.getmFrequency(),
                            personInfo.getmDescription(), personInfo.getmConcern());

                    sendEmail();

                    System.out.println(personInfo.getmGender()+personInfo.getmAge()+personInfo.getmCitizenShip()+personInfo.getmConcern());

                    btn_close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                          dialog.cancel();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                SurveyActivity.this.finishAffinity();
                            } else {
                                SurveyActivity.this.finish();

                            }

                            startActivity(new Intent(SurveyActivity.this, LoginActivity.class));

                        }
                    });


                    exportDB();


                }
                }



        });




    }

   /* public Cursor getuser()
    {
        String[] columns = new String[]{PRIME_ID, USER_NAME, USER_PASSWORD};
        Cursor cursor = sqLiteDatabase.query(
                LASTLOGIN, columns, null, null, null, null, PRIME_ID +" DESC");
        Log.d("TAG", columns[1]);
        return cursor;
    }*/

    private boolean checkCitizenValidation()
    {
       if (PersonInfo.getInstance().getmCitizenShip().equalsIgnoreCase("")){
           viewPager.setCurrentItem(3);
           return false;
       }
       else {
           return true;
       }
    }

    private void sendEmail()
    {
        String mail = "sudhanva.2001@gmail.com";
        String subject = "BeyondWords Alert: 1 New Submission Made!";
        String message = "\n\n"+"1 new person submitted their response through BeyondWords!"+"\n\n";

        EmailAPI email = new EmailAPI(this,mail,subject,message);
        email.execute();
    }

    private void closeKeyboard() {

        Activity activity = this;

        View view = activity.getCurrentFocus();


        if (view != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }


    private void exportDB() {

        UserDatabase dbhelper = new UserDatabase(getApplicationContext());
        File exportDir = new File(Environment.getExternalStorageDirectory(), "");
        if (!exportDir.exists())
        {
            exportDir.mkdirs();
        }

        File file = new File(exportDir, "BeyondWords.csv");
        try
        {
            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
            SQLiteDatabase db = dbhelper.getReadableDatabase();
            Cursor curCSV = db.rawQuery("SELECT * FROM userInfo",null);
            csvWrite.writeNext(curCSV.getColumnNames());
            while(curCSV.moveToNext())
            {
                //Which column you want to exprort
                String arrStr[] ={curCSV.getString(0),curCSV.getString(1), curCSV.getString(2),
                        curCSV.getString(3),
                        curCSV.getString(4),
                        curCSV.getString(5),
                        curCSV.getString(6),
                        curCSV.getString(7),
                        curCSV.getString(8),

                        curCSV.getString(9),

                        curCSV.getString(10),

                        curCSV.getString(11),

                        curCSV.getString(12),

                        curCSV.getString(13),

                        curCSV.getString(14),

                        curCSV.getString(15),

                        curCSV.getString(16),

                        curCSV.getString(17),
                };
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
            System.out.println("here is the saved filee"+file.getAbsolutePath());
        }
        catch(Exception sqlEx)
        {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }
    }


}
