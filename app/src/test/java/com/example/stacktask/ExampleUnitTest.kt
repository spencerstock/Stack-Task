package com.example.stacktask

import com.example.stacktask.ui.main.MainViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun task_added()  {
        val mainViewModel = MainViewModel()
        mainViewModel.addTask("Clean Kitchen")
        assertEquals (mainViewModel.getTopTask(), "Clean Kitchen")
    }

    @Test
    fun task_removed() {
        MainViewModel.addTask("Clean Kitchen")
        MainViewModel.addTask("Cook Macaroni")
        MainViewModel.removeTopTask()
        assertEquals (MainViewModel.getTopTask(), "Clean Kitchen")
    }

    @Test
    fun task_movedToBottom() {
        MainViewModel.addTask("Clean Kitchen")
        MainViewModel.addTask("Cook Macaroni")
        MainViewModel.moveTopTaskToBottom()
        assertEquals (MainViewModel.getTopTask(), "Clean Kitchen")
        MainViewModel.moveTopTaskToBottom()
        assertEquals (MainViewModel.getTopTask(), "Cook Macaroni")
    }

    @Test
    fun task_reminderSet() {
        MainViewModel.setReminder()
        //TODO: Implement test
    }
}
