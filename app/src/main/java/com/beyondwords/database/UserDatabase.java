package com.beyondwords.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "beyondWords.db";
    public static final String TABLE_NAME = "userInfo";
    public static final String COL_1 = "user_id";
    public static final String COL_2 = "gender";
    public static final String COL_3 = "age";
    public static final String COL_4 = "citizenship";
    public static final String COL_5 = "home_country";
    public static final String COL_6 = "language";
    public static final String COL_7 = "ethnicity";
    public static final String COL_8 = "religion";
    public static final String COL_9 = "socio_economic_situation";
    public static final String COL_10 = "professional_training";
    public static final String COL_11 = "professional_status";
    public static final String COL_12 = "type_of_organization";
    public static final String COL_13 = "territory_of_organization";
    public static final String COL_14 = "function_in_organization";
    public static final String COL_15 = "frquency_of_contact";
    public static final String COL_16 = "phase2_description";
    public static final String COL_17 = "phase3_concern";


    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String l_sql = "CREATE TABLE "+ TABLE_NAME + "( "+
                COL_1+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_2+ " TEXT, "+
                COL_3+ " TEXT, "+
                COL_4+ " TEXT, "+
                COL_5+ " TEXT, "+
                COL_6+ " TEXT, "+
                COL_7+ " TEXT, "+
                COL_8+ " TEXT, "+
                COL_9+ " TEXT, "+
                COL_10+ " TEXT, "+
                COL_11+ " TEXT, "+
                COL_12+ " TEXT, "+
                COL_13+ " TEXT, "+
                COL_14+ " TEXT, "+
                COL_15+ " TEXT, "+
                COL_16+ " TEXT, "+
                COL_17+ " TEXT)";
        db.execSQL(l_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String mGender, String mAge, String mCitizenShip, String mCountry, String mLanguage, String mEthnicity, String mReligion,
                              String mSocio, String mProfessionalTraining, String mProfessionalStatus, String mOrganization, String mOrganiState,
                              String mOrgnFunction, String mFrequency, String mDescription, String mConcern){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, mGender);
        contentValues.put(COL_3, mAge);
        contentValues.put(COL_4, mCitizenShip);
        contentValues.put(COL_5, mCountry);
        contentValues.put(COL_6, mLanguage);
        contentValues.put(COL_7, mEthnicity);
        contentValues.put(COL_8, mReligion);
        contentValues.put(COL_9, mSocio);
        contentValues.put(COL_10, mProfessionalTraining);
        contentValues.put(COL_11, mProfessionalStatus);
        contentValues.put(COL_12, mOrganization);
        contentValues.put(COL_13, mOrganiState);
        contentValues.put(COL_14, mOrgnFunction);
        contentValues.put(COL_15, mFrequency);
        contentValues.put(COL_16, mDescription);
        contentValues.put(COL_17, mConcern);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
