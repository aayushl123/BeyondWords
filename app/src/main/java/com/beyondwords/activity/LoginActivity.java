package com.beyondwords.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.beyondwords.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_btn = (Button) findViewById(R.id.bt_login);

        Button bt_admin_admin = (Button) findViewById(R.id.bt_admin_admin);


        login_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, AgreementActivity.class));
            }
        });

        bt_admin_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, AdminLogin.class));
            }
        });


    }
}
