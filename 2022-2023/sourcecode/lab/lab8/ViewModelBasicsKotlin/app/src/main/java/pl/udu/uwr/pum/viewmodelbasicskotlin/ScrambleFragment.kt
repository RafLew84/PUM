package pl.udu.uwr.pum.viewmodelbasicskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import pl.udu.uwr.pum.viewmodelbasicskotlin.data.MAX_NO_OF_WORDS
import pl.udu.uwr.pum.viewmodelbasicskotlin.data.SCORE_INCREASE
import pl.udu.uwr.pum.viewmodelbasicskotlin.data.allWordsList
import pl.udu.uwr.pum.viewmodelbasicskotlin.databinding.FragmentScrambleBinding
import pl.udu.uwr.pum.viewmodelbasicskotlin.viewmodel.ScrambleViewModel


class ScrambleFragment : Fragment() {

    private val viewModel: ScrambleViewModel by viewModels()

    private lateinit var binding: FragmentScrambleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScrambleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submit.setOnClickListener { onSubmitWord() }
        binding.skip.setOnClickListener { onSkipWord() }

        updateNextWordOnScreen()
        binding.score.text = getString(R.string.score, 0)
        binding.wordCount.text = getString(
            R.string.word_count, 0, MAX_NO_OF_WORDS)
    }

    private fun onSubmitWord() {
        val playerWord = binding.textInputEditText.text.toString()

        if (viewModel.isUserWordCorrect(playerWord)) {
            setErrorTextField(false)
            if (viewModel.nextWord()) updateNextWordOnScreen()
            else showFinalScoreDialog()
        } else setErrorTextField(true)
    }

    private fun onSkipWord() {
        if (viewModel.nextWord()) {
            setErrorTextField(false)
            updateNextWordOnScreen()
        } else showFinalScoreDialog()
    }

    private fun restartGame() {
        viewModel.reinitializeData()
        setErrorTextField(false)
        updateNextWordOnScreen()
    }

    private fun exitGame() {
        activity?.finish()
    }

    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.textField.isErrorEnabled = true
            binding.textField.error = getString(R.string.try_again)
        } else {
            binding.textField.isErrorEnabled = false
            binding.textInputEditText.text = null
        }
    }

    private fun updateNextWordOnScreen() {
        binding.textViewUnscrambledWord.text = viewModel.currentScrambledWord
    }

    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.congratulations))
            .setMessage(getString(R.string.you_scored, viewModel.score))
            .setCancelable(false)
            .setNegativeButton(getString(R.string.exit)) { _, _ -> exitGame() }
            .setPositiveButton(getString(R.string.play_again)) { _, _ -> restartGame() }
            .show()
    }

}
