package com.interview.fueleconomy.controller;

import com.interview.fueleconomy.data.LocalVehicleManager;
import com.interview.fueleconomy.data.RealmManager;
import com.interview.fueleconomy.http.FuelEconomyGovWebReference;

/**
 * Created by mperkins on 9/30/16.
 */

public abstract class BaseController {

	private FuelEconomyGovWebReference webReference;
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

	public LocalVehicleManager getDataReference() {
		return RealmManager.getLocalVehicleManager();
	}
}
