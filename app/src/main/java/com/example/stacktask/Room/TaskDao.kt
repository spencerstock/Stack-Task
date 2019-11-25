package com.example.stacktask.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.stacktask.models.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: Task)


    @Query("SELECT * FROM tasks")
    fun getTaskStack(): LiveData<List<Task>>
}