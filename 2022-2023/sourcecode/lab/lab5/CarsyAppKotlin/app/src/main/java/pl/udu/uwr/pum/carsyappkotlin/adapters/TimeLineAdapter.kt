package pl.udu.uwr.pum.carsyappkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.carsyappkotlin.R
import pl.udu.uwr.pum.carsyappkotlin.data.*
import pl.udu.uwr.pum.carsyappkotlin.util.dateFormatter

class TimeLineAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemList = DataProvider.getTimeLineList().reversed()

    inner class DateViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val dateTextView: TextView = view.findViewById(R.id.timeLineDateTextView)

        fun bind(item: CostDateItem) {
            dateTextView.text = item.date
        }
    }

    inner class GeneralViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private val costTypeTextView: TextView = view.findViewById(R.id.timeLineCostTypeNameTextView)
        private val fullDateTextView: TextView = view.findViewById(R.id.timeLineFullDateTextView)
        private val amountTextView: TextView = view.findViewById(R.id.timeLineCostAmountTextView)
        private val iconImageView: ImageView = view.findViewById(R.id.iconTimeLineImageView)

        fun bind(item: CostGeneralItem) {
            costTypeTextView.text = item.cost.type.costType
            fullDateTextView.text = item.cost.date.format(dateFormatter)
            (item.cost.amount.toString() + " zł").also { amountTextView.text = it }
            iconImageView.background = ContextCompat.getDrawable(context, item.cost.type.icon)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CostListItem.TYPE_DATE ->
                DateViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.date_item_timeline, parent, false
                ))
            else ->
                GeneralViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.general_item_timeline, parent, false
                ))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            CostListItem.TYPE_DATE -> (holder as DateViewHolder).bind(
                item = itemList[position] as CostDateItem
            )
            CostListItem.TYPE_GENERAL -> (holder as GeneralViewHolder).bind(
                item = itemList[position] as CostGeneralItem
            )
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int = itemList[position].type
}