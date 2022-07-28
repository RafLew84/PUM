package pl.edu.uwr.pum.viewpagerfragmentstateadapterkotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = MainActivity.num

    override fun createFragment(position: Int): Fragment {
        return TemplateFragment(position)
    }
}