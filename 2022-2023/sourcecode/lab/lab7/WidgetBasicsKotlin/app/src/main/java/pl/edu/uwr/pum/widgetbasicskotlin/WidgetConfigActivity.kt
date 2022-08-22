package pl.edu.uwr.pum.widgetbasicskotlin

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import pl.edu.uwr.pum.widgetbasicskotlin.databinding.ActivityWidgetConfigBinding

const val SHARED_PREFS = "shared_prefs"
const val KEY_BUTTON_TEXT = "keyButton"

class WidgetConfigActivity : AppCompatActivity() {

    private val binding by lazy { ActivityWidgetConfigBinding.inflate(layoutInflater) }
    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val extras = intent.extras

        if (extras != null) {
            appWidgetId = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }

        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) finish()

        binding.widgetConfigButton.setOnClickListener {
            val appWidgetManager = AppWidgetManager.getInstance(this)
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )
            val text = binding.widgetConfigEditText.text.toString()
            if (text.isNotEmpty()) {
                val views = RemoteViews(
                    this@WidgetConfigActivity.packageName,
                    R.layout.app_widget_layout
                ).apply {
                    setOnClickPendingIntent(R.id.widgetButton, pendingIntent)
                    setCharSequence(R.id.widgetButton, "setText", text)
                }

                appWidgetManager.updateAppWidget(appWidgetId, views)
                val sharedPreferences = getSharedPreferences(
                    SHARED_PREFS, MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.apply {
                    putString(KEY_BUTTON_TEXT + appWidgetId, text)
                    apply() }
                val resultIntent = Intent()
                resultIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}