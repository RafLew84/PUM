package pl.udu.uwr.pum.verynobleappjava.adapters.nobelprize;

import androidx.recyclerview.widget.RecyclerView;

import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.databinding.NobelPrizeRvItemBinding;

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
