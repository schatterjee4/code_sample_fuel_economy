package com.interview.vaporstream.fueleconomy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

/**
 * Created by mperkins on 9/29/16.
 */

public class SplashActivity extends BaseActivity{

	@Override
	protected int LAYOUT_RESOURCE_ID () {
		return 0;
	}

	@Override
	protected void setLayout () {

	}

	@Override
	protected void findControls () {

	}

	@Override
	protected void setControlCallbacks () {

	}

	@Override
	protected void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onPause () {
		super.onPause();
	}

	@Override
	protected void onResume () {
		super.onResume();
	}

	@Override
	public void finish () {
		super.finish();
	}

	@Override
	protected void handleInternetAvailabilityChange (NetworkAvailabilityChangeEvent event) {

	}

	@Override
	protected void handleAppBackgroundStatusChange (BackgroundStatusChangeEvent event) {

	}
}
