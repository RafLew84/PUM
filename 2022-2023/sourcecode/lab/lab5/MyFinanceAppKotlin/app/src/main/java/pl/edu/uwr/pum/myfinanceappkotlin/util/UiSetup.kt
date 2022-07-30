package pl.edu.uwr.pum.myfinanceappkotlin.util

import android.content.Context
import android.graphics.Color
import android.view.View
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
    setupTabLayoutMediator(context, tabLayout, viewPager2)
    val vg = tabLayout.getChildAt(0) as ViewGroup
    initialTabsSetup(vg, tabLayout)
    setupTabSelection(context, vg, tabLayout)
}

private fun setupTabLayoutMediator(context: Context, tabLayout: TabLayout, viewPager2: ViewPager2) {
    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
        tab.icon = ContextCompat.getDrawable(context, tabIcons[position])
        if (position == 0) tab.apply {
            text = context.getString(tabTitles[position])
            icon?.setTint(Color.WHITE)
        }
    }.attach()
}

private fun initialTabsSetup(viewGroup: ViewGroup, tabLayout: TabLayout){
    for (i in 0 until viewGroup.childCount) {
        if (i == tabLayout.selectedTabPosition) continue
        val a = viewGroup.getChildAt(i)
        a.scaleX = tabScaleLow
        a.scaleY = tabScaleLow
    }
}

private fun setupTabSelection(context: Context, viewGroup: ViewGroup, tabLayout: TabLayout){
    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            tab.apply {
                text = context.getString(tabTitles[tab.position])
                icon?.setTint(Color.WHITE)
            }

            setupAnimation(viewGroup.getChildAt(tab.position), tabScaleHigh,
                context.resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            tab.text = ""
            setupAnimation(viewGroup.getChildAt(tab.position), tabScaleLow, 1L)
        }

        override fun onTabReselected(tab: TabLayout.Tab) {}
    })
}

private fun setupAnimation(view: View, scale: Float, duration: Long){
    view.animate()
        .scaleX(scale)
        .scaleY(scale)
        .setInterpolator(FastOutSlowInInterpolator())
        .setDuration(duration)
        .start()
}