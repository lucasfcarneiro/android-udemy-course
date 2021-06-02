package com.lucasfagundes.androidudemycourse.feature.task_list.dbHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    companion object {
        var DATABASE_NAME = "DB_TASK_LIST"
        var TABLE_TASK = "task"
        var DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTaskTable = ("CREATE TABLE IF NOT EXISTS " + TABLE_TASK
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " taskName TEXT NOT NULL ); ")
        try {
            db.execSQL(createTaskTable)
            Log.i("INFO DB", "table successfully created")
        } catch (e: Exception) {
            Log.i("INFO DB", "Error creating table")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}