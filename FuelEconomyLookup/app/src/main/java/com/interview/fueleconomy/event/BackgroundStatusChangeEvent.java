package com.interview.fueleconomy.event;

/**
 * Created by mperkins on 9/28/16.
 */

public class BackgroundStatusChangeEvent {

	private boolean appInBackground;

	public BackgroundStatusChangeEvent (boolean isAppInBackground) {
		this.appInBackground = isAppInBackground;
	}

	public boolean isAppInBackground () {
		return appInBackground;
	}
}
