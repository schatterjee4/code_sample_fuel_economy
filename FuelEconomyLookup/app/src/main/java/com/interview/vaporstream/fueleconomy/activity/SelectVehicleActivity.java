package com.interview.vaporstream.fueleconomy.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.interview.vaporstream.fueleconomy.R;
import com.interview.vaporstream.fueleconomy.databinding.ActivitySelectVehicleBinding;
import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

/**
 * Created by mperkins on 9/28/16.
 */

public class SelectVehicleActivity extends FuelEconomyBaseActivity {


	public static Intent getSelectVehicleActivityIntent(Context context) {
		Intent intent = new Intent(context, SelectVehicleActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return intent;
	}

	private ActivitySelectVehicleBinding binding;

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
	protected int LAYOUT_RESOURCE_ID () {
		return R.layout.activity_select_vehicle;
	}

	@Override
	protected void setLayout () {
		binding = DataBindingUtil.setContentView(this, LAYOUT_RESOURCE_ID());
		binding.setController(getController());
	}

	@Override
	protected void findControls () {
		binding.
	}

	@Override
	protected void setControlCallbacks () {

	}

	@Override
	protected void handleInternetAvailabilityChange (NetworkAvailabilityChangeEvent event) {

	}

	@Override
	protected void handleAppBackgroundStatusChange (BackgroundStatusChangeEvent event) {

	}
}
