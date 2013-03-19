package com.asa.devops;

import android.content.Intent;
import android.provider.Settings;

import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

/**
 * The DashClock extension.
 */
public class DevOpsDashClockExtension extends DashClockExtension {

	@Override
	protected void onUpdateData(int reason) {
		// Set up the click intent that will take you to the Dev settings
		Intent clickIntent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);

		// Set up the DashClock extensions data.
		ExtensionData extensionData = new ExtensionData();
		extensionData.visible(true).status(getString(R.string.dashclock_extension_status)).icon(R.drawable.ic_launcher);
		extensionData.expandedTitle(getString(R.string.dashclock_extension_expanded_title));
		extensionData.expandedBody(getString(R.string.dashclock_extension_expanded_body)).clickIntent(clickIntent);
		publishUpdate(extensionData);
	}

}
