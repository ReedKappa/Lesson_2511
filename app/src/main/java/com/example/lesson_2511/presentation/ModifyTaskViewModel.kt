package com.example.lesson_2511.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_2511.data.db.TaskState
import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.domain.UpsertTaskUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ModifyTaskViewModel@Inject constructor(
    private val upsertTaskUseCase: UpsertTaskUseCase
): ViewModel() {

    private var task = Task(
        title = "",
        description = "",
        startTime = -1,
        endTime = -1,
        state = TaskState.TODO
    )

    fun validateForm(title: String, description: String): Boolean {
        if(title.trim().isEmpty() || description.trim().isEmpty())
            return false
        task = task.copy(
            title = title.trim(),
            description = description.trim()
        )
        return task.startTime != -1L && task.endTime != -1L
    }

    fun createTask() {
        viewModelScope.launch {
            upsertTaskUseCase(task)
        }
    }

    fun saveTimeInterval(startTime: Long, endTime: Long) {
        task = task.copy(
            startTime = startTime,
            endTime = endTime,
        )
    }


}