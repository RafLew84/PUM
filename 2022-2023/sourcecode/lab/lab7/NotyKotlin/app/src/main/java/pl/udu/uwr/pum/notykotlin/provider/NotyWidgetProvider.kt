package pl.udu.uwr.pum.notykotlin.provider

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import pl.udu.uwr.pum.notykotlin.R
import pl.udu.uwr.pum.notykotlin.service.NotyWidgetService

class NotyWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            val serviceIntent = Intent(context, NotyWidgetService::class.java)
            serviceIntent.apply {
                putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
                data = Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME))
            }
            val views = RemoteViews(context.packageName, R.layout.noty_widget_provider)
            views.apply {
                setRemoteAdapter(R.id.listViewWidget, serviceIntent)
                setEmptyView(R.id.listViewWidget, R.id.emptyViewTextView)
            }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }
}