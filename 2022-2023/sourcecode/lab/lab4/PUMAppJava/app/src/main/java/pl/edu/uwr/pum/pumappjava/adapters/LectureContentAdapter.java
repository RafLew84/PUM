package pl.edu.uwr.pum.pumappjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.edu.uwr.pum.pumappjava.R;
import pl.edu.uwr.pum.pumappjava.data.DataProvider;
import pl.edu.uwr.pum.pumappjava.data.Module;

public class LectureContentAdapter extends RecyclerView.Adapter<LectureContentAdapter.ViewHolder> {

    private final ArrayList<String> lectureContent;

    public LectureContentAdapter(int moduleId){
        lectureContent = DataProvider.getModules().get(moduleId).getLecture().getContent();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LectureContentAdapter.ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.lecture_content_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = lectureContent.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return lectureContent.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView lectureContentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lectureContentTextView = itemView.findViewById(R.id.lectureTextViewItem);
        }

        public void bind(String item){
            lectureContentTextView.setText(String.format("- %s", item));
        }
    }
}
