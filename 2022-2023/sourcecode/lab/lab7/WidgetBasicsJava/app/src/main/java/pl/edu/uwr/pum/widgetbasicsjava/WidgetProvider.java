package pl.edu.uwr.pum.widgetbasicsjava;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int appWidgetId : appWidgetIds){
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    context,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE);

            SharedPreferences preferences = context.getSharedPreferences(WidgetConfigActivity.SHARED_PREFS, Context.MODE_PRIVATE);
            String text = preferences.getString(WidgetConfigActivity.KEY_BUTTON_TEXT + appWidgetId, "Click me");

            RemoteViews views =
                    new RemoteViews(
                            context.getPackageName(),
                            R.layout.app_widget_layout);

            views.setOnClickPendingIntent(R.id.widgetButton, pendingIntent);
            views.setCharSequence(R.id.widgetButton, "setText", text);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
