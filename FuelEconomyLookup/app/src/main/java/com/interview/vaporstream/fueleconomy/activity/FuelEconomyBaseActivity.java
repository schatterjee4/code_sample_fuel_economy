package com.interview.vaporstream.fueleconomy.activity;

import com.interview.vaporstream.fueleconomy.controller.FuelEconomyLookupController;

/**
 * Created by mperkins on 9/30/16.
 */

public abstract class FuelEconomyBaseActivity extends BaseActivity {

	private FuelEconomyLookupController controllerReference;
	public FuelEconomyLookupController getController () {
		if(controllerReference == null) {
			controllerReference = FuelEconomyLookupController.getSharedInstance();
		}
		return controllerReference;
	}
}
