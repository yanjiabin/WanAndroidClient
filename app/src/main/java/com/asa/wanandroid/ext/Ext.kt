package com.asa.wanandroid.ext

import android.content.Context
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.asa.wanandroid.R
import com.asa.wanandroid.utils.CustomToast
import com.google.android.material.snackbar.Snackbar

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

fun Fragment.showSnackMsg(msg: String) {
    this.activity ?: return
    val snackBar = Snackbar.make(this.activity!!.window.decorView,msg,Snackbar.LENGTH_SHORT)
    val view = snackBar.view
    view.findViewById<TextView>(R.id.snackbar_text)
        .setTextColor(ContextCompat.getColor(this.activity!!, R.color.white))
    snackBar.show()
}