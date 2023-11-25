package com.example.lesson_2511.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lesson_2511.data.module.Task

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val startTime: Long,
    val endTime: Long,
) {
    fun toTask(): Task =
        Task(
            id, title, description, startTime, endTime
        )
}
