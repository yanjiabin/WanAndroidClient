package com.asa.wanandroid.http.schedulers

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * create By：anderson
 * on 2021/6/11
 * desc:
 */
class IoMainScheduler<T>:BaseScheduler<T>(Schedulers.io(),AndroidSchedulers.mainThread())