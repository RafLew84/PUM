package pl.udu.uwr.pum.taskykotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pl.udu.uwr.pum.taskykotlin.adapter.TaskAdapter
import pl.udu.uwr.pum.taskykotlin.data.DataProvider
import pl.udu.uwr.pum.taskykotlin.databinding.FragmentTaskyBinding
import pl.udu.uwr.pum.taskykotlin.model.Task
import pl.udu.uwr.pum.taskykotlin.model.TaskGroup
import pl.udu.uwr.pum.taskykotlin.model.TaskRow
import pl.udu.uwr.pum.taskykotlin.util.getTasksList

class TaskyFragment : Fragment() {

    private lateinit var binding: FragmentTaskyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tasks: MutableList<Task> = getTasksList(requireContext()).toMutableList()
        binding.rvTasky.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TaskAdapter(tasks)
        }

        binding.addButton.setOnClickListener {
            val task = binding.taskEditText.text.toString()
            val cat = binding.groupEditText.text.toString()

            if (task.isNotEmpty() && cat.isNotEmpty()) {
                (binding.rvTasky.adapter as TaskAdapter).add(Task(task, TaskGroup(cat)), requireContext())
                binding.groupEditText.text?.clear()
                binding.taskEditText.text?.clear()
            }
        }

        binding.clearButton.setOnClickListener {
            (binding.rvTasky.adapter as TaskAdapter).clear(requireContext())
        }
    }
}