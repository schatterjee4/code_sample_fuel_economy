package com.interview.vaporstream.fueleconomy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

import org.greenrobot.eventbus.EventBus;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmConfiguration.Builder;

/**
 * Created by mperkins on 9/28/16.
 */

public class FuelEconomyApplication extends Application implements Application.ActivityLifecycleCallbacks {

	private static final long BACKGROUND_DETECTION_INTERVAL = 1000;
	private static FuelEconomyApplication sharedInstance;
	private boolean isAnActivityVisible = false;
	private boolean isAppInBackground = false;
	private boolean networkAvailable = true;

	private Handler handler;

	public FuelEconomyApplication () {
		handler = new Handler();
	}

	public static FuelEconomyApplication getSharedInstance () {
		synchronized (FuelEconomyApplication.class) {
			return sharedInstance;
		}
	}

	public boolean isApplicationInBackground () {
		return isAppInBackground;
	}
	public boolean isNetworkAvailable() {return networkAvailable; }

	@Override
	public void onCreate () {
		super.onCreate();
		sharedInstance = this;
		registerActivityLifecycleCallbacks(this);
		configureRealm();
		checkForNetworkAvailability();
	}

	private void configureRealm () {
		RealmConfiguration realmConfig = new Builder(getApplicationContext()).deleteRealmIfMigrationNeeded().build();
		Realm.setDefaultConfiguration(realmConfig);
	}

	@Override
	public void onTerminate () {
		super.onTerminate();
	}

	@Override
	public void onActivityCreated (Activity activity, Bundle savedInstanceState) {
	}

	@Override
	public void onActivityStarted (Activity activity) {

	}

	@Override
	public void onActivityResumed (Activity activity) {
		isAnActivityVisible = true;
		if (isAppInBackground) {
			isAppInBackground = false;
			notifyAppOfBackgroundChangeEvent();
		}

	}

	@Override
	public void onActivityPaused (Activity activity) {
		isAnActivityVisible = false;
		handler.postDelayed(new Runnable() {
			@Override
			public void run () {
				detectAppBackgrounding();
			}
		}, BACKGROUND_DETECTION_INTERVAL);
	}

	@Override
	public void onActivityStopped (Activity activity) {

	}

	@Override
	public void onActivitySaveInstanceState (Activity activity, Bundle outState) {

	}

	@Override
	public void onActivityDestroyed (Activity activity) {

	}

	private void detectAppBackgrounding () {
		if (! isAnActivityVisible) {
			if (! isAppInBackground) {
				isAppInBackground = true;
				notifyAppOfBackgroundChangeEvent();
			}
		}
	}

	private void notifyAppOfBackgroundChangeEvent () {
		EventBus.getDefault().post(new BackgroundStatusChangeEvent(isAppInBackground));
	}

	public void checkForNetworkAvailability() {
		try {
			ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

			NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
			boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

			if(isConnected != networkAvailable) {
				networkAvailable = isConnected;
				EventBus.getDefault().post(new NetworkAvailabilityChangeEvent(isConnected));
			}
		} catch(Exception e) {
			Log.e("NETWORK", Log.getStackTraceString(e));
		}
	}
}
