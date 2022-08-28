package pl.udu.uwr.pum.notykotlin.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import pl.udu.uwr.pum.notykotlin.R
import pl.udu.uwr.pum.notykotlin.db.DBHandler
import pl.udu.uwr.pum.notykotlin.model.NoteModel

class NotyWidgetItemFactory(private val context: Context, intent: Intent) :
    RemoteViewsService.RemoteViewsFactory {
    private lateinit var dbHandler: DBHandler
    private val appWidgetId: Int
    private lateinit var noteList: List<NoteModel>

    override fun onCreate() {
        dbHandler = DBHandler(context)
        noteList = dbHandler.notes
    }

    override fun onDataSetChanged() {
        noteList = dbHandler.notes
    }

    override fun onDestroy() {
        dbHandler.close()
    }

    override fun getCount(): Int = noteList.size

    override fun getViewAt(position: Int): RemoteViews {
        val remoteViews = RemoteViews(context.packageName, R.layout.item_list)
        remoteViews.setTextViewText(
            R.id.itemListTextView, noteList[position].time.toString() + "\n" + noteList[position].textNote
        )
        remoteViews.setTextColor(R.id.itemListTextView, noteList[position].color)

        val fillIntent = Intent()
        fillIntent.apply {
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            putExtra("id", noteList[position].id)
        }
        remoteViews.setOnClickFillInIntent(R.id.itemListTextView, fillIntent)
        return remoteViews
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int = 1

    override fun getItemId(position: Int): Long = noteList[position].id.toLong()

    override fun hasStableIds(): Boolean = true

    init {
        appWidgetId = intent.getIntExtra(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        )
    }
}