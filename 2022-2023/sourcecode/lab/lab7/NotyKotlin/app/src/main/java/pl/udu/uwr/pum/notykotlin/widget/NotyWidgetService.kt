package pl.udu.uwr.pum.notykotlin.widget

import android.content.Intent
import android.widget.RemoteViewsService

class NotyWidgetService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return NotyWidgetItemFactory(applicationContext, intent)
    }
}