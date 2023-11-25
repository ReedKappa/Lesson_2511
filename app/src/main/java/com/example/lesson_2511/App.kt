package com.example.lesson_2511

import android.app.Application
import com.example.lesson_2511.di.AppComponent
import com.example.lesson_2511.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        appComponent = DaggerAppComponent.builder().application(this).build()
        super.onCreate()
    }

}