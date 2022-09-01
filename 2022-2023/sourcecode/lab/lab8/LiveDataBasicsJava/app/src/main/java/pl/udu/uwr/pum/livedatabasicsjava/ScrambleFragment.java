package pl.udu.uwr.pum.livedatabasicsjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import pl.udu.uwr.pum.livedatabasicsjava.data.DataProvider;
import pl.udu.uwr.pum.livedatabasicsjava.databinding.FragmentScrambleBinding;
import pl.udu.uwr.pum.livedatabasicsjava.viemodel.ScrambleViewModel;

public class ScrambleFragment extends Fragment {

    private FragmentScrambleBinding binding;
    private ScrambleViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ScrambleViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScrambleBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.submit.setOnClickListener(v -> onSubmitWord());
        binding.skip.setOnClickListener(v -> onSkipWord());

        updateNextWordOnScreen();
        binding.wordCount.setText(getString(
                R.string.word_count, 0, DataProvider.MAX_NO_OF_WORDS));

        viewModel.getCurrentScrambledWord().observe(getViewLifecycleOwner(), newWord ->
                binding.textViewUnscrambledWord.setText(newWord));

        viewModel.getScore().observe(getViewLifecycleOwner(), score ->
                binding.score.setText(String.valueOf(score)));

        viewModel.getCurrentWordCount().observe(getViewLifecycleOwner(), wordCount ->
                binding.wordCount.setText(getString(R.string.word_count, wordCount, DataProvider.MAX_NO_OF_WORDS)));
    }

    private void onSubmitWord() {
        String playerWord = "";
        if (binding.textInputEditText.getText() != null)
            playerWord = binding.textInputEditText.getText().toString();

        if (viewModel.isUserWordCorrect(playerWord)) {
            setErrorTextField(false);
            if (viewModel.nextWord()) updateNextWordOnScreen();
            else showFinalScoreDialog();
        } else setErrorTextField(true);
    }

    private void onSkipWord() {
        if (viewModel.nextWord()) {
            setErrorTextField(false);
            updateNextWordOnScreen();
        } else showFinalScoreDialog();
    }

    private void exitGame() {
        if (getActivity() != null)
            getActivity().finish();
    }

    private void setErrorTextField(boolean error) {
        if (error) {
            binding.textField.setErrorEnabled(true);
            binding.textField.setError(getString(R.string.try_again));
        } else {
            binding.textField.setErrorEnabled(false);
            binding.textInputEditText.setText(null);
        }
    }

    private void updateNextWordOnScreen() {
        binding.textViewUnscrambledWord.setText(viewModel.getCurrentScrambledWord().getValue());
    }

    private void showFinalScoreDialog() {
        new MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.congratulations))
                .setMessage(getString(R.string.you_scored, viewModel.getScore().getValue()))
                .setCancelable(false)
                .setNegativeButton(getString(R.string.exit), (dialog, which) -> exitGame())
            .setPositiveButton(getString(R.string.play_again), (dialog, which) -> restartGame())
            .show();
    }

    private void restartGame() {
        viewModel.reinitializeData();
        setErrorTextField(false);
        updateNextWordOnScreen();
    }
}