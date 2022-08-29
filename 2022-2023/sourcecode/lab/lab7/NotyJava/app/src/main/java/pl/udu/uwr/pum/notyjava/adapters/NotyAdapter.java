package pl.udu.uwr.pum.notyjava.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.udu.uwr.pum.notyjava.databinding.RecyclerItemViewBinding;
import pl.udu.uwr.pum.notyjava.fragments.NotesFragmentDirections;
import pl.udu.uwr.pum.notyjava.model.NoteModel;

public class NotyAdapter extends RecyclerView.Adapter<NotyAdapter.ViewHolder> {

    private final ArrayList<NoteModel> notes;

    public NotyAdapter(ArrayList<NoteModel> notes){
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RecyclerItemViewBinding.inflate(LayoutInflater.from(
                parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteModel item = notes.get(position);
        holder.bind(item);
        holder.binding.getRoot().setOnClickListener(v -> {
            NavDirections action = NotesFragmentDirections
                .actionNotesFragmentToEditNoteFragment(item.getId());
            Navigation.findNavController(holder.binding.getRoot()).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerItemViewBinding binding;

        public ViewHolder(RecyclerItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(NoteModel item){
            binding.timeTextView.setText(item.getTime().toString());
            binding.textTextView.setText(item.getTextNote());
            binding.timeTextView.setTextColor(item.getColor());
            binding.textTextView.setTextColor(item.getColor());
        }
    }
}
