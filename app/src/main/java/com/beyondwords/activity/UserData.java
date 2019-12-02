package com.beyondwords.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.beyondwords.R;
import com.beyondwords.activity.adapter.UserListAdapter;
import com.beyondwords.database.UserDatabase;

import java.util.ArrayList;

public class UserData extends AppCompatActivity {


    private static final String TABLE_NAME = "userInfo";
    ArrayList<String> userArray=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getProfilesCount();
        UserListAdapter adapter = new UserListAdapter(userArray,UserData.this);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }

    private void getProfilesCount() {

        UserDatabase dbhelper = new UserDatabase(getApplicationContext());
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        for (int i = 0; i < count; i++) {
            userArray.add("User "+(i+1));
        }
        cursor.close();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
