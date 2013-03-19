package com.asa.devops;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;

/**
 * Common methods that are used.
 */
public class Utils {
	
	
	public static boolean goToDevelopmentSettings(Context context){
		Intent intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
		if(!isIntentAvailable(context, intent)){
			return false;
		}
		context.startActivity(intent);
		return true;
	}
	

	/**
	 * Checks if the given Intent can be used on the users device.
	 * 
	 * @param context
	 * @param intent
	 * @return {@code true} if the Intent can be fired, {@code false} otherwise.
	 */
	public static boolean isIntentAvailable(Context context, Intent intent) {
		PackageManager mgr = context.getPackageManager();
		List<ResolveInfo> list = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
	}

	/**
	 * This method convets dp unit to equivalent device specific value in
	 * pixels.
	 * 
	 * @param dp
	 *            A value in dp(Device independent pixels) unit. Which we need
	 *            to convert into pixels
	 * @param context
	 *            Context to get resources and device specific display metrics
	 * @return A float value to represent Pixels equivalent to dp according to
	 *         device
	 */
	public static float convertDpToPixel(float dp, Context context) {
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float px = dp * (metrics.densityDpi / 160f);
		return px;
	}

	/**
	 * This method converts device specific pixels to device independent pixels.
	 * 
	 * @param px
	 *            A value in px (pixels) unit. Which we need to convert into db
	 * @param context
	 *            Context to get resources and device specific display metrics
	 * @return A float value to represent db equivalent to px value
	 */
	public static float convertPixelsToDp(float px, Context context) {
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float dp = px / (metrics.densityDpi / 160f);
		return dp;
	}

	// BEGIN ANDROID VERSION CHECKING
	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 2.3 (API 9).
	 */
	public static boolean isGingerBreadOrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
	}

	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 2.3.3 (API 10).
	 */
	public static boolean isGingerBreaMr1dOrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1;
	}

	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 3.0 (API 11).
	 */
	public static boolean isHoneycombOrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	}

	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 3.1 (API 12).
	 */
	public static boolean isHoneycombMr1OrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
	}

	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 3.2 (API 13).
	 */
	public static boolean isHoneycombMr2OrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2;
	}

	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 4.0 (API 14).
	 */
	public static boolean isIcsOrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
	}

	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 4.0.3 (API 15).
	 */
	public static boolean isIcsMr1OrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
	}

	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 4.1 (API 16).
	 */
	public static boolean isJellyBeanOrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
	}

	/**
	 * Determines if the device has a version of android that is greater than
	 * Android 4.2 (API 17).
	 */
	public static boolean isJellyBeanMr1OrGreater() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
	}
	// END ANDROID VERSION CHECKING

}
