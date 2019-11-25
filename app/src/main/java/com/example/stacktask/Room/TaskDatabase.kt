package com.example.stacktask.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.stacktask.models.Task


@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
}