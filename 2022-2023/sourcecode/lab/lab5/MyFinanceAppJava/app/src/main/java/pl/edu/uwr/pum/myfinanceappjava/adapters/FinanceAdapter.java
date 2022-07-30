package pl.edu.uwr.pum.myfinanceappjava.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

import pl.edu.uwr.pum.myfinanceappjava.fragments.AccountsFragment;
import pl.edu.uwr.pum.myfinanceappjava.fragments.BillsFragment;
import pl.edu.uwr.pum.myfinanceappjava.fragments.OverviewFragment;

public class FinanceAdapter extends FragmentStateAdapter {

    private final Fragment[] fragments = {
            new OverviewFragment(),
            new AccountsFragment(),
            new BillsFragment()
    };

    public FinanceAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
