package com.example.lesson_2511.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.domain.SubscribeTasksOrderedUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val subscribeTasksOrderedUseCase: SubscribeTasksOrderedUseCase,
) : ViewModel() {

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