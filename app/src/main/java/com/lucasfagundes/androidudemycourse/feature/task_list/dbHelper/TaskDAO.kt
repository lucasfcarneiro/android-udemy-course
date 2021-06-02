package com.lucasfagundes.androidudemycourse.feature.task_list.dbHelper

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.lucasfagundes.androidudemycourse.feature.task_list.Task
import java.lang.Exception

class TaskDAO(context: Context) : InterfaceTaskDAO {

    private lateinit var db: DbHelper
    private lateinit var contentValues: ContentValues
    private var read = db.readableDatabase
    private var write = db.writableDatabase

    override fun saveTask(task: Task): Boolean {

        contentValues = ContentValues()
        contentValues.put("taskName", task.getNameTask())

        try {
            write.insert(DbHelper.TABLE_TASK ,null,contentValues)
            Log.i("INFO", "Task saved successfully")

        } catch (e: Exception) {
            Log.i("INFO", "Save task error")
            return false
        }
        return true
    }

    override fun updateTask(): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteTask(): Boolean {
        TODO("Not yet implemented")
    }

    override fun list(): List<Task> {
        TODO("Not yet implemented")
    }

}