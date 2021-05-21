package com.asa.wanandroid

import androidx.multidex.MultiDex
import com.asa.common.BaseApp

class App:BaseApp() {


    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this);
    }


}