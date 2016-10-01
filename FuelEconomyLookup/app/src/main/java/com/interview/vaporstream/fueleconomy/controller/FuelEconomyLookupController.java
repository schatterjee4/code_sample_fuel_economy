package com.interview.vaporstream.fueleconomy.controller;

import com.interview.vaporstream.fueleconomy.http.FuelEconomyGovWebReference;

/**
 * Created by mperkins on 9/30/16.
 */

public class FuelEconomyLookupController extends BaseController {

	private static FuelEconomyLookupController sharedInstance;
	public static FuelEconomyLookupController getSharedInstance() {
		synchronized (FuelEconomyGovWebReference.class) {
			if(sharedInstance == null){
				sharedInstance = new FuelEconomyLookupController();
			}

			return sharedInstance;
		}
	}

	@Override
	public void init () {

	}

	@Override
	public void destroy () {
		sharedInstance = null;
	}

}
