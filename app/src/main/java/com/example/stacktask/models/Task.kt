package com.example.stacktask.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.stacktask.ViewPager2.CardColor
import kotlin.random.Random


@Entity(tableName = "tasks")
class Task (val name: String)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var color: Int = CardColor.values()[Random.nextInt(0,CardColor.values().size-1)].rgb


}