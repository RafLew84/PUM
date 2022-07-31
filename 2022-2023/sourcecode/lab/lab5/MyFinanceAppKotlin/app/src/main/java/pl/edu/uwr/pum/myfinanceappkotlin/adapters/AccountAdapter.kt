package pl.edu.uwr.pum.myfinanceappkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.myfinanceappkotlin.R
import pl.edu.uwr.pum.myfinanceappkotlin.data.Account
import pl.edu.uwr.pum.myfinanceappkotlin.data.DataProvider
import pl.edu.uwr.pum.myfinanceappkotlin.util.formatter

class AccountAdapter : RecyclerView.Adapter<AccountAdapter.ViewHolder>(){
    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.RVNameTextView)
        private val accountNumberTextView: TextView = view.findViewById(R.id.RVNumberTextView)
        private val colorBar: View = view.findViewById(R.id.RVcolorBarView)
        private val amountTextView: TextView = view.findViewById(R.id.RVValueTextView)

        fun bind(item: Account){
            nameTextView.text = item.name
            accountNumberTextView.text = item.number.replaceRange(0 until 6, "******")
            ("${formatter.format(item.amount)} zł").also { amountTextView.text = it }
            colorBar.setBackgroundColor(item.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.rtecyclerview_item_view, parent, false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = DataProvider.accounts[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = DataProvider.accounts.size
}