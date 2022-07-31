package pl.edu.uwr.pum.myfinanceappkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.futured.donut.DonutProgressView
import app.futured.donut.DonutSection
import pl.edu.uwr.pum.myfinanceappkotlin.R
import pl.edu.uwr.pum.myfinanceappkotlin.adapters.BillAdapter
import pl.edu.uwr.pum.myfinanceappkotlin.data.DataProvider
import pl.edu.uwr.pum.myfinanceappkotlin.util.formatter

class BillsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = BillAdapter()
            layoutManager = LinearLayoutManager(this.context)
        }

        view.findViewById<DonutProgressView>(R.id.donut_viewAccount).apply {
            val values = (0 until DataProvider.bills.size).map { DonutSection(
                DataProvider.bills[it].name,
                DataProvider.bills[it].color,
                DataProvider.bills[it].amount.toFloat() / DataProvider.totalBillsAmount.toFloat()
            ) }
            submitData(values)
        }

        view.findViewById<TextView>(R.id.totalAmountTextView).apply {
            ("- ${formatter.format(DataProvider.totalBillsAmount)} zł").also { text = it }
        }
    }
}