package pl.udu.uwr.pum.carsyappkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.carsyappkotlin.R
import pl.udu.uwr.pum.carsyappkotlin.data.Car
import pl.udu.uwr.pum.carsyappkotlin.data.DataProvider
import pl.udu.uwr.pum.carsyappkotlin.util.decimalFormat

class OverviewCarsAdapter : RecyclerView.Adapter<OverviewCarsAdapter.ViewHolder>() {

    private val cars = DataProvider.cars

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val carNameTextView: TextView = view.findViewById(R.id.overviewViewPagerCarName)
        private val brandTextView: TextView = view.findViewById(R.id.overviewViewPagerBrand)
        private val modelTextView: TextView = view.findViewById(R.id.overviewViewPagerModel)
        private val yearTextView: TextView = view.findViewById(R.id.overviewViewPagerYearOfProduction)
        private val totalCostsTextView: TextView = view.findViewById(R.id.overviewViewPagerTotalCosts)

        fun bind (item: Car){
            carNameTextView.text = item.name
            brandTextView.text = item.brand
            modelTextView.text = item.model
            yearTextView.text = item.yearOfProduction.toString()
            totalCostsTextView.text = decimalFormat.format(item.costs.sumOf { it.amount }).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.item_recyclerview_cars_overview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cars[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = cars.size
}