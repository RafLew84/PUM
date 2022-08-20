package pl.udu.uwr.pum.taskyjava.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pl.udu.uwr.pum.taskyjava.databinding.ItemGroupRowBinding;
import pl.udu.uwr.pum.taskyjava.databinding.ItemTaskRowBinding;
import pl.udu.uwr.pum.taskyjava.model.Task;
import pl.udu.uwr.pum.taskyjava.model.TaskRow;
import pl.udu.uwr.pum.taskyjava.util.SharedPrefUtil;


public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<Task> taskList;
    private final ArrayList<TaskRow> rows;

    public TaskAdapter(ArrayList<Task> taskList){
        this.taskList = taskList;
        this.rows = getGroupedTasks();
    }

    public void add(Task task, Context context){
        taskList.add(task);
        SharedPrefUtil.saveTaskList(context, taskList);
        TaskRow.Header header = (TaskRow.Header)rows.stream()
                .filter(i -> (i instanceof TaskRow.Header) && ((TaskRow.Header) i).getName().equals(task.getType().getName()))
                .findAny().orElse(null);
        if (header == null){
            rows.add(new TaskRow.Header(task.getType().getName()));
            rows.add(new TaskRow.Task(task.getName()));
            notifyItemInserted(rows.size());
        } else {
            int i = rows.indexOf(new TaskRow.Header(task.getType().getName()));
            rows.add(i + subList(task.getType().getName()).size(), new TaskRow.Task(task.getName()));
            notifyItemInserted(i + subList(task.getType().getName()).size());
        }
    }

    public void clear(Context context){
        taskList.clear();
        notifyItemRangeRemoved(0, rows.size());
        rows.clear();
        SharedPrefUtil.saveTaskList(context, taskList);
    }

    private static class TaskViewHolder extends RecyclerView.ViewHolder{

        private final ItemTaskRowBinding binding;

        public TaskViewHolder(ItemTaskRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(TaskRow.Task item){
            binding.taskTextView.setText(item.getName());
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder{

        private final ItemGroupRowBinding binding;

        public HeaderViewHolder(ItemGroupRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(TaskRow.Header item){
            binding.groupTextView.setText(item.getName());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        switch (viewType){
            case TaskRow.TYPE_TASK:
                viewHolder = new TaskViewHolder(ItemTaskRowBinding.inflate(
                        LayoutInflater.from(parent.getContext()), parent, false));
                break;
            case TaskRow.TYPE_HEADER:
                viewHolder = new HeaderViewHolder(ItemGroupRowBinding.inflate(
                        LayoutInflater.from(parent.getContext()), parent, false
                ));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TaskRow row = rows.get(position);
        if (row instanceof TaskRow.Task)
            ((TaskViewHolder) holder).bind((TaskRow.Task) row);
        else
            ((HeaderViewHolder) holder).bind((TaskRow.Header) row);
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    @Override
    public int getItemViewType(int position) {
        return rows.get(position).getRowType();
    }

    private ArrayList<TaskRow> getGroupedTasks(){
        ArrayList<TaskRow> list = new ArrayList<>();

        Map<String, List<Task>> grouped =
                taskList.stream().collect(Collectors.groupingBy(i -> i.getType().getName()));

        for (String group : grouped.keySet()) {
            list.add(new TaskRow.Header(group));
            List<Task> groupingItems = grouped.get(group);
            if (groupingItems != null) {
                groupingItems.forEach(t -> list.add(new TaskRow.Task(t.getName())));
            }
        }

        return list;
    }

    private List<TaskRow> subList(String groupName){
        return taskList.stream()
                .filter(i -> i.getType().getName().equals(groupName))
                .map(i -> new TaskRow.Task(i.getName()))
                .collect(Collectors.toList());
    }
}
