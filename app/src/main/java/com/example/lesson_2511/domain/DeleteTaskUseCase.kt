package com.example.lesson_2511.domain

import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.data.repository.TasksRepository
import javax.inject.Inject

interface DeleteTaskUseCase {
    suspend operator fun invoke(task: Task)
}

class DeleteTaskUseCaseImpl @Inject constructor(
    private val repository: TasksRepository,
): DeleteTaskUseCase {
    override suspend fun invoke(task: Task) =
        repository.deleteTask(task)

}