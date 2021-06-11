package com.asa.wanandroid.ext

import android.content.Context
import androidx.fragment.app.Fragment
import com.asa.wanandroid.utils.CustomToast

/**
 * create By：anderson
 * on 2021/6/5
 * desc:
 */

fun Context.showToast(content: String) {
    CustomToast(this, content).show()
}


fun Fragment.showToast(content: String) {
    CustomToast(this?.activity?.applicationContext, content).show()
}