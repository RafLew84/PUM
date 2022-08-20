package pl.udu.uwr.pum.taskyjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import pl.udu.uwr.pum.taskyjava.adapter.TaskAdapter;
import pl.udu.uwr.pum.taskyjava.data.DataProvider;
import pl.udu.uwr.pum.taskyjava.databinding.FragmentTaskyBinding;
import pl.udu.uwr.pum.taskyjava.model.Task;
import pl.udu.uwr.pum.taskyjava.model.TaskGroup;
import pl.udu.uwr.pum.taskyjava.util.SharedPrefUtil;

public class TaskyFragment extends Fragment {

    private FragmentTaskyBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTaskyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Task> tasks = SharedPrefUtil.getTaskList(requireContext());

        binding.rvTasky.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.rvTasky.setAdapter(new TaskAdapter(tasks));

        binding.addButton.setOnClickListener(v -> {
            String task = Objects.requireNonNull(binding.taskEditText.getText()).toString();
            String cat = Objects.requireNonNull(binding.groupEditText.getText()).toString();

            if (!task.isEmpty() && !cat.isEmpty()){
                TaskAdapter adapter = (TaskAdapter) Objects.requireNonNull(binding.rvTasky.getAdapter());
                adapter.add(new Task(task, new TaskGroup(cat)), requireContext());
                binding.groupEditText.getText().clear();
                binding.taskEditText.getText().clear();
            }
        });

        binding.clearButton.setOnClickListener(v -> {
            TaskAdapter adapter = (TaskAdapter) Objects.requireNonNull(binding.rvTasky.getAdapter());
            adapter.clear(requireContext());
        });
    }
}
