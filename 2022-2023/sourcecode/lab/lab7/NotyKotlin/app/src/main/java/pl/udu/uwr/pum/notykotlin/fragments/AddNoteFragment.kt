package pl.udu.uwr.pum.notykotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pl.udu.uwr.pum.notykotlin.databinding.FragmentAddNoteFragmentBinding
import pl.udu.uwr.pum.notykotlin.db.DBHandler
import pl.udu.uwr.pum.notykotlin.model.NoteModel
import java.time.LocalTime

class AddNoteFragment : Fragment() {
    private lateinit var binding: FragmentAddNoteFragmentBinding
    private val dbHandler: DBHandler by lazy { DBHandler(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.timePicker.setIs24HourView(true)
        binding.saveButton.setOnClickListener {
            val text: String = binding.textEditText.text.toString()
            if (text.isEmpty()) Toast.makeText(context, "Podaj tekst", Toast.LENGTH_SHORT)
                .show()
            else
                dbHandler.addNote(NoteModel(
                    text,
                    LocalTime.of(binding.timePicker.hour, binding.timePicker.minute))
                )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHandler.close()
    }
}