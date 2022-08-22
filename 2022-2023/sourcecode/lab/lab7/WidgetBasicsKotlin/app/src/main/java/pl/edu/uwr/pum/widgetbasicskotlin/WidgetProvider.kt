package pl.edu.uwr.pum.widgetbasicskotlin

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews


class WidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        for (appWidgetId in appWidgetIds!!) {
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )

            val preferences = context!!.getSharedPreferences(
                SHARED_PREFS, Context.MODE_PRIVATE)
            val text = preferences.getString(
                KEY_BUTTON_TEXT + appWidgetId, "Click me")

            val views = RemoteViews(
                context.packageName,
                R.layout.app_widget_layout
            )
            views.apply {
                setOnClickPendingIntent(R.id.widgetButton, pendingIntent)
                setCharSequence(R.id.widgetButton, "setText", text)
            }
            appWidgetManager!!.updateAppWidget(appWidgetId, views)
        }
    }
}