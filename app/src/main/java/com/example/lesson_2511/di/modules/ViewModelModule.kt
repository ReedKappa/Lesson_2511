package com.example.lesson_2511.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lesson_2511.di.viewModel.ViewModelFactory
import com.example.lesson_2511.di.viewModel.ViewModelKey
import com.example.lesson_2511.presentation.HomeViewModel
import com.example.lesson_2511.presentation.ModifyTaskViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModuleFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ModifyTaskViewModel::class)
    fun bindModifyTaskViewModel(viewModel: ModifyTaskViewModel): ViewModel
}