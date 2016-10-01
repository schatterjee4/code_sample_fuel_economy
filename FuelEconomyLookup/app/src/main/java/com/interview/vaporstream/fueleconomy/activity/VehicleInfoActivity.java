package com.interview.vaporstream.fueleconomy.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

/**
 * Created by mperkins on 9/29/16.
 */

public class VehicleInfoActivity extends FuelEconomyBaseActivity{

	private static final String EXTRA_ID_VEHICLE_ID = "vehicle_id";

	public static Intent getVehicleInfoIntent(Context context, int vehicleId) {
		Intent intent = new Intent(context, VehicleInfoActivity.class);
		intent.putExtra(EXTRA_ID_VEHICLE_ID, vehicleId);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return intent;
	}


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
	protected void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onPause () {
		super.onPause();
	}

	@Override
	protected void onResume () {
		super.onResume();
	}

	@Override
	public void finish () {
		super.finish();
	}

	@Override
	protected void handleInternetAvailabilityChange (NetworkAvailabilityChangeEvent event) {

	}

	@Override
	protected void handleAppBackgroundStatusChange (BackgroundStatusChangeEvent event) {

	}

}
