package pl.edu.uwr.pum.quickyogaappjava;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YogaAdapter extends RecyclerView.Adapter<YogaAdapter.YogaViewHolder> {

    private final ArrayList<YogaPose> yogaPoses;
    private final Context context;

    public YogaAdapter(Context context, ArrayList<YogaPose> yogaPoses) {
        this.yogaPoses = yogaPoses;
        this.context = context;
    }

    protected class YogaViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public YogaViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewItemRV);
        }

        public void bind (YogaPose currentExercise){
            textView.setText(String.valueOf(currentExercise.getId() + 1));
            if (currentExercise.isSelected())
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.item_circular_selected));
            else if (currentExercise.isCompleted()) {
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.item_circular_completed));
                textView.setTextColor(Color.parseColor("#000000"));
            } else{
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.item_circular_bg));
                textView.setTextColor(ContextCompat.getColor(context, R.color.textColor));
            }
        }
    }

    @NonNull
    @Override
    public YogaAdapter.YogaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new YogaViewHolder(
                LayoutInflater.from(
                        parent.getContext()).inflate(
                        R.layout.item_view_yoga_list,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull YogaAdapter.YogaViewHolder holder, int position) {
        YogaPose currentExercise = yogaPoses.get(position);
        holder.bind(currentExercise);
    }

    @Override
    public int getItemCount() {
        return yogaPoses.size();
    }
}
