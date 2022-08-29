package pl.udu.uwr.pum.notykotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pl.udu.uwr.pum.notykotlin.adapters.NotyAdapter
import pl.udu.uwr.pum.notykotlin.databinding.FragmentNotesBinding
import pl.udu.uwr.pum.notykotlin.db.DBHandler


class NotesFragment : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    private val dbHandler: DBHandler by lazy { DBHandler(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NotyAdapter(dbHandler.notes)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHandler.close()
    }
}