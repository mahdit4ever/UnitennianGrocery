package com.example.mahdi.unitenniangrocery;

/**
 * Created by mahdi on 7/15/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Consumer.db";
    public static final String TABLE_NAME = "consumer_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PHONE_NO";
    public static final String COL_4 = "ADDRESS";

    public DatabaseHelper (Context context ){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONSUMER_TABLE="CREATE TABLE"+TABLE_NAME+"("+ COL_1+" INTEGER PRIMARY KEY,"+ COL_2+ "TEXT,"+ COL_3+"TEXT,"+COL_4+" TEXT"+ ")";
        db.execSQL(CREATE_CONSUMER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }


    public void addUser(Record record){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(COL_1, record.getId());
        values.put(COL_2, record.getName());
        values.put(COL_3, record.getPhone_no());
        values.put(COL_4, record.getAddress());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Record> getAllRecords () {
       List <Record> recordList = new ArrayList <Record>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                Record record = new Record();
                record.setId(Integer.parseInt(cursor.getString(0)));
                record.setName(cursor.getString(1));
                record.setPhone_no(cursor.getString(2));
                record.setAddress(cursor.getString(3));

                recordList.add(record);
            } while ( cursor.moveToNext());
        }
        return recordList;

    }



}

