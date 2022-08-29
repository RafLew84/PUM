package pl.udu.uwr.pum.notykotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.notykotlin.databinding.RecyclerItemViewBinding
import pl.udu.uwr.pum.notykotlin.fragments.NotesFragmentDirections
import pl.udu.uwr.pum.notykotlin.model.NoteModel

class NotyAdapter(private val notes: List<NoteModel>) :
    RecyclerView.Adapter<NotyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerItemViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: NoteModel = notes[position]
        holder.bind(item)
        holder.binding.root.setOnClickListener {
            val action: NavDirections = NotesFragmentDirections
                .actionNotesFragmentToEditNoteFragment(item.id)
            findNavController(holder.binding.root).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class ViewHolder(val binding: RecyclerItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoteModel) {
            binding.timeTextView.text = item.time.toString()
            binding.textTextView.text = item.textNote
            binding.timeTextView.setTextColor(item.color)
            binding.textTextView.setTextColor(item.color)
        }
    }
}