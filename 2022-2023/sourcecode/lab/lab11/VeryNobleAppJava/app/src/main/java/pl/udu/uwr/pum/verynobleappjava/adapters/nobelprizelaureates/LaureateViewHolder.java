package pl.udu.uwr.pum.verynobleappjava.adapters.nobelprizelaureates;

import android.view.View;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import pl.udu.uwr.pum.verynobleappjava.data.nobelprizeresponse.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.databinding.LaureateRvItemBinding;
import pl.udu.uwr.pum.verynobleappjava.ui.fragments.nobelaward.NobelAwardFragmentDirections;
import pl.udu.uwr.pum.verynobleappjava.ui.fragments.nobelawards.NobleAwardsFragmentDirections;

public class LaureateViewHolder extends RecyclerView.ViewHolder {
    private final LaureateRvItemBinding binding;
    public LaureateViewHolder(LaureateRvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(NobelAwardsResponse.NobelPrizes.Laureates item){
        binding.fullNameTextView.setText(item.getFullName().getEn());
        binding.motivationTextView.setText(item.getMotivation().getEn());
        binding.portionTextView.setText(item.getPortion());
        binding.getRoot().setOnClickListener(v -> {
            NavDirections action = NobelAwardFragmentDirections
                    .actionNobelAwardFragmentToLaureateFragment(
                            item.getId()
                    );
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
    }
}
