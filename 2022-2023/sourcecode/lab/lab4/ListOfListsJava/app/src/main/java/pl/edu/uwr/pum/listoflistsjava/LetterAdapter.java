package pl.edu.uwr.pum.listoflistsjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class LetterAdapter extends RecyclerView.Adapter<LetterAdapter.ViewHolder> {

    private final char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        private final Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button_item);
        }
    }

    @NonNull
    @Override
    public LetterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LetterAdapter.ViewHolder holder, int position) {
        char item = letters[position];
        holder.button.setText(String.valueOf(item));
        holder.button.setOnClickListener(v -> {
            NavDirections action = LetterFragmentDirections
                    .actionLetterFragmentToWordFragment(holder.button.getText().toString());
            Navigation.findNavController(holder.itemView).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return letters.length;
    }
}
