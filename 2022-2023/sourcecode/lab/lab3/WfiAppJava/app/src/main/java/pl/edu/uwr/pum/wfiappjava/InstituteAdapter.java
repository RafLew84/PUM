package pl.edu.uwr.pum.wfiappjava;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class InstituteAdapter extends RecyclerView.Adapter<InstituteAdapter.InstituteViewHolder> {

    public static final String INSTITUTE_EXTRA = "pl.edu.uwr.pum.wfiappjava.institute";

    private final ArrayList<Institute> institutes;
    private final Context context;

    public InstituteAdapter(Context context, ArrayList<Institute> instituteData){
        this.institutes = instituteData;
        this.context = context;
    }

    public class InstituteViewHolder extends RecyclerView.ViewHolder implements View
            .OnClickListener{

        private final TextView titleTextView;
        private final TextView infoTextView;
        private final ImageView instituteImage;

        public InstituteViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.title);
            infoTextView = itemView.findViewById(R.id.subTitle);
            instituteImage = itemView.findViewById(R.id.instituteImage);

            itemView.setOnClickListener(this);
        }

        public void bind(Institute currentInstitute){
            titleTextView.setText(currentInstitute.getTitle());
            infoTextView.setText(currentInstitute.getInfo());

            Glide.with(context).load(currentInstitute.getImageResource())
                    .into(instituteImage);
        }

        @Override
        public void onClick(View v) {
            Institute currentInstitute = institutes.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(INSTITUTE_EXTRA, currentInstitute);
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public InstituteAdapter.InstituteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstituteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstituteAdapter.InstituteViewHolder holder, int position) {
        Institute currentInstitute = institutes.get(position);
        holder.bind(currentInstitute);
    }

    @Override
    public int getItemCount() {
        return institutes.size();
    }
}

