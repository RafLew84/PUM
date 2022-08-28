package pl.udu.uwr.pum.notyjava.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.StrikethroughSpan;
import android.widget.RemoteViews;

import pl.udu.uwr.pum.notyjava.R;
import pl.udu.uwr.pum.notyjava.data.DataProvider;


public class NotyWidgetProvider extends AppWidgetProvider {

    public static final String ACTION_DONE = "actionDone";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {

            Intent serviceIntent = new Intent(context, NotyWidgetService.class);
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME)));

            Intent clickIntent = new Intent(context, NotyWidgetProvider.class);
            clickIntent.setAction(ACTION_DONE);
            PendingIntent clickPendingIntent = PendingIntent.getBroadcast(
                    context, 0, clickIntent,
                    PendingIntent.FLAG_MUTABLE);

            Intent intentUpdate = new Intent(context, NotyWidgetProvider.class);
            intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

            int[] idArray = new int[]{appWidgetId};
            intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);

            PendingIntent pendingUpdate = PendingIntent.getBroadcast(
                    context, appWidgetId, intentUpdate,
                    PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.noty_widget_provider);
            views.setRemoteAdapter(R.id.listViewWidget, serviceIntent);
            views.setEmptyView(R.id.listViewWidget, R.id.emptyViewTextView);
            views.setPendingIntentTemplate(R.id.listViewWidget, clickPendingIntent);
            views.setOnClickPendingIntent(R.id.refreshButtonWidget, pendingUpdate);

            appWidgetManager.updateAppWidget(appWidgetId, views);
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.listViewWidget);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_DONE.equals(intent.getAction())){
            int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
            int position = intent.getIntExtra("position", 100);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            DataProvider.dummyData.set(position, "zmiana");

            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.listViewWidget);
        }
        super.onReceive(context, intent);
    }
}