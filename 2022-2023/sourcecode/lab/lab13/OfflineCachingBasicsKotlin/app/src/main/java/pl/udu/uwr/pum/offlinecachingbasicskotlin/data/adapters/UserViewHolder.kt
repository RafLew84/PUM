package pl.udu.uwr.pum.offlinecachingbasicskotlin.data.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.udu.uwr.pum.offlinecachingbasicskotlin.data.User
import pl.udu.uwr.pum.offlinecachingbasicskotlin.databinding.RvItemBinding

class UserViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: User){
        binding.firstName.text = item.first_name
        binding.lastName.text = item.last_name
        binding.city.text = item.address.city
        binding.country.text = item.address.country
        binding.dateOfBirth.text = item.date_of_birth
        binding.creditCardNumber.text = item.credit_card.cc_number
        binding.email.text = item.email
        binding.employment.text = item.employment.title
        binding.gender.text = item.gender
        binding.password.text = item.password
        binding.paymentMethod.text = item.subscription.payment_method
        binding.phone.text = item.phone_number
        binding.plan.text = item.subscription.plan
        binding.term.text = item.subscription.term
        binding.paymentMethod.text = item.subscription.payment_method
        binding.state.text = item.address.state
        binding.zipCode.text = item.address.zip_code
        binding.status.text = item.subscription.status
        binding.streetAddress.text = item.address.street_address
        binding.streetName.text = item.address.street_name
        binding.username.text = item.username
        Glide.with(binding.root).load(item.avatar).into(binding.image)
    }
}