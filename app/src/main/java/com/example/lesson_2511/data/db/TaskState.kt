package com.example.lesson_2511.data.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters

@TypeConverters(TaskState.Converter::class)
enum class TaskState {
    TODO,
    IN_PROGRESS,
    READY;

    class Converter {
        @TypeConverter
        fun toTaskState(value: String): TaskState = enumValueOf(value)

        @TypeConverter
        fun fromTaskState(value: TaskState) = value.name
    }
}