package pl.edu.uwr.pum.myfinanceappkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.myfinanceappkotlin.R
import pl.edu.uwr.pum.myfinanceappkotlin.data.Bill
import pl.edu.uwr.pum.myfinanceappkotlin.data.DataProvider
import pl.edu.uwr.pum.myfinanceappkotlin.util.dateFormatter
import pl.edu.uwr.pum.myfinanceappkotlin.util.formatter

class BillAdapter : RecyclerView.Adapter<BillAdapter.ViewHolder>(){
    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.RVNameTextView)
        private val endDateTextView: TextView = view.findViewById(R.id.RVNumberTextView)
        private val colorBar: View = view.findViewById(R.id.RVcolorBarView)
        private val amountTextView: TextView = view.findViewById(R.id.RVValueTextView)

        fun bind(item: Bill){
            nameTextView.text = item.name
            endDateTextView.text = item.endDate.format(dateFormatter)
            ("- ${formatter.format(item.amount)} zł").also { amountTextView.text = it }
            colorBar.setBackgroundColor(item.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_item_view, parent, false
            ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = DataProvider.bills[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = DataProvider.bills.size
}