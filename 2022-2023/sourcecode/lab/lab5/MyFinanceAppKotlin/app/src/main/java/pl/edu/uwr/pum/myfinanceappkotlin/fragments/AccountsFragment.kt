package pl.edu.uwr.pum.myfinanceappkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.futured.donut.DonutProgressView
import app.futured.donut.DonutSection
import pl.edu.uwr.pum.myfinanceappkotlin.R
import pl.edu.uwr.pum.myfinanceappkotlin.adapters.AccountsAdapter
import pl.edu.uwr.pum.myfinanceappkotlin.data.DataProvider
import pl.edu.uwr.pum.myfinanceappkotlin.util.formatter


class AccountsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.accountsRV).apply {
            adapter = AccountsAdapter()
            layoutManager = LinearLayoutManager(this.context)
        }

        view.findViewById<DonutProgressView>(R.id.donut_viewAccount).apply {
            val values = (0 until DataProvider.accounts.size).map { DonutSection(
                DataProvider.accounts[it].name,
                DataProvider.accounts[it].color,
                DataProvider.accounts[it].amount.toFloat() / DataProvider.totalAmount.toFloat()
            ) }
            submitData(values)
        }

        view.findViewById<TextView>(R.id.totalAmountTextView).apply {
            ("${formatter.format(DataProvider.totalAmount)} zł").also { text = it }
        }
    }
}