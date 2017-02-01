package com.ador.medex.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ador.medex.ModelClass.DrInfo;

import java.util.ArrayList;


public class DrInfoManager {
    DatabaseHelper databaseHelper;
    Context context;
    SQLiteDatabase sqLiteDatabase;
    DrInfo drInfo;

    public DrInfoManager(Context context) {
        this.context = context;
        databaseHelper= new DatabaseHelper(context);
    }

    public long addDrInfo (DrInfo drInfo)
    {
        sqLiteDatabase= databaseHelper.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_DRINFO_NAME,drInfo.getDrName());
        contentValues.put(DatabaseHelper.COLUMN_DRINFO_SPECIALITY,drInfo.getDrSpeciality());
        contentValues.put(DatabaseHelper.COLUMN_DRINFO_PHONE,drInfo.getDrPhoneNumber());
        contentValues.put(DatabaseHelper.COLUMN_DRINFO_ADDRESS,drInfo.getDrAddress());

        long insertedRow= sqLiteDatabase.insert(DatabaseHelper.DRINFO_TABLE,null,contentValues);
        sqLiteDatabase.close();
        return insertedRow;
    }

    public ArrayList<DrInfo>getAllDrInfo()
    {

        ArrayList<DrInfo>drInfos= new ArrayList<>();
        sqLiteDatabase= databaseHelper.getReadableDatabase();
        String selectQuery= "select * from "+DatabaseHelper.DRINFO_TABLE;
        Cursor cursor= sqLiteDatabase.rawQuery(selectQuery,null);
        if (cursor.moveToFirst())
        {
            do {
                int id= cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_ID));
                String name= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_NAME));
                String speciality= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_SPECIALITY));
                String phone= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_PHONE));
                String address= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_ADDRESS));

                DrInfo drInfo= new DrInfo(id,name,speciality,phone,address);
                drInfos.add(drInfo);
            } while (cursor.moveToNext());

        }
        return drInfos;
    }
        public DrInfo getDrInfoById (int id)
        {
            sqLiteDatabase=databaseHelper.getReadableDatabase();
            String selectQuery= "select * from "+DatabaseHelper.DRINFO_TABLE+" where "+DatabaseHelper.COLUMN_DRINFO_ID+" = "+id;
            Cursor cursor= sqLiteDatabase.rawQuery(selectQuery,null);
            if (cursor.moveToFirst())
            {
                String name= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_NAME));
                String speciality= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_SPECIALITY));
                String phone= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_PHONE));
                String address= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DRINFO_ADDRESS));
                drInfo= new DrInfo(name,speciality,phone,address);
            }
            return drInfo;
        }

        public long updateDrInfo(DrInfo drInfo)
        {
            sqLiteDatabase= databaseHelper.getWritableDatabase();

            ContentValues contentValues= new ContentValues();
            contentValues.put(DatabaseHelper.COLUMN_DRINFO_NAME,drInfo.getDrName());
            contentValues.put(DatabaseHelper.COLUMN_DRINFO_SPECIALITY,drInfo.getDrSpeciality());
            contentValues.put(DatabaseHelper.COLUMN_DRINFO_PHONE,drInfo.getDrPhoneNumber());
            contentValues.put(DatabaseHelper.COLUMN_DRINFO_ADDRESS,drInfo.getDrAddress());

            long insertedRow= sqLiteDatabase.update(DatabaseHelper.DRINFO_TABLE,contentValues,DatabaseHelper.COLUMN_DRINFO_ID+" =? ",new String[]{String.valueOf(drInfo.getId())});
            sqLiteDatabase.close();
            return insertedRow;

        }

    public long deleteInfo(DrInfo drInfo) {

        sqLiteDatabase= databaseHelper.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_DRINFO_NAME,drInfo.getDrName());
        contentValues.put(DatabaseHelper.COLUMN_DRINFO_SPECIALITY,drInfo.getDrSpeciality());
        contentValues.put(DatabaseHelper.COLUMN_DRINFO_PHONE,drInfo.getDrPhoneNumber());
        contentValues.put(DatabaseHelper.COLUMN_DRINFO_ADDRESS,drInfo.getDrAddress());

        long insertedRow= sqLiteDatabase.delete(DatabaseHelper.DRINFO_TABLE,DatabaseHelper.COLUMN_DRINFO_ID+" =? ",new String[]{String.valueOf(drInfo.getId())});
        sqLiteDatabase.close();
        return insertedRow;
    }









}
