package com.asa.devops.appwidget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RemoteViews;

import com.asa.devops.R;

public class SingleWidgetConfigActivity extends Activity {

	private int mAppWidgetId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_widget_config_activity);

		// FIrst, get the App Widget Id
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			mAppWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
		}

		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getApplicationContext());

		RemoteViews views = new RemoteViews(getPackageName(), R.layout.widget_single);
		appWidgetManager.updateAppWidget(mAppWidgetId, views);
		
		View v = LayoutInflater.from(this).inflate(R.layout.widget_single, null);
		v.postDelayed(new Runnable() {
			@Override
			public void run() {

				createReturnIntent();
				finish();
			}
		}, 3000);
	}

	private void createReturnIntent() {
		Intent returnIntent = new Intent();
		returnIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
		setResult(Activity.RESULT_OK, returnIntent);
	}

}
