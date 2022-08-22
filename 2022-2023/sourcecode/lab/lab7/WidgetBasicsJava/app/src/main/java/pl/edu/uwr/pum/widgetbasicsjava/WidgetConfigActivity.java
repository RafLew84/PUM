package pl.edu.uwr.pum.widgetbasicsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RemoteViews;

import pl.edu.uwr.pum.widgetbasicsjava.databinding.ActivityWidgetConfigBinding;

public class WidgetConfigActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    public static final String KEY_BUTTON_TEXT = "keyButton";

    private int appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    private ActivityWidgetConfigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWidgetConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent configIntent = getIntent();
        Bundle extras = configIntent.getExtras();

        if (extras != null){
            appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID)
            finish();

        binding.widgetConfigButton.setOnClickListener(v -> {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE);

            String text = binding.widgetConfigEditText.getText().toString();
            if (!text.isEmpty()){
                RemoteViews views = new RemoteViews(
                        WidgetConfigActivity.this.getPackageName(),
                        R.layout.app_widget_layout
                );

                views.setOnClickPendingIntent(R.id.widgetButton, pendingIntent);
                views.setCharSequence(R.id.widgetButton, "setText", text);

                appWidgetManager.updateAppWidget(appWidgetId, views);
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_BUTTON_TEXT + appWidgetId, text);
                editor.apply();

                Intent resultIntent = new Intent();
                resultIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}