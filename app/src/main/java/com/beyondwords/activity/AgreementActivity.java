package com.beyondwords.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.beyondwords.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.beyondwords.R.drawable.bg_button_disabled;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class AgreementActivity extends Activity {


    Button agreeBt,declineBt;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        setTitle(R.string.terms_cond);

         agreeBt = (Button) findViewById(R.id.bt_agree);
         declineBt = (Button) findViewById(R.id.bt_decline);
        checkBox = (CheckBox)findViewById(R.id.chk_box);

        agreeBt.setBackground(getResources().getDrawable(bg_button_disabled));


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    agreeBt.setBackground(getResources().getDrawable(R.drawable.bg_button));
                    agreeBt.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(AgreementActivity.this, SurveyActivity.class));
                            finish();
                        }
                    });
                    agreeBt.setEnabled(TRUE);
                }
                else{
                    agreeBt.setBackground(getResources().getDrawable(bg_button_disabled));
                    agreeBt.setEnabled(FALSE);
                }
            }
        });


        declineBt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
