package pl.udu.uwr.pum.notykotlin.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import pl.udu.uwr.pum.notykotlin.R
import pl.udu.uwr.pum.notykotlin.data.DataProvider

const val ACTION_DONE = "actionDone"

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

            val clickIntent = Intent(context, NotyWidgetProvider::class.java)
            clickIntent.action = ACTION_DONE

            val clickPendingIntent = PendingIntent.getBroadcast(
                context, 0, clickIntent,
                PendingIntent.FLAG_MUTABLE
            )
            val idArray = intArrayOf(appWidgetId)
            val intentUpdate = Intent(context, NotyWidgetProvider::class.java)
            intentUpdate.apply {
                action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
                putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray)
            }

            val pendingUpdate = PendingIntent.getBroadcast(
                context, appWidgetId, intentUpdate,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
            )

            val views = RemoteViews(context.packageName, R.layout.noty_widget_provider)
            views.apply {
                setRemoteAdapter(R.id.listViewWidget, serviceIntent)
                setEmptyView(R.id.listViewWidget, R.id.emptyViewTextView)
                setPendingIntentTemplate(R.id.listViewWidget, clickPendingIntent)
                setOnClickPendingIntent(R.id.refreshButtonWidget, pendingUpdate)
            }
            appWidgetManager.updateAppWidget(appWidgetId, views)
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.listViewWidget)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    override fun onReceive(context: Context?, intent: Intent) {
        if (ACTION_DONE == intent.action) {
            val appWidgetId = intent.getIntExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
            val position = intent.getIntExtra("position", 100)
            val appWidgetManager = AppWidgetManager.getInstance(context)
            DataProvider.dummyData[position] = "zmiana"
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.listViewWidget)
        }
        super.onReceive(context, intent)
    }
}