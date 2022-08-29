package pl.udu.uwr.pum.notyjava.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.time.LocalTime;

import pl.udu.uwr.pum.notyjava.R;
import pl.udu.uwr.pum.notyjava.databinding.FragmentAddNoteBinding;
import pl.udu.uwr.pum.notyjava.databinding.FragmentEditNoteBinding;
import pl.udu.uwr.pum.notyjava.db.DBHandler;
import pl.udu.uwr.pum.notyjava.model.NoteModel;


public class AddNoteFragment extends Fragment {

    private FragmentAddNoteBinding binding;
    private DBHandler dbHandler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler = new DBHandler(requireContext());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddNoteBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.timePicker.setIs24HourView(true);

        binding.saveButton.setOnClickListener(v -> {
            int hour, minute;
            hour = binding.timePicker.getHour();
            minute = binding.timePicker.getMinute();
            String text = binding.textEditText.getText().toString();
            if (text.isEmpty())
                Toast.makeText(getContext(), "Podaj tekst", Toast.LENGTH_SHORT).show();
            else {
                dbHandler.addNote(new NoteModel(text, LocalTime.of(hour, minute)));
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbHandler.close();
    }
}