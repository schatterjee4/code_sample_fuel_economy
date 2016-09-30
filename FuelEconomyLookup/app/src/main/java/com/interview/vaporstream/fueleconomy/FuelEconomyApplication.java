package com.interview.vaporstream.fueleconomy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mperkins on 9/28/16.
 */

public class FuelEconomyApplication extends Application implements Application.ActivityLifecycleCallbacks{

	private static final long BACKGROUND_DETECTION_INTERVAL = 1000;
	private static FuelEconomyApplication sharedInstance;
	public static FuelEconomyApplication getSharedInstance() {
		synchronized (FuelEconomyApplication.class) {
			return sharedInstance;
		}
	}

	private boolean isAnActivityVisible = false;
	private boolean isAppInBackground = false;

	private Handler handler;

	public FuelEconomyApplication () {
		handler = new Handler();
	}

	public boolean isApplicationInBackground() {
		return isAppInBackground;
	}

	@Override
	public void onCreate () {
		super.onCreate();
		sharedInstance = this;
		registerActivityLifecycleCallbacks(this);
	}

	@Override
	public void onTerminate () {
		super.onTerminate();
		sharedInstance = null;
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
		if(isAppInBackground) {
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

	private void detectAppBackgrounding() {
		if(!isAnActivityVisible){
			if(!isAppInBackground) {
				isAppInBackground = true;
				notifyAppOfBackgroundChangeEvent();
			}
		}
	}

	private void notifyAppOfBackgroundChangeEvent() {
		EventBus.getDefault().post(new BackgroundStatusChangeEvent(isAppInBackground));
	}
}
