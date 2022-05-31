package pl.edu.uwr.pum.wfiappkotlin
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val INSTITUTE_EXTRA = "pl.edu.uwr.pum.wfiappkotlin.institute"

class InstituteAdapter(
    private val context: Context,
    private val institutes: ArrayList<Institute>) :
    RecyclerView.Adapter<InstituteAdapter.InstituteViewHolder>() {

    inner class InstituteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val infoTextView: TextView = itemView.findViewById(R.id.subTitle)
        private val instituteImage: ImageView = itemView.findViewById(R.id.instituteImage)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(currentInstitute: Institute) {
            titleTextView.text = currentInstitute.title
            infoTextView.text = currentInstitute.info

            Glide.with(context).load(currentInstitute.imageResource)
                .into(instituteImage)
        }

        override fun onClick(p0: View?) {
            val institute = institutes[adapterPosition]

            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(INSTITUTE_EXTRA, institute)
            }

            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstituteViewHolder =  InstituteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item,
                parent, false
            )
        )

    override fun onBindViewHolder(holder: InstituteViewHolder, position: Int) {
        val currentInstitute = institutes[position]
        holder.bind(currentInstitute)
    }

    override fun getItemCount() = institutes.size
}