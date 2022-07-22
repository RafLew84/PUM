package pl.edu.uwr.pum.pumapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.pumapp.R
import pl.edu.uwr.pum.pumapp.data.DataProvider

class ModuleListAdapter : RecyclerView.Adapter<ModuleListAdapter.ViewHolder>() {

    val moduleList = DataProvider.modules

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val moduleTitleTextView = view.findViewById<TextView>(R.id.moduleNameModuleRVItemTextView)
        val lectureTitleTextView = view.findViewById<TextView>(R.id.lectureNameModuleRVItemTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.module_list_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = moduleList[position]
        holder.moduleTitleTextView.text = item.name
        holder.lectureTitleTextView.text = item.lecture.name
    }

    override fun getItemCount(): Int = moduleList.size
}