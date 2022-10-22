package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.adapters

import androidx.recyclerview.widget.DiffUtil
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.User

class UserComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return newItem.uid == oldItem.uid
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return newItem == oldItem
    }
}