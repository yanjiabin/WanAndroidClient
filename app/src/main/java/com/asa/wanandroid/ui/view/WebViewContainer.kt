package com.asa.wanandroid.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.asa.wanandroid.R
import com.asa.wanandroid.utils.ColorUtil
import com.asa.wanandroid.utils.SettingUtil

/**
 * create By：anderson
 * on 2021/7/25
 * desc:
 */
class WebViewContainer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CoordinatorLayout(context, attrs, defStyleAttr) {

    private var mDarkTheme: Boolean = false


    private var mMaskColor: Int = Color.TRANSPARENT
    init {
        mDarkTheme = SettingUtil.getIsNightMode()
        if (mDarkTheme) {
            mMaskColor =
                ColorUtil.alphaColor(ContextCompat.getColor(getContext(), R.color.mask_color), 0.6f)
        }
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        if (mDarkTheme) {
            canvas?.drawColor(mMaskColor)
        }
    }
}