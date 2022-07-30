package pl.edu.uwr.pum.myfinanceappkotlin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import pl.edu.uwr.pum.myfinanceappkotlin.fragments.AccountsFragment
import pl.edu.uwr.pum.myfinanceappkotlin.fragments.BillsFragment
import pl.edu.uwr.pum.myfinanceappkotlin.fragments.OverviewFragment

class FinanceAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(OverviewFragment(), AccountsFragment(), BillsFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}