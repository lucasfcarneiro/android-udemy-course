package com.lucasfagundes.androidudemycourse.feature.task_list.dbHelper

import com.lucasfagundes.androidudemycourse.feature.task_list.Task

interface InterfaceTaskDAO {

    fun saveTask(task:Task):Boolean
    fun updateTask():Boolean
    fun deleteTask():Boolean
    fun list(): List<Task>
}