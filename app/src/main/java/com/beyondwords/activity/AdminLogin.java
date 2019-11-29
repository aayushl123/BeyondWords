package com.beyondwords.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.beyondwords.R;
import com.beyondwords.database.UserDatabase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdminLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
    }
}
