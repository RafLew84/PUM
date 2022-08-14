package pl.udu.uwr.pum.carsyappkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import pl.udu.uwr.pum.carsyappkotlin.R
import pl.udu.uwr.pum.carsyappkotlin.adapters.OverviewCostsAdapter
import pl.udu.uwr.pum.carsyappkotlin.adapters.OverviewCarsAdapter
import pl.udu.uwr.pum.carsyappkotlin.data.CostType
import pl.udu.uwr.pum.carsyappkotlin.data.DataProvider
import pl.udu.uwr.pum.carsyappkotlin.util.decimalFormat


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
        view.findViewById<RecyclerView>(R.id.overviewCostsRecyclerView).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = OverviewCostsAdapter()
        }

        view.findViewById<RecyclerView>(R.id.overviewCarsRecyclerView).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = OverviewCarsAdapter()
        }

        view.findViewById<TextView>(R.id.overviewFueling).text = totalValue(CostType.REFUELING)
        view.findViewById<TextView>(R.id.overviewService).text = totalValue(CostType.SERVICE)
        view.findViewById<TextView>(R.id.overviewParking).text = totalValue(CostType.PARKING)
        view.findViewById<TextView>(R.id.overviewInsurance).text = totalValue(CostType.INSURANCE)
        view.findViewById<TextView>(R.id.overviewTicket).text = totalValue(CostType.TICKET)

    }

    private fun totalValue(costType: CostType): String {
        return decimalFormat.format(DataProvider.cars
            .flatMap { it.costs }
            .filter { it.type == costType }
            .sumOf { it.amount }).toString()
    }
}