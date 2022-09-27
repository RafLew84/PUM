package pl.udu.uwr.pum.verynobleappjava.adapters.laureatenobelprizes;

import androidx.recyclerview.widget.RecyclerView;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.NobelPrize;
import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.nobelprize.affiliation.Affiliation;
import pl.udu.uwr.pum.verynobleappjava.databinding.LaureateNobelPrizeRvItemBinding;

public class NobelPrizeViewHolder extends RecyclerView.ViewHolder {
    private final LaureateNobelPrizeRvItemBinding binding;
    public NobelPrizeViewHolder(LaureateNobelPrizeRvItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(NobelPrize item){
        binding.categoryFullNameTextView.setText(item.categoryFullName.en);
        binding.portionTextView.setText(item.portion);
        binding.yearTextView.setText(item.awardYear);
        binding.motivationTextView.setText(item.motivation.en);
        binding.affiliationsTextView.setText(affiliations(item));
    }

    private String affiliations(NobelPrize item){
        StringBuilder affiliations = new StringBuilder();
        if (item.affiliations != null) {
            for (Affiliation affiliation : item.affiliations) {
                if (affiliation.name != null && affiliation.name.en != null)
                    affiliations.append(affiliation.name.en).append("\n");
            }
        } else
            affiliations.append("not specified");
        return affiliations.toString();
    }
}
