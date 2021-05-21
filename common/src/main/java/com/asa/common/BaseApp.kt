package com.asa.common

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

open class BaseApp:Application() {

    companion object{
        var context: Context by Delegates.notNull()
            private set

        lateinit var instance :BaseApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
    }
}