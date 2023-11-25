package com.example.lesson_2511.domain

import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.data.repository.TasksRepository
import javax.inject.Inject

interface UpsertTaskUseCase {
    suspend operator fun invoke(task: Task)
}

class UpsertTaskUseCaseImpl @Inject constructor(
    private val repository: TasksRepository,
): UpsertTaskUseCase {
    override suspend fun invoke(task: Task) =
        repository.upsertTask(task)

}