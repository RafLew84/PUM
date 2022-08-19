package pl.udu.uwr.pum.taskykotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.taskykotlin.databinding.ItemGroupRowBinding
import pl.udu.uwr.pum.taskykotlin.databinding.ItemTaskRowBinding
import pl.udu.uwr.pum.taskykotlin.model.Task
import pl.udu.uwr.pum.taskykotlin.model.TaskRow
import pl.udu.uwr.pum.taskykotlin.util.saveTaskList

class TaskAdapter(private val tasksList: MutableList<Task>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var groupedList = tasksList.groupBy { it.type }.flatMap {
        listOf(TaskRow.Header(it.key.name), *(it.value.map { task ->
            (TaskRow.Task(task.name))
        }).toTypedArray())
    }.toMutableList()

    fun add(task: Task, context: Context){
        tasksList.add(task)
        saveTaskList(context, tasksList)
        val header = groupedList.filterIsInstance<TaskRow.Header>().find { it.name == task.type.name }
        if (header == null)
            groupedList.apply {
                add(TaskRow.Header(task.type.name))
                add(TaskRow.Task(task.name))
                notifyItemInserted(groupedList.size)
            }
        else{
            if (header.isExpanded) {
                val i = groupedList.indexOf(TaskRow.Header(task.type.name))
                groupedList.add(i + subList(task.type.name).size, TaskRow.Task(task.name))
                notifyItemInserted(i + subList(task.type.name).size)
            }
        }
    }


    class TaskViewHolder(private val itemBinding: ItemTaskRowBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(task: TaskRow.Task) {
            itemBinding.taskTextView.text = task.name
        }
    }

    inner class HeaderViewHolder(private val itemBinding: ItemGroupRowBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(header: TaskRow.Header) {
            itemBinding.groupTextView.text = header.name
            itemBinding.groupTextView.setOnClickListener {
                if (header.isExpanded) {
                    collapseParentRow(groupedList.indexOf(header))
                    itemBinding.indicatorTextView.text = "+"
                }
                else {
                    expandParentRow(groupedList.indexOf(header))
                    itemBinding.indicatorTextView.text = "–"
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TaskRow.TYPE_TASK -> TaskViewHolder(
                ItemTaskRowBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
            TaskRow.TYPE_HEADER -> HeaderViewHolder(
                ItemGroupRowBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Wrong row type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val taskRow = groupedList[position]) {
            is TaskRow.Task -> (holder as TaskViewHolder).bind(taskRow)
            is TaskRow.Header -> (holder as HeaderViewHolder).bind(taskRow)
        }
    }

    override fun getItemCount(): Int = groupedList.size

    override fun getItemViewType(position: Int): Int = groupedList[position].rowType

    private fun subList(groupName: String): List<TaskRow>{
        return tasksList.filter { it.type.name == groupName }.map {TaskRow.Task(it.name)}
    }

    private fun collapseParentRow(position: Int){
        val item = groupedList[position] as TaskRow.Header
        item.isExpanded = false
        val remove = subList(item.name)
        groupedList.removeAll(remove)
        notifyItemRangeRemoved(position + 1, remove.size)
    }

    private fun expandParentRow(position: Int){
        val item = groupedList[position] as TaskRow.Header
        val expand = subList(item.name).reversed()
        item.isExpanded = true
        expand.forEach{groupedList.add(position + 1, it)}
        notifyItemRangeInserted(position + 1, expand.size)
    }
}