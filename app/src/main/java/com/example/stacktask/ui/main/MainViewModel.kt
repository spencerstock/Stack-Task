package com.example.stacktask.ui.main

import androidx.lifecycle.ViewModel
import com.example.stacktask.models.Task
import java.util.*

class MainViewModel : ViewModel() {
    val stackOfTasks = Stack<Task>();

    fun addTask(s: String) {
        stackOfTasks.push(Task(s))
    }

    fun getTopTask() {
        stackOfTasks.peek().name
    }
}
