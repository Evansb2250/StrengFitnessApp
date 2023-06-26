package com.example.strengthfit.application

import android.app.Application

class StrengthFit : Application() {

    lateinit var container: ApplicationContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultUserRepository(this)
    }
}