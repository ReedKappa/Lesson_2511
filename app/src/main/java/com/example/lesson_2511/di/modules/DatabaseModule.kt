package com.example.lesson_2511.di.modules

import android.content.Context
import androidx.room.Room
import com.example.lesson_2511.data.db.TaskDAO
import com.example.lesson_2511.data.db.TaskDataBase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {


    @Provides
    fun provideDatabase(context: Context): TaskDataBase =
        Room.databaseBuilder(
            context,
            TaskDataBase::class.java,
            "tasks.db"
        ).build()

    @Provides
    fun provideTaskDao(db: TaskDataBase): TaskDAO =
        db.taskDao

}