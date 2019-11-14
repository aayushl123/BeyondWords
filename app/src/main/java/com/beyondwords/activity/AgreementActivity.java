package com.beyondwords.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beyondwords.R;

public class AgreementActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        setTitle(R.string.terms_cond);

        Button agreeBt = (Button) findViewById(R.id.bt_agree);
        agreeBt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgreementActivity.this, SurveyActivity.class));
            }
        });
    }
}
