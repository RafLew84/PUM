package pl.edu.uwr.pum.recyclerviewselectorkotlin

import android.view.LayoutInflater
import androidx.recyclerview.selection.SelectionTracker

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class NumberListAdapter(
    private val numberList: List<Int>,
) : RecyclerView.Adapter<NumberListAdapter.NumberListViewHolder>() {

    lateinit var selectionTracker: SelectionTracker<Long>

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumberListViewHolder {
        return NumberListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NumberListViewHolder, position: Int) {
        holder.bind(numberList[position], selectionTracker.isSelected(position.toLong()))
    }

    override fun getItemCount() = numberList.size

    override fun getItemId(position: Int): Long = position.toLong()

    class NumberListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val number: TextView = itemView.findViewById((R.id.numberText))

        fun bind(value: Int, isActivated: Boolean = false) {
            number.text = value.toString()
            itemView.isActivated = isActivated
        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): Long = itemId
            }
    }

}
