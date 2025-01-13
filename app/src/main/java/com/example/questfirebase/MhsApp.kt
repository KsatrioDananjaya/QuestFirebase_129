package com.example.questfirebase

import android.app.Application
import com.example.questfirebase.di.AppContainer
import com.example.questfirebase.di.MhsContainer

class MhsApp : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = MhsContainer()
    }
}