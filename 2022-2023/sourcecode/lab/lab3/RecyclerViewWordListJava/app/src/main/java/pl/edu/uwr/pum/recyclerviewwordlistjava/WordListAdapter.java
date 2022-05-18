package pl.edu.uwr.pum.recyclerviewwordlistjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordListViewHolder> {

    private LinkedList<String> wordList;
    private final LayoutInflater inflater;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        inflater = LayoutInflater.from(context);
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordListAdapter.WordListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.word_list_item, parent, false);
        return new WordListViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordListViewHolder holder, int position) {
        String current = wordList.get(position);
        holder.wordText.setText(current);
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    protected class WordListViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordText;
        final WordListAdapter adapter;

        public WordListViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            wordText = itemView.findViewById(R.id.singleWord);

            itemView.setOnClickListener(view -> {
                int position = getLayoutPosition();
                String element = wordList.get(position);
                wordList.set(position, "Clicked!" + element);
                adapter.notifyItemChanged(position);
            });
        }
    }
}
