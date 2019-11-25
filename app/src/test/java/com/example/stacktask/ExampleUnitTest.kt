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
        val mainViewModel = MainViewModel()
        mainViewModel.addTask("Clean Kitchen")
        mainViewModel.addTask("Cook Macaroni")
        mainViewModel.removeTopTask()
        assertEquals (mainViewModel.getTopTask(), "Clean Kitchen")
    }

    @Test
    fun task_movedToBottom() {
        val mainViewModel = MainViewModel()
        mainViewModel.addTask("Clean Kitchen")
        mainViewModel.addTask("Cook Macaroni")
        mainViewModel.moveTopTaskToBottom()
        assertEquals (mainViewModel.getTopTask(), "Clean Kitchen")
        mainViewModel.moveTopTaskToBottom()
        assertEquals (mainViewModel.getTopTask(), "Cook Macaroni")
    }

    @Test
    fun task_reminderSet() {
        //val mainViewModel = MainViewModel()
        //mainViewModel.setReminder()
        //TODO: Implement test
    }
}
