package pl.udu.uwr.pum.galleryappjava.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pl.udu.uwr.pum.galleryappjava.databinding.ItemViewBinding;
import pl.udu.uwr.pum.galleryappjava.model.PictureModel;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private final ArrayList<PictureModel> pictures;

    public GalleryAdapter(ArrayList<PictureModel> pictures){
        this.pictures = pictures;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemViewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PictureModel item = pictures.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemViewBinding itemBinding;
        public ViewHolder(@NonNull ItemViewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(PictureModel item){
            itemBinding.textViewTitle.setText(item.getTitle());
            itemBinding.rcImageView.setImageURI(Uri.parse(item.getImage()));
        }
    }
}