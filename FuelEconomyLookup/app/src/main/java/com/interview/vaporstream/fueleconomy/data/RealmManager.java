package com.interview.vaporstream.fueleconomy.data;

/**
 * Created by mperkins on 9/30/16.
 */

public class RealmManager {

	private static LocalVehicleManager localVehicleManager;
	private static PreferencesManager localPreferenceManager;

	public static LocalVehicleManager getLocalVehicleManager () {
		synchronized (LocalVehicleManager.class) {
			if (localVehicleManager == null) {
				localVehicleManager = new LocalVehicleManager();
			}

			return localVehicleManager;
		}
	}

	public static PreferencesManager getLocalPreferenceManager () {
		synchronized (PreferencesManager.class) {
			if (localPreferenceManager == null) {
				localPreferenceManager = new PreferencesManager();
			}

			return localPreferenceManager;
		}
	}

}
