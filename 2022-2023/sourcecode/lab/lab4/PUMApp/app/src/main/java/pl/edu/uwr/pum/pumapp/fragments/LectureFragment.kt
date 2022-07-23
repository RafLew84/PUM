package pl.edu.uwr.pum.pumapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.pumapp.R
import pl.edu.uwr.pum.pumapp.adapters.LectureContentAdapter
import pl.edu.uwr.pum.pumapp.adapters.ModuleListAdapter
import pl.edu.uwr.pum.pumapp.data.DataProvider
import java.lang.IllegalArgumentException

class LectureFragment : Fragment() {

    private val moduleId by lazy {
        arguments?.getInt("moduleId")?:
            throw IllegalArgumentException("moduleId doesn't exist")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val lectureName = DataProvider.modules[moduleId].lecture.name
        val activity: AppCompatActivity = activity as AppCompatActivity
        activity.supportActionBar?.title = lectureName
        return inflater.inflate(R.layout.fragment_lecture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.lectureRecyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = LectureContentAdapter(moduleId)
        }
    }
}