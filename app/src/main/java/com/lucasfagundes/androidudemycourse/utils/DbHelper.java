package com.lucasfagundes.androidudemycourse.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NAME_DB = "DB_TASK_LIST";
    public static String TASK_TABLE = "task";

    public DbHelper(Context context) {
        super(context, NAME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTask = "CREATE TABLE IF NOT EXISTS " + TASK_TABLE
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " name TEXT NOT NULL ); ";

        try {
            db.execSQL(sqlTask);
            Log.i("INFO DB", "table successfully created");
        } catch (Exception e) {
            Log.i("INFO DB", "Error creating table");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
