package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.User
import pl.udu.uwr.pum.offlinecachingbasicskotlin.databinding.RvItemBinding

class UserAdapter(comparator: UserComparator) : ListAdapter<User, UserViewHolder>(comparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind(getItem(position))
}