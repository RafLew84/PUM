package pl.udu.uwr.pum.verynobleappjava.adapters.nobelprizelaureates;

import androidx.recyclerview.widget.RecyclerView;

import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.databinding.LaureateRvItemBinding;

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
    }
}
