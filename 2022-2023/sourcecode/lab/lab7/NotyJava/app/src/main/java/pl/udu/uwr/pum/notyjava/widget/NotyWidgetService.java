package pl.udu.uwr.pum.notyjava.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class NotyWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new NotyWidgetItemFactory(getApplicationContext(), intent);
    }
}
