package com.example.stacktask.ui.main

import androidx.lifecycle.ViewModel
import com.example.stacktask.models.Task
import java.util.*

class MainViewModel : ViewModel() {
    private val stackOfTasks = Stack<Task>();

    fun addTask(s: String) {
        stackOfTasks.push(Task(s))
    }

    fun getTopTask(): String {
        return stackOfTasks.peek().name
    }

    fun removeTopTask() {
        stackOfTasks.pop()
    }

    fun moveTopTaskToBottom() {
        val tempStack = Stack<Task>()
        val topTask = stackOfTasks.pop()
        while(!stackOfTasks.empty()) {
            tempStack.push(stackOfTasks.pop())
        }
        stackOfTasks.push(topTask)
        while (!tempStack.empty()) {
            stackOfTasks.push(tempStack.pop())
        }
    }
}
