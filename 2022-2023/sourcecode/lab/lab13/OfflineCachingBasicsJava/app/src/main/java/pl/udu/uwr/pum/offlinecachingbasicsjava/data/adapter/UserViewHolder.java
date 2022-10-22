package pl.udu.uwr.pum.offlinecachingbasicsjava.data.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.User;
import pl.udu.uwr.pum.offlinecachingbasicsjava.databinding.RvItemBinding;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private final RvItemBinding binding;

    public UserViewHolder(RvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(User item){
        binding.firstName.setText(item.getFirst_name());
        binding.lastName.setText(item.getLast_name());
        binding.city.setText(item.getAddress().getCity());
        binding.country.setText(item.getAddress().getCountry());
        binding.dateOfBirth.setText(item.getDate_of_birth());
        binding.creditCardNumber.setText(item.getCredit_card().getCc_number());
        binding.email.setText(item.getEmail());
        binding.employment.setText(item.getEmployment().getTitle());
        binding.gender.setText(item.getGender());
        binding.password.setText(item.getPassword());
        binding.paymentMethod.setText(item.getSubscription().getPayment_method());
        binding.phone.setText(item.getPhone_number());
        binding.plan.setText(item.getSubscription().getPlan());
        binding.term.setText(item.getSubscription().getTerm());
        binding.paymentMethod.setText(item.getSubscription().getPayment_method());
        binding.state.setText(item.getAddress().getState());
        binding.zipCode.setText(item.getAddress().getZip_code());
        binding.status.setText(item.getSubscription().getStatus());
        binding.streetAddress.setText(item.getAddress().getStreet_address());
        binding.streetName.setText(item.getAddress().getStreet_name());
        binding.username.setText(item.getUsername());
        Glide.with(binding.getRoot()).load(item.getAvatar()).into(binding.image);
    }
}
