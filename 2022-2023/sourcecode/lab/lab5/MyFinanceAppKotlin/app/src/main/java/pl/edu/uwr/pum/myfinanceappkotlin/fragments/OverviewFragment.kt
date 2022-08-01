package pl.edu.uwr.pum.myfinanceappkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import pl.edu.uwr.pum.myfinanceappkotlin.R
import pl.edu.uwr.pum.myfinanceappkotlin.adapters.AccountAdapter
import pl.edu.uwr.pum.myfinanceappkotlin.adapters.BillAdapter
import pl.edu.uwr.pum.myfinanceappkotlin.data.DataProvider
import pl.edu.uwr.pum.myfinanceappkotlin.util.formatter


class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.accountsRecyclerView).apply {
            adapter = AccountAdapter()
            layoutManager = LinearLayoutManager(this.context)
        }

        view.findViewById<RecyclerView>(R.id.billsRecyclerView).apply {
            adapter = BillAdapter()
            layoutManager = LinearLayoutManager(this.context)
        }

        view.findViewById<TextView>(R.id.accountTotalAmountTextView).apply {
            ("${formatter.format(DataProvider.totalAccountsAmount)} zł").also { text = it }
        }

        view.findViewById<TextView>(R.id.billsTotalAmountTextView).apply {
            ("- ${formatter.format(DataProvider.totalBillsAmount)} zł").also { text = it }
        }

        view.findViewById<Button>(R.id.accountsButton).apply {
            setOnClickListener { activity?.findViewById<ViewPager2>(R.id.viewPager)?.currentItem = 1 }
        }

        view.findViewById<Button>(R.id.billsButton).apply {
            setOnClickListener { activity?.findViewById<ViewPager2>(R.id.viewPager)?.currentItem = 2 }
        }

        view.findViewById<Button>(R.id.seeMoreButton).apply {
            setOnClickListener {
                val builder = AlertDialog.Builder(context, R.style.MyDialogTheme)
                builder.setTitle("Name")
                val customLayout: View = layoutInflater
                    .inflate(R.layout.alert_dialog, null)
                builder.setView(customLayout)
                builder.setPositiveButton("OK") { _, _ -> }
                val dialog = builder.create()
                dialog.show()
            }
        }
    }
}