package com.asa.wanandroid.adapter

import android.text.Html
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.asa.wanandroid.mvp.model.bean.WXChapterBean
import com.asa.wanandroid.ui.fragment.KnowledgeFragment

/**
 * create By：anderson
 * on 2021/9/7
 * desc:
 */
class WechatViewPagerAdapter(private val list :MutableList<WXChapterBean>,fm:FragmentManager):FragmentStatePagerAdapter(fm) {

    private val fragments = mutableListOf<Fragment>()

    init {
        fragments.clear()
        list.forEach {
            fragments.add(KnowledgeFragment.getInstance(it.id))
        }
    }

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment = fragments[position]


    override fun getPageTitle(position: Int): CharSequence? {
        return Html.fromHtml(list[position].name)
    }

    override fun getItemPosition(`object`: Any): Int = PagerAdapter.POSITION_NONE

}