package com.example.lesson_2511.data.module

import com.example.lesson_2511.data.db.model.TaskEntity

data class Task(
    var id: Int = 0,
    val title: String,
    val description: String,
    val startTime: Long,
    val endTime: Long,
) {
    fun toTaskEntity(): TaskEntity =
        TaskEntity(
            id, title, description, startTime, endTime
        )
}
