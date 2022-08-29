package pl.udu.uwr.pum.notyjava.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.time.LocalTime;

import pl.udu.uwr.pum.notyjava.R;
import pl.udu.uwr.pum.notyjava.databinding.FragmentEditNoteBinding;
import pl.udu.uwr.pum.notyjava.databinding.FragmentNotesBinding;
import pl.udu.uwr.pum.notyjava.db.DBHandler;
import pl.udu.uwr.pum.notyjava.model.NoteModel;


public class EditNoteFragment extends Fragment {

    private FragmentEditNoteBinding binding;
    private DBHandler dbHandler;
    private int id = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler = new DBHandler(requireContext());
        if (getArguments() != null) {
            id =  getArguments().getInt("id");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEditNoteBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.timePicker.setIs24HourView(true);
        NoteModel note = dbHandler.getNote(id);
        binding.textEditText.setText(note.getTextNote());
        binding.timePicker.setHour(note.getTime().getHour());
        binding.timePicker.setMinute(note.getTime().getMinute());
        binding.checked.setChecked(note.getColor() == Color.CYAN);

        binding.saveButton.setOnClickListener(v -> {
            int hour, minute;
            hour = binding.timePicker.getHour();
            minute = binding.timePicker.getMinute();
            String text = binding.textEditText.getText().toString();
            if (text.isEmpty())
                Toast.makeText(getContext(), "Podaj tekst", Toast.LENGTH_SHORT).show();
            else {
                int color = Color.BLACK;
                if (binding.checked.isChecked())
                    color = Color.CYAN;
                dbHandler.updateNote(id, text, LocalTime.of(hour, minute), color);
                NavDirections action = EditNoteFragmentDirections
                        .actionEditNoteFragmentToNotesFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbHandler.close();
    }
}