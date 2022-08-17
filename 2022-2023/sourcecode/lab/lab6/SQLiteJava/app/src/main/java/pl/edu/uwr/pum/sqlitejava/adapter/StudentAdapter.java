package pl.edu.uwr.pum.sqlitejava.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pl.edu.uwr.pum.sqlitejava.databinding.DialogUpdateBinding;
import pl.edu.uwr.pum.sqlitejava.databinding.ItemRowBinding;
import pl.edu.uwr.pum.sqlitejava.db.DBHelper;
import pl.edu.uwr.pum.sqlitejava.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private final Context context;
    private final DBHelper dbHelper;

    public StudentAdapter(Context context, DBHelper dbHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRowBinding itemBinding = ItemRowBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student item = dbHelper.getStudents().get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return dbHelper.getStudents().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemRowBinding itemBinding;
        public ViewHolder(@NonNull ItemRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Student item){
            itemBinding.textViewName.setText(item.getName());
            itemBinding.textViewIndex.setText(String.valueOf(item.getIndex()));
            itemBinding.textViewId.setText(String.valueOf(item.getId()));

            itemBinding.imageViewDelete.setOnClickListener(v -> {
                dbHelper.deleteStudent(item);
                notifyItemRemoved(getAdapterPosition());
            });

            itemBinding.imageViewEdit.setOnClickListener(v -> {
                setupDialog(item);
            });
        }

        private void setupDialog(Student item){
            Dialog dialog = new Dialog(context);
            DialogUpdateBinding dialogBinding = DialogUpdateBinding.inflate(
                    LayoutInflater.from(context)
            );
            dialog.setCancelable(false);
            dialog.setContentView(dialogBinding.getRoot());

            dialogBinding.editTextIndexUpdate.setText(String.valueOf(item.getIndex()));
            dialogBinding.editTextNameUpdate.setText(item.getName());

            dialogBinding.buttonUpdate.setOnClickListener(v -> {
                updateDialog(dialogBinding, item, dialog);
            });

            dialogBinding.buttonCancel.setOnClickListener(v -> {
                dialog.dismiss();
            });
            dialog.show();
        }

        private void updateDialog(
                DialogUpdateBinding binding,
                Student item,
                Dialog dialog){
            String updateName = binding.editTextNameUpdate.getText().toString();
            String updateIndex = binding.editTextIndexUpdate.getText().toString();

            if (!updateName.isEmpty() && !updateIndex.isEmpty()){
                dbHelper.updateStudent(item.getId(), updateName, Integer.parseInt(updateIndex));
                notifyItemChanged(getAdapterPosition());
                dialog.dismiss();
            }
        }
    }
}
