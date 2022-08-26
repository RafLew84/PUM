package pl.udu.uwr.pum.notyjava.provider;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import pl.udu.uwr.pum.notyjava.R;
import pl.udu.uwr.pum.notyjava.service.NotyWidgetService;


public class NotyWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {

            Intent serviceIntent = new Intent(context, NotyWidgetService.class);
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME)));

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.noty_widget_provider);
            views.setRemoteAdapter(R.id.listViewWidget, serviceIntent);
            views.setEmptyView(R.id.listViewWidget, R.id.emptyViewTextView);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}