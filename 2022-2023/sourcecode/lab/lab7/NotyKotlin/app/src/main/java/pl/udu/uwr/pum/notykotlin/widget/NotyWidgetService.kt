package pl.udu.uwr.pum.notykotlin.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import pl.udu.uwr.pum.notykotlin.R
import pl.udu.uwr.pum.notykotlin.data.DataProvider

class NotyWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return NotyWidgetItemFactory(applicationContext, intent)
    }

    class NotyWidgetItemFactory(private val context: Context, intent: Intent) :
        RemoteViewsFactory {
        private val appWidgetId: Int
        private lateinit var noteList: List<String>
        override fun onCreate() {
            // otworz baze danych
            noteList = DataProvider.dummyData
        }

        override fun onDataSetChanged() {
            DataProvider.dummyData.add("Nowa notatka " + (DataProvider.dummyData.size + 1))
        }

        override fun onDestroy() {
            // zamknac polaczenie z baza
        }

        override fun getCount(): Int = noteList.size

        override fun getViewAt(position: Int): RemoteViews {
            val remoteViews = RemoteViews(context.packageName, R.layout.item_list)
            remoteViews.setTextViewText(R.id.itemListTextView, noteList[position])

            val fillIntent = Intent()
            fillIntent.apply {
                putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
                putExtra("position", position)
            }
            remoteViews.setOnClickFillInIntent(R.id.itemListTextView, fillIntent)

            return remoteViews
        }

        override fun getLoadingView(): RemoteViews? {
            return null
        }

        override fun getViewTypeCount(): Int = 1

        override fun getItemId(position: Int): Long = position.toLong() // identyfikacja

        override fun hasStableIds(): Boolean = true

        init {
            appWidgetId = intent.getIntExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }
    }
}