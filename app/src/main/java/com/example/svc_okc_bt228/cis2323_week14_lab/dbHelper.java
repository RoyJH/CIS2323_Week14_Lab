package com.example.svc_okc_bt228.cis2323_week14_lab;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="TASKS";
    private static final String DB_COLUMN="TASKNAME";

    private static final int DB_VER=1;
    public dbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL)", DB_NAME, DB_COLUMN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q = String.format("DELETE TABLE IF EXISTS %s", DB_NAME);
        db.execSQL(q);
        onCreate(db);
    }

    public void insertTask(String task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN,task);
        db.insertWithOnConflict(DB_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
}
