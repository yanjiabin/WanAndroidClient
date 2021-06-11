package com.asa.wanandroid.http.schedulers

/**
 * create By：anderson
 * on 2021/6/11
 * desc:
 */
object SchedulerUtils {

    fun <T> ioToMain():IoMainScheduler<T>{
        return IoMainScheduler()
    }

}