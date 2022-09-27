package pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.databinding.NobelPrizeRvItemBinding;
import pl.udu.uwr.pum.verynobleappjava.ui.fragments.nobelawards.NobleAwardsFragmentDirections;

public class NobelPrizeViewHolder extends RecyclerView.ViewHolder {
    private final NobelPrizeRvItemBinding binding;
    public NobelPrizeViewHolder(NobelPrizeRvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(NobelAwardsResponse.NobelPrizes item){
        binding.year.setText(item.getAwardYear());
        if (item.getTopMotivation() != null && item.getTopMotivation().getEn() != null)
            binding.motivation.setText(item.getTopMotivation().getEn());
        else
            binding.motivation.setText("not specified");

        binding.listOfLaureates.setText(laureates(item));

        binding.getRoot().setOnClickListener(v -> {
            NavDirections action = NobleAwardsFragmentDirections
                    .actionNobleAwardsFragmentFragmentToNobelAwardFragment(
                        item.getCategory().getEn(), item.getAwardYear()
                    );
            Navigation.findNavController(binding.getRoot()).navigate(action);
        });
    }

    private String laureates(NobelAwardsResponse.NobelPrizes item){
        StringBuilder laureates = new StringBuilder();
        if (item.getLaureates() != null)
            for(NobelAwardsResponse.NobelPrizes.Laureates laureate : item.getLaureates()) {
                if (laureate.getFullName().getEn() != null && laureate.getFullName() != null)
                    laureates.append(laureate.getFullName().getEn()).append(" ");
                else laureates.append("no name");
            }
        else
            laureates.append("no names");
        return laureates.toString();
    }
}
