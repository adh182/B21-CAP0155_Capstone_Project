package com.cendekia.capstone.ui.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cendekia.capstone.R
import com.cendekia.capstone.ui.myhome.MyHomeFragment
import com.cendekia.capstone.ui.status.StatusFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_title_status, R.string.tab_title_my_home)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> StatusFragment()
            1 -> MyHomeFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2
}