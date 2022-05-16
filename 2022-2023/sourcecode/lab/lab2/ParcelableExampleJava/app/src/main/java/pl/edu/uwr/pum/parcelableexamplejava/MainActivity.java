package pl.edu.uwr.pum.parcelableexamplejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_KEY = "parcel_example";
    public static String EXTRA_SERIALIZABLE = "serializable_example";

    private Properties prop;
    private SerializableProperties serProp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.sendButton);

        prop = new Properties(1, 2, "String");
        serProp = new SerializableProperties(11, 12, "Serializable");

        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_KEY, prop);
            intent.putExtra(EXTRA_SERIALIZABLE, serProp);
            startActivity(intent);
        });
    }
}