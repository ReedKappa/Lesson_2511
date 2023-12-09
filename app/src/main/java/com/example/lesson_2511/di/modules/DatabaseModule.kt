package com.example.lesson_2511.di.modules

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import com.example.lesson_2511.data.db.TaskDAO
import com.example.lesson_2511.data.db.TaskDataBase
import com.example.lesson_2511.data.db.migration.TaskStateMigration
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideMigrations() = arrayOf<Migration>(
        TaskStateMigration()
    )

    @Provides
    fun provideDatabase(context: Context, migrations: Array<Migration>): TaskDataBase =
        Room.databaseBuilder(
            context,
            TaskDataBase::class.java,
            "tasks.db"
        ).addMigrations(*migrations)
            .build()

    @Provides
    fun provideTaskDao(db: TaskDataBase): TaskDAO =
        db.taskDao

}