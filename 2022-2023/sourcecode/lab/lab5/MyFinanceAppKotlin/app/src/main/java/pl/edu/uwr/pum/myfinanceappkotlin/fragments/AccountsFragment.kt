package pl.edu.uwr.pum.myfinanceappkotlin.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.myfinanceappkotlin.R
import pl.edu.uwr.pum.myfinanceappkotlin.data.Accounts
import pl.edu.uwr.pum.myfinanceappkotlin.data.DataProvider


class AccountsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accounts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.accountsRV).apply {
            adapter = AccountsAdapter()
            layoutManager = LinearLayoutManager(this.context, )
        }
    }
}

class AccountsAdapter : RecyclerView.Adapter<AccountsAdapter.ViewHolder>(){
    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val nameTextView: TextView = view.findViewById(R.id.ARVaccountNameTextView)
        private val accountNumberTextView: TextView = view.findViewById(R.id.ARVaccountsNumberTextView)
        private val colorBar: View = view.findViewById(R.id.ARVcolorBarView)
        private val amountTextView: TextView = view.findViewById(R.id.ARVaccountValueTextView)

        fun bind(item: Accounts){
            nameTextView.text = item.name
            accountNumberTextView.text = item.number.replaceRange(0 until 6, "******")
            (item.amount.toString() + " zł").also { amountTextView.text = it }
            colorBar.setBackgroundColor(item.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.accounts_item_view, parent, false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = DataProvider.accounts[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = DataProvider.accounts.size
}