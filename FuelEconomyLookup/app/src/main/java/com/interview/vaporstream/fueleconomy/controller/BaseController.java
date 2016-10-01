package com.interview.vaporstream.fueleconomy.controller;

import com.interview.vaporstream.fueleconomy.data.RealmManager;
import com.interview.vaporstream.fueleconomy.http.FuelEconomyGovWebReference;

/**
 * Created by mperkins on 9/30/16.
 */

public abstract class BaseController {

	public BaseController() {
		init();
	}

	public abstract void init();
	public abstract void destroy();

	private FuelEconomyGovWebReference webReference;
	private RealmManager dataReference;

	public FuelEconomyGovWebReference getWebReference () {
		if(webReference == null) {
			webReference = FuelEconomyGovWebReference.getSharedInstance();
		}
		return webReference;
	}
	public RealmManager getDataReference () {
		if(dataReference == null) {
			dataReference = new RealmManager();
		}
		return dataReference;
	}
}
