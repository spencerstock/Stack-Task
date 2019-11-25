package com.example.stacktask.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.stacktask.models.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: Task)


    @Query("SELECT * FROM tasks")
    fun getTaskStack(): LiveData<List<Task>>

    @Delete
    fun removeTopTask(task : Task) //TODO: Figure out how to implement something like this

    @Delete
    fun removeTask(task: Task)
}