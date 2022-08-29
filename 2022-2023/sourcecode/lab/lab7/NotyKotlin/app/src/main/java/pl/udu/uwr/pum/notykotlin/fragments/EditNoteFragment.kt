package pl.udu.uwr.pum.notykotlin.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import pl.udu.uwr.pum.notykotlin.databinding.FragmentEditNoteBinding
import pl.udu.uwr.pum.notykotlin.db.DBHandler
import pl.udu.uwr.pum.notykotlin.model.NoteModel
import java.time.LocalTime


class EditNoteFragment : Fragment() {
    private lateinit var binding: FragmentEditNoteBinding
    private val dbHandler: DBHandler by lazy { DBHandler(requireContext()) }
    private var noteId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noteId = requireArguments().getInt("id")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.timePicker.setIs24HourView(true)
        val note: NoteModel = dbHandler.getNote(noteId)
        binding.apply {
            textEditText.setText(note.textNote)
            timePicker.hour = note.time.hour
            timePicker.minute = note.time.minute
            checked.isChecked = note.color == Color.CYAN
            saveButton.setOnClickListener {
                val text: String = binding.textEditText.text.toString()
                if (text.isEmpty()) Toast.makeText(context, "Podaj tekst", Toast.LENGTH_SHORT)
                    .show()
                else {
                    var color = Color.BLACK
                    if (binding.checked.isChecked) color = Color.CYAN
                    dbHandler.updateNote(noteId, text, LocalTime.of(binding.timePicker.hour, binding.timePicker.minute), color)
                    val action = EditNoteFragmentDirections
                        .actionEditNoteFragmentToNotesFragment()
                    findNavController(view).navigate(action)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHandler.close()
    }
}