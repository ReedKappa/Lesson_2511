package com.example.lesson_2511.di

import android.app.Application
import com.example.lesson_2511.di.modules.AppBindsModule
import com.example.lesson_2511.di.modules.DatabaseModule
import com.example.lesson_2511.di.modules.ViewModelModule
import com.example.lesson_2511.presentation.ModifyTaskFragment
import com.example.lesson_2511.presentation.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class
    ]
)

@Singleton
interface AppComponent {
    fun inject(fragment: HomeFragment)
    fun inject(fragment: ModifyTaskFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}

@Module(
    includes = [
        ViewModelModule::class,
        DatabaseModule::class,
        AppBindsModule::class,
    ]
)
class AppModule