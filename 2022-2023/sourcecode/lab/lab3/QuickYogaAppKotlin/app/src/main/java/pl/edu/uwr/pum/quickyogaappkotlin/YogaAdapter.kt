package pl.edu.uwr.pum.quickyogaappkotlin

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class YogaAdapter(private val context: Context, private val yogaPoses: ArrayList<YogaPose>) :
    RecyclerView.Adapter<YogaAdapter.YogaViewHolder>() {
    inner class YogaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView
        fun bind(currentExercise: YogaPose) {
            textView.text = "${currentExercise.id + 1}"
            if (currentExercise.isSelected)
                textView.background = ContextCompat.getDrawable(context, R.drawable.item_circular_selected)
            else if (currentExercise.isCompleted) {
                textView.background = ContextCompat.getDrawable(context, R.drawable.item_circular_completed)
                textView.setTextColor(Color.parseColor("#000000"));
            } else{
                textView.background = ContextCompat.getDrawable(context, R.drawable.item_circular_bg)
                textView.setTextColor(ContextCompat.getColor(context, R.color.textColor));
            }
        }

        init {
            textView = itemView.findViewById(R.id.textViewItemRV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YogaViewHolder {
        return YogaViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.item_view_yoga_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: YogaViewHolder, position: Int) {
        val currentExercise = yogaPoses[position]
        holder.bind(currentExercise)
    }

    override fun getItemCount(): Int = yogaPoses.size

}