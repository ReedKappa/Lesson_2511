package com.example.lesson_2511.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lesson_2511.data.db.model.TaskEntity

@Database(
    entities = [
        TaskEntity::class,
    ],
    version = 2
)
abstract class TaskDataBase: RoomDatabase() {

    abstract val taskDao: TaskDAO
}