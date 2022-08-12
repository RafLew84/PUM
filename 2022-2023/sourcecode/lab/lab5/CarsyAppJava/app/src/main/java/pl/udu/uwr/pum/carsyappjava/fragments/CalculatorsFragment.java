package pl.udu.uwr.pum.carsyappjava.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import kotlin.Triple;
import pl.udu.uwr.pum.carsyappjava.R;
import pl.udu.uwr.pum.carsyappjava.util.FormatterUtil;

public class CalculatorsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculators, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] titles = {"Koszt podróży", "Odległość", "Wymagane paliwo"};
        Spinner spinner = view.findViewById(R.id.calculators_spinner);
        spinner.setAdapter(new ArrayAdapter<>(getContext(), R.layout.spinner_layout, titles));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                TextView textView = view.findViewById(R.id.textViewMainTitle);
                textView.setText(titles[position]);

                TextInputLayout textInputLayout = view.findViewById(R.id.editInputLayout1);
                if (position == 1)
                    textInputLayout.setHint("Paliwo [l]");
                else
                    textInputLayout.setHint("Odległość [km]");

                MaterialButton materialButton = view.findViewById(R.id.calculateButton);
                materialButton.setOnClickListener(v1 -> {
                    EditText editText1 = view.findViewById(R.id.editText1);
                    EditText editText2 = view.findViewById(R.id.editText2);
                    EditText editText3 = view.findViewById(R.id.editText3);
                    Triple<String, String, String> input =new Triple<>(
                        editText1.getText().toString(),
                        editText2.getText().toString(),
                        editText3.getText().toString()
                    );

                    if (!input.getFirst().isEmpty() && !input.getSecond().isEmpty() && !input.getThird().isEmpty()){
                        TextView mainTextView = view.findViewById(R.id.textViewMainValue);
                        TextView bottomTextView = view.findViewById(R.id.textViewBottomValue);

                        Pair<String, String> values = calculators(position, input);
                        mainTextView.setText(values.first);
                        bottomTextView.setText(values.second);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private Pair<String, String> calculators (int position, Triple<String, String, String> values ){
        switch (position){
            case 0:
                String bottomString = FormatterUtil.decimalFormat.format((Double.parseDouble(values.getThird()) / 100) * Double.parseDouble(values.getFirst()));
                String mainString = FormatterUtil.decimalFormat.format(Double.parseDouble(bottomString) * Double.parseDouble(values.getSecond()));
                return new Pair<>(mainString + " zł", bottomString + " l");
            case 1:
                bottomString = FormatterUtil.decimalFormat.format(Double.parseDouble(values.getFirst()) * Double.parseDouble(values.getSecond()));
                mainString = FormatterUtil.decimalFormat.format((100 * Double.parseDouble(values.getFirst())) / Double.parseDouble(values.getThird()));
                return new Pair<>(mainString + " km", bottomString + " zł");
            case 2:
                mainString = FormatterUtil.decimalFormat.format((Double.parseDouble(values.getFirst()) * Double.parseDouble(values.getThird())) / 100 );
                bottomString = FormatterUtil.decimalFormat.format(Double.parseDouble(mainString) * Double.parseDouble(values.getSecond()));
                return new Pair<>(mainString + " l", bottomString + " zł");
            default:
                return new Pair<>("", "");
        }
    }
}