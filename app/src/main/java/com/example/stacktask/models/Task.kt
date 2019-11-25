package com.example.stacktask.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks")
class Task (val name: String)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}