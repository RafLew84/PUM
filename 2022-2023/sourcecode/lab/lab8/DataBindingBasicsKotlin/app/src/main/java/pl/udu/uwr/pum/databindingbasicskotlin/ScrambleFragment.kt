package pl.udu.uwr.pum.databindingbasicskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import pl.udu.uwr.pum.databindingbasicskotlin.data.MAX_NO_OF_WORDS
import pl.udu.uwr.pum.databindingbasicskotlin.databinding.FragmentScrambleBinding
import pl.udu.uwr.pum.databindingbasicskotlin.viewmodel.ScrambleViewModel


class ScrambleFragment : Fragment() {

    private val viewModel: ScrambleViewModel by viewModels()

    private lateinit var binding: FragmentScrambleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scramble, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scrambleViewModel = viewModel

        binding.maxNoOfWords = MAX_NO_OF_WORDS

        binding.submit.setOnClickListener { onSubmitWord() }
        binding.skip.setOnClickListener { onSkipWord() }

        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun onSubmitWord() {
        val playerWord = binding.textInputEditText.text.toString()

        if (viewModel.isUserWordCorrect(playerWord)) {
            setErrorTextField(false)
            if (!viewModel.nextWord()) showFinalScoreDialog()
        } else setErrorTextField(true)
    }

    private fun onSkipWord() {
        if (viewModel.nextWord()) {
            setErrorTextField(false)
        } else showFinalScoreDialog()
    }

    private fun restartGame() {
        viewModel.reinitializeData()
        setErrorTextField(false)
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

    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.congratulations))
            .setMessage(getString(R.string.you_scored, viewModel.score.value))
            .setCancelable(false)
            .setNegativeButton(getString(R.string.exit)) { _, _ -> exitGame() }
            .setPositiveButton(getString(R.string.play_again)) { _, _ -> restartGame() }
            .show()
    }
}
