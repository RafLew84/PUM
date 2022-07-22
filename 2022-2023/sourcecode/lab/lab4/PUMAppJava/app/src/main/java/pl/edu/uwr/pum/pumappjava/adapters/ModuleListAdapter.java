package pl.edu.uwr.pum.pumappjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.edu.uwr.pum.pumappjava.R;
import pl.edu.uwr.pum.pumappjava.data.DataProvider;
import pl.edu.uwr.pum.pumappjava.data.Module;
import pl.edu.uwr.pum.pumappjava.fragments.ModuleListFragmentDirections;

public class ModuleListAdapter extends RecyclerView.Adapter<ModuleListAdapter.ViewHolder> {

    private final ArrayList<Module> moduleList = DataProvider.getModules();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.module_list_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Module item = moduleList.get(position);
        holder.bind(item);

        holder.itemView.setOnClickListener(view -> {
            Navigation.findNavController(holder.itemView).navigate(ModuleListFragmentDirections
                    .actionModuleListFragmentToModuleFragment(
                            item.getId()
                    ));
        });
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView moduleTitleTextView;
        private final TextView lectureTitleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moduleTitleTextView = itemView.findViewById(R.id.moduleNameModuleRVItemTextView);
            lectureTitleTextView = itemView.findViewById(R.id.lectureNameModuleRVItemTextView);
        }

        public void bind(Module item){
            moduleTitleTextView.setText(item.getName());
            lectureTitleTextView.setText(item.getLecture().getName());
        }
    }
}
