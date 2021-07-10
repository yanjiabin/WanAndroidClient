package com.asa.wanandroid.utils

import android.content.Context
import android.widget.ImageView
import com.asa.common.utils.NetWorkUtil
import com.asa.wanandroid.App
import com.asa.wanandroid.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

/**
 * create By：anderson
 * on 2021/7/10
 * desc:
 */
object ImageLoader {

    private val isLoadImage =!SettingUtil.getIsNoPhotoMode()||NetWorkUtil.isWifi(App.context)

    fun load(context: Context?,url:String?,iv:ImageView?){

        if (isLoadImage){
            iv?.apply {
                Glide.with(context!!).clear(this)
                val options = RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .placeholder(R.drawable.bg_placeholder)
                Glide.with(context!!)
                    .load(url!!)
                    .transition(DrawableTransitionOptions().crossFade())
                    .apply(options)
                    .into(this)
            }

        }

    }

}