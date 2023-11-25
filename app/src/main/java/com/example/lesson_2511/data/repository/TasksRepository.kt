package com.example.lesson_2511.data.repository

import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.data.db.TaskDAO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface TasksRepository {

    val tasksOrdered: Flow<List<Task>>
    suspend fun upsertTask(task: Task)
    suspend fun deleteTask(task: Task)

}

class TasksRepositoryImpl @Inject constructor(
    private val dao: TaskDAO,
): TasksRepository {
    override val tasksOrdered: Flow<List<Task>>
        get() = dao.getTasksOrderedByEndTime().map {
            it.map { it.toTask() }
        }

    override suspend fun upsertTask(task: Task) {
        dao.upsertTask(task.toTaskEntity())
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(task.toTaskEntity())
    }

}