package com.interview.fueleconomy.data;

/**
 * Created by mperkins on 9/30/16.
 */

public class RealmManager {

	private static LocalVehicleManager localVehicleManager;

	public static LocalVehicleManager getLocalVehicleManager () {
		synchronized (LocalVehicleManager.class) {
			if (localVehicleManager == null) {
				localVehicleManager = new LocalVehicleManager();
			}

			return localVehicleManager;
		}
	}
}
