package com.beyondwords.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.beyondwords.R;
import com.beyondwords.database.UserDatabase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdminLogin extends Activity {


    private Button login;
    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        login=(Button)findViewById(R.id.login);
        username=(EditText) findViewById(R.id.username);

        password=(EditText)findViewById(R.id.password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isValidated())
                {
                    startActivity(new Intent(AdminLogin.this, UserData.class));
                    finish();
                }
                else {
                    Toast.makeText(AdminLogin.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public boolean isValidated()
    {
        if(username.getText().toString().equalsIgnoreCase("admin")&&
        password.getText().toString().equalsIgnoreCase("admin"))
            return true;

        else
            return false;
    }
}
