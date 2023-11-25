package com.example.lesson_2511.domain

import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.data.repository.TasksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface SubscribeTasksOrderedUseCase {
    operator fun invoke(): Flow<List<Task>>
}

class SubscribeTasksOrderedUseCaseImpl @Inject constructor(
    private val repository: TasksRepository,
): SubscribeTasksOrderedUseCase {
    override fun invoke(): Flow<List<Task>> =
        repository.tasksOrdered

}