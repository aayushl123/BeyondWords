package com.beyondwords.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "beyondWords.db";
    private static final String TABLE_NAME = "userInfo";
    private static final String COL_1 = "user_id";
    private static final String COL_2 = "gender";
    private static final String COL_3 = "age";
    private static final String COL_4 = "citizenship";
    private static final String COL_5 = "home_country";
    private static final String COL_6 = "language";
    private static final String COL_7 = "ethnicity";
    private static final String COL_8 = "religion";
    private static final String COL_9 = "socio_economic_situation";
    private static final String COL_10 = "professional_training";
    private static final String COL_11 = "professional_status";
    private static final String COL_12 = "type_of_organization";
    private static final String COL_13 = "territory_of_organization";
    private static final String COL_14 = "function_in_organization";
    private static final String COL_15 = "frquency_of_contact";
    private static final String COL_16 = "phase2_description";
    private static final String COL_17 = "phase3_concern";
    private static final String COL_18 = "date";

    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String l_sql = "CREATE TABLE "+ TABLE_NAME + "( "+
                COL_1+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_18+ " DATETIME DEFAULT CURRENT_TIMESTAMP , "+
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
        return true;
    }
}
