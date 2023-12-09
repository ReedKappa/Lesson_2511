package com.example.lesson_2511.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_2511.data.db.TaskState
import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.domain.SubscribeTasksOrderedUseCase
import com.example.lesson_2511.domain.UpsertTaskUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val subscribeTasksOrderedUseCase: SubscribeTasksOrderedUseCase,
    private val upsertTaskUseCase: UpsertTaskUseCase,
) : ViewModel() {
    fun changeTaskState(task: Task, index: Int) {
        val taskState = TaskState.values()[index]
        val copy = task.copy(
            state = taskState
        )
        viewModelScope.launch {
            upsertTaskUseCase(copy)
        }
    }

    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>>
        get() = _tasks

    init {
        viewModelScope.launch {
            subscribeTasksOrderedUseCase().collect {
                _tasks.postValue(it)
            }
        }
    }
}