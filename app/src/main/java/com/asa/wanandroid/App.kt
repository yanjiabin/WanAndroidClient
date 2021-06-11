package com.asa.wanandroid

import android.content.Context
import androidx.multidex.MultiDex
import com.asa.common.BaseApp
import kotlin.properties.Delegates

class App:BaseApp() {


    companion object{
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this);
        context = this.applicationContext
    }


}