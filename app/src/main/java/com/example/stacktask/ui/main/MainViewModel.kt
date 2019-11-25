package com.example.stacktask.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.stacktask.Room.TaskDatabase
import com.example.stacktask.models.Task

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val taskDatabase = TaskDatabase.getAppDatabase(application)

    private var taskStack = taskDatabase.taskdao().getTaskStack()


    fun addTask(s: String) {
        taskDatabase.taskdao().insert(Task(s))
    }

    fun getTopTask(): String {
        return taskStack.value?.get(taskStack.value!!.lastIndex)!!.name
    }

    fun removeTopTask() {
        taskDatabase.taskdao().removeTopTask(taskStack.value!![taskStack.value!!.lastIndex-1])
    }

    fun getAllTasks(): LiveData<List<Task>> {
        return taskDatabase.taskdao().getTaskStack()
    }

    fun removeTask(task : Task) {
        taskDatabase.taskdao().removeTopTask(task)
    }

    fun moveTopTaskToBottom() {
       //TODO: Implement later
    }
}
