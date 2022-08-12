package pl.udu.uwr.pum.carsyappkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import pl.udu.uwr.pum.carsyappkotlin.R
import pl.udu.uwr.pum.carsyappkotlin.adapters.TimeLineAdapter
import pl.udu.uwr.pum.carsyappkotlin.data.DataProvider
import pl.udu.uwr.pum.carsyappkotlin.util.decimalFormat

class CalculatorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculators, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Spinner>(R.id.calculators_spinner).apply {

            val titles = listOf("Koszt podróży", "Odległość", "Wymagane paliwo")
            adapter = ArrayAdapter(context, R.layout.spinner_layout, titles)

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    v: View?, position: Int,
                    id: Long
                ) {
                    view.findViewById<TextView>(R.id.textViewMainTitle).text = titles[position]
                    view.findViewById<TextInputLayout>(R.id.editInputLayout1).hint =
                        if (position == 1) "Paliwo [l]" else "Odległość [km]"

                    view.findViewById<MaterialButton>(R.id.calculateButton).setOnClickListener {
                        val input = Triple(
                            view.findViewById<EditText>(R.id.editText1).text.toString(),
                            view.findViewById<EditText>(R.id.editText2).text.toString(),
                            view.findViewById<EditText>(R.id.editText3).text.toString()
                        )

                        if (input.first.isNotEmpty() && input.second.isNotEmpty() && input.third.isNotEmpty()) {
                            val values: Pair<String, String> = calculators(position, input)
                            view.findViewById<TextView>(R.id.textViewMainValue).text = values.first
                            view.findViewById<TextView>(R.id.textViewBottomValue).text = values.second
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }

    private fun calculators(
        position: Int,
        values: Triple<String, String, String>
    ): Pair<String, String> {
        return when (position) {
            0 -> {
                val stringBottom = decimalFormat.format((values.third.toDouble() / 100) * values.first.toDouble()).toString()
                val stringMain = decimalFormat.format(stringBottom.toDouble() * values.second.toDouble()).toString()
                Pair("$stringMain zł", "$stringBottom l")
            }
            1 -> {
                val stringBottom = decimalFormat.format((values.first.toDouble()) * values.second.toDouble()).toString()
                val stringMain = decimalFormat.format((100 * values.first.toDouble()) / values.third.toDouble()).toString()
                Pair("$stringMain km", "$stringBottom zł")
            }
            2 -> {
                val stringMain = decimalFormat.format((values.first.toDouble() * values.third.toDouble()) / 100).toString()
                val stringBottom = decimalFormat.format(stringMain.toDouble() * values.second.toDouble()).toString()
                Pair("$stringMain l", "$stringBottom zł")
            }
            else -> Pair("", "")
        }
    }
}