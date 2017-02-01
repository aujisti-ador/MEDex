package com.ador.medex.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "drinfo_database";

    public static final String DRINFO_TABLE = "drInfo";
    public static final String COLUMN_DRINFO_ID = "drId";
    public static final String COLUMN_DRINFO_NAME = "drName";
    public static final String COLUMN_DRINFO_SPECIALITY = "drSpeciality";
    public static final String COLUMN_DRINFO_PHONE = "drPhone";
    public static final String COLUMN_DRINFO_ADDRESS = "drAddress";


    private final String CREATE_DRINFO_TABLE= "create table "+DRINFO_TABLE+"("+COLUMN_DRINFO_ID+" integer primary key autoincrement,"+COLUMN_DRINFO_NAME+" text,"+COLUMN_DRINFO_SPECIALITY+" text,"+COLUMN_DRINFO_PHONE+" text,"+COLUMN_DRINFO_ADDRESS+" text);";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DRINFO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+DRINFO_TABLE+" if exists");
        onCreate(db);

    }
}
