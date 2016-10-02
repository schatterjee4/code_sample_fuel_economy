package com.interview.vaporstream.fueleconomy.controller;

import com.interview.vaporstream.fueleconomy.data.LocalVehicleManager;
import com.interview.vaporstream.fueleconomy.data.PreferencesManager;
import com.interview.vaporstream.fueleconomy.data.RealmManager;
import com.interview.vaporstream.fueleconomy.http.FuelEconomyGovWebReference;
import com.interview.vaporstream.fueleconomy.model.LocalVehicleRecord;

/**
 * Created by mperkins on 9/30/16.
 */

public abstract class BaseController {

	private FuelEconomyGovWebReference webReference;
	private PreferencesManager prefReference;
	private LocalVehicleManager dataReference;

	public BaseController () {
		init();
	}

	public abstract void init ();

	public abstract void destroy ();

	public FuelEconomyGovWebReference getWebReference () {
		if (webReference == null) {
			webReference = FuelEconomyGovWebReference.getSharedInstance();
		}
		return webReference;
	}

	public PreferencesManager getPreferencesReference () {
		return RealmManager.getLocalPreferenceManager();
	}

	public LocalVehicleManager getDataReference() {
		return RealmManager.getLocalVehicleManager();
	}
}
