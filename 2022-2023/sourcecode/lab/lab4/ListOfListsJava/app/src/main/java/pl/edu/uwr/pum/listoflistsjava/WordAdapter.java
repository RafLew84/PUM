package pl.edu.uwr.pum.listoflistsjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private final ArrayList<String> words;
    private final Context context;

    public WordAdapter(String letter, Context context){
        this.context = context;
        words = Arrays.stream(context.getResources().getStringArray(R.array.words))
                .filter(e -> e.toUpperCase(Locale.ROOT).startsWith(letter))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private final Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button_item);
        }
    }

    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
        String item = words.get(position);
        holder.button.setText(item);
        holder.button.setOnClickListener(v -> {
            Uri queryUrl = Uri.parse("https://www.google.com/search?q=" + item);
            Intent intent = new Intent(Intent.ACTION_VIEW, queryUrl);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return words.size();
    }
}
