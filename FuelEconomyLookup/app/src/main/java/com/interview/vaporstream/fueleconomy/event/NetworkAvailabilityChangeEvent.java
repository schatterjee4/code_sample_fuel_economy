package com.interview.vaporstream.fueleconomy.event;

/**
 * Created by mperkins on 9/28/16.
 */

public class NetworkAvailabilityChangeEvent {

	private boolean networkAvailable;

	public NetworkAvailabilityChangeEvent (boolean networkAvailable) {
		this.networkAvailable = networkAvailable;
	}

	public boolean isNetworkAvailable () {
		return networkAvailable;
	}
}
