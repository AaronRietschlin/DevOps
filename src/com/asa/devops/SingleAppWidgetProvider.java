package com.asa.devops;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.RemoteViews;

public class SingleAppWidgetProvider extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		final int appWidgetIdCount = appWidgetIds.length;

		for (int i = 0; i < appWidgetIdCount; i++) {
			int appWidgetId = appWidgetIds[i];

			Intent launchIntent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
			launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, launchIntent, 0);

			RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_single);
			views.setCharSequence(R.id.widget_single_btn, "setText", "TEST");
			views.setOnClickPendingIntent(R.id.widget_single_btn, pendingIntent);
			
			appWidgetManager.updateAppWidget(appWidgetId, views);
		}
	}

}
