package com.interview.vaporstream.fueleconomy.activity;

import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

/**
 * Created by mperkins on 9/30/16.
 */

public class LauncherActivity extends BaseActivity{

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
	protected void handleInternetAvailabilityChange (NetworkAvailabilityChangeEvent event) {

	}

	@Override
	protected void handleAppBackgroundStatusChange (BackgroundStatusChangeEvent event) {

	}
}
