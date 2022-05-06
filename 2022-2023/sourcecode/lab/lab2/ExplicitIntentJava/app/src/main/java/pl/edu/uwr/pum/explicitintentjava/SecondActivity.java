package pl.edu.uwr.pum.explicitintentjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "pl.edu.uwr.pum.explicitintentjava.REPLY";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.editTextSecond);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    public void returnMessage(View view) {
        String reply = editText.getText().toString();
        Intent intent = new Intent();

        intent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}