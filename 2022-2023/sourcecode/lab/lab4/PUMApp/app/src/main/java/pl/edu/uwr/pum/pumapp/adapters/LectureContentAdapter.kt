package pl.edu.uwr.pum.pumapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.pumapp.R
import pl.edu.uwr.pum.pumapp.data.DataProvider

class LectureContentAdapter (moduleId: Int) : RecyclerView.Adapter<LectureContentAdapter.ViewHolder>() {

    private val lectureContents = DataProvider.modules[moduleId].lecture.content

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val lectureTextView: TextView = view.findViewById(R.id.lectureTextViewItem)

        fun bind(text: String){
            lectureTextView.text = "- $text"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
            .from(parent.context)
            .inflate(R.layout.lecture_content_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lectureContents[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = lectureContents.size

}