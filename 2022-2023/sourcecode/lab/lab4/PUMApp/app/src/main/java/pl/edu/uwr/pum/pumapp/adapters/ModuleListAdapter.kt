package pl.edu.uwr.pum.pumapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.pumapp.R
import pl.edu.uwr.pum.pumapp.data.DataProvider
import pl.edu.uwr.pum.pumapp.data.Module

class ModuleListAdapter : RecyclerView.Adapter<ModuleListAdapter.ViewHolder>() {

    private val moduleList = DataProvider.modules

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val moduleTitleTextView: TextView = view.findViewById(R.id.moduleNameModuleRVItemTextView)
        val lectureTitleTextView: TextView = view.findViewById(R.id.lectureNameModuleRVItemTextView)

        fun bind(item: Module){
            moduleTitleTextView.text = item.name
            lectureTitleTextView.text = item.lecture.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.module_list_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = moduleList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = moduleList.size
}