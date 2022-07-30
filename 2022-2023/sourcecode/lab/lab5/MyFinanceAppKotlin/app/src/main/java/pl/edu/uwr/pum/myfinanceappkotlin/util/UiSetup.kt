package pl.edu.uwr.pum.myfinanceappkotlin.util

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import pl.edu.uwr.pum.myfinanceappkotlin.R

private const val tabScaleLow = 0.7f
private const val tabScaleHigh = 1f

private val tabTitles = listOf(R.string.overview_name, R.string.accounts_name, R.string.bills_name)
private val tabIcons = listOf(R.drawable.ic_overview, R.drawable.ic_accounts, R.drawable.ic_bills)

fun tabLayoutSetup(context: Context, tabLayout: TabLayout, viewPager2: ViewPager2) {
    val vg = tabLayout.getChildAt(0) as ViewGroup
    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
        tab.icon = ContextCompat.getDrawable(context, tabIcons[position])
        if (position == 0) tab.apply {
            text = context.getString(tabTitles[position])
            icon?.setTint(Color.WHITE)
        }
    }.attach()

    for (i in 0 until vg.childCount) {
        if (i == tabLayout.selectedTabPosition) continue
        val a = vg.getChildAt(i)
        a.scaleX = tabScaleLow
        a.scaleY = tabScaleLow
    }

    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            tab.apply {
                text = context.getString(tabTitles[tab.position])
                icon?.setTint(Color.WHITE)
            }

            val a = vg.getChildAt(tab.position)
            a.animate()
                .scaleX(tabScaleHigh)
                .scaleY(tabScaleHigh)
                .setInterpolator(FastOutSlowInInterpolator())
                .setDuration(
                    context.resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
                )
                .start()
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            tab.text = ""
            val a = vg.getChildAt(tab.position)
            a.animate()
                .scaleX(tabScaleLow)
                .scaleY(tabScaleLow)
                .setInterpolator(FastOutSlowInInterpolator())
                .setDuration(1L)
                .start()
        }

        override fun onTabReselected(tab: TabLayout.Tab) {}
    })
}