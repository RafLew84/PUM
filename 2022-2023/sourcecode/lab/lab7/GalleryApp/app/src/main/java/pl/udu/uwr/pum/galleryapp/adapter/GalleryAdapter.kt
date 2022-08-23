package pl.udu.uwr.pum.galleryapp.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.udu.uwr.pum.galleryapp.databinding.ItemViewBinding
import pl.udu.uwr.pum.galleryapp.model.PictureModel

class GalleryAdapter(private val pictures: List<PictureModel>) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    class ViewHolder(private val itemBinding: ItemViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind (item: PictureModel){
            itemBinding.textViewTitle.text = item.title
            itemBinding.rcImageView.setImageURI(Uri.parse(item.image))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pictures[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = pictures.size
}