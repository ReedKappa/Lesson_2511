package com.example.lesson_2511.di.modules

import android.app.Application
import android.content.Context
import com.example.lesson_2511.data.repository.TasksRepository
import com.example.lesson_2511.data.repository.TasksRepositoryImpl
import com.example.lesson_2511.domain.DeleteTaskUseCase
import com.example.lesson_2511.domain.DeleteTaskUseCaseImpl
import com.example.lesson_2511.domain.SubscribeTasksOrderedUseCase
import com.example.lesson_2511.domain.SubscribeTasksOrderedUseCaseImpl
import com.example.lesson_2511.domain.UpsertTaskUseCase
import com.example.lesson_2511.domain.UpsertTaskUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AppBindsModule {

    @Binds
    @Singleton
    fun bindTasksRepository(repository: TasksRepositoryImpl): TasksRepository

    @Binds
    fun bindSubscribeTasksOrderedUseCase(useCase: SubscribeTasksOrderedUseCaseImpl): SubscribeTasksOrderedUseCase

    @Binds
    fun bindUpsertTaskUseCase(useCase: UpsertTaskUseCaseImpl): UpsertTaskUseCase

    @Binds
    fun bindDeleteTaskUseCase(useCase: DeleteTaskUseCaseImpl): DeleteTaskUseCase

    companion object {
        @Provides
        fun providesContext(app: Application): Context =
            app.applicationContext
    }
}