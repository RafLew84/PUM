package pl.udu.uwr.pum.carsyappkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.carsyappkotlin.R
import pl.udu.uwr.pum.carsyappkotlin.data.Car
import pl.udu.uwr.pum.carsyappkotlin.data.Cost
import pl.udu.uwr.pum.carsyappkotlin.data.CostType
import pl.udu.uwr.pum.carsyappkotlin.data.DataProvider
import pl.udu.uwr.pum.carsyappkotlin.util.decimalFormat

class OverviewCostsAdapter : RecyclerView.Adapter<OverviewCostsAdapter.ViewHolder>() {

    private val cars = DataProvider.cars

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val carNameTextView: TextView = view.findViewById(R.id.overviewRecyclerViewCarName)
        private val refuelingTextView: TextView = view.findViewById(R.id.overviewRecyclerViewFueling)
        private val serviceTextView: TextView = view.findViewById(R.id.overviewRecyclerViewService)
        private val parkingTextView: TextView = view.findViewById(R.id.overviewRecyclerViewParking)
        private val insuranceTextView: TextView = view.findViewById(R.id.overviewRecyclerViewInsurance)
        private val ticketTextView: TextView = view.findViewById(R.id.overviewRecyclerViewTicket)

        fun bind (item: Car){
            carNameTextView.text = item.name
            refuelingTextView.text = costValue(item, CostType.REFUELING)
            serviceTextView.text = costValue(item, CostType.SERVICE)
            parkingTextView.text = costValue(item, CostType.PARKING)
            insuranceTextView.text = costValue(item, CostType.INSURANCE)
            ticketTextView.text = costValue(item, CostType.TICKET)
        }

        private fun costValue(item: Car, costType: CostType): String{
            return decimalFormat.format(item.costs
                .filter { it.type == costType }
                .sumOf { it.amount }).toString() + " zł"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_recyclerview_cost_overview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cars[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = cars.size
}