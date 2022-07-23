package pl.edu.uwr.pum.pumappjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.edu.uwr.pum.pumappjava.R;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private final ArrayList<String> content;

    public ContentAdapter(ArrayList<String> content){
        this.content = content;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContentAdapter.ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.content_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = content.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView contentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contentTextView = itemView.findViewById(R.id.contentTextViewItem);
        }

        public void bind(String item){
            contentTextView.setText(String.format("- %s", item));
        }
    }
}