package com.interview.vaporstream.fueleconomy.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.interview.vaporstream.fueleconomy.R;
import com.interview.vaporstream.fueleconomy.databinding.ActivityVehicleInfoBinding;
import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.model.Vehicle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mperkins on 9/29/16.
 */

public class VehicleInfoActivity extends FuelEconomyBaseActivity {

	ActivityVehicleInfoBinding binding;

	private static final String EXTRA_ID_VEHICLE_ID = "vehicle_id";
	private Menu menu;

	public static Intent getVehicleInfoIntent (Context context, int vehicleId) {
		Intent intent = new Intent(context, VehicleInfoActivity.class);
		intent.putExtra(EXTRA_ID_VEHICLE_ID, vehicleId);
		return intent;
	}

	@Override
	protected int LAYOUT_RESOURCE_ID () {
		return R.layout.activity_vehicle_info;
	}

	@Override
	protected void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	protected void setLayout () {
		binding = DataBindingUtil.setContentView(this, LAYOUT_RESOURCE_ID());
		binding.setController(getController());
	}

	@Override
	protected void findControls () {
		progressLayout = binding.progressIndicator;
		progressText = binding.progressText;
		noConnectionLayout = binding.noConnectionLayout;
		loadData();
	}

	private void loadData () {
		updateProgressMessageAndShow(R.string.progress_loading_vehicle_info);
		getController().getVehicleInfoAsync(new Callback<Vehicle>() {
			@Override
			public void onResponse (Call<Vehicle> call, Response<Vehicle> response) {
				binding.setSelectedVehicle(response.body());
				binding.tvDrivetrainInfo.setText(response.body().getDispl() + "L " + response.body().getCylinders() + " cyl " + response.body().getTrany());
				stopProgress();
			}

			@Override
			public void onFailure (Call<Vehicle> call, Throwable t) {
				stopProgress();
				finish();
			}
		});
	}

	@Override
	protected void setControlCallbacks () {
	}

	@Override
	protected void onPause () {
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu (Menu menu) {
		this.menu = menu;
		updateMenu();
		return true;
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
	public void handleAppBackgroundStatusChange (BackgroundStatusChangeEvent event) {
	}

	@Override
	public boolean onOptionsItemSelected (android.view.MenuItem item) {
		switch(item.getItemId()){
			case android.R.id.home:
				finish();
				break;
			case R.id.save:
				getController().saveVehicle();
				updateMenu();
				Toast.makeText(this, "Vehicle saved!", Toast.LENGTH_LONG).show();
				break;
			case R.id.delete:
				promptForDelete();
				break;
			default:
				return super.onOptionsItemSelected(item);
		}

		return true;
	}

	private void promptForDelete () {
		createDialog(R.string.prompt_delete_vehicle_title, R.string.prompt_delete_vehicle_message,
				R.string.action_yes, R.string.action_no,
				new DialogInterface.OnClickListener(){
					@Override
					public void onClick (DialogInterface dialog, int which) {
						getController().deleteVehicle();
						Toast.makeText(VehicleInfoActivity.this, "Vehicle deleted.", Toast.LENGTH_LONG).show();
						updateMenu();
					}
				},
				new DialogInterface.OnClickListener(){

					@Override
					public void onClick (DialogInterface dialog, int which) {

					}
				});
	}

	private void updateMenu () {
		if(menu != null) {
			MenuInflater inflater = getMenuInflater();
			menu.clear();

			if (getController().isVehicleInInventory()) {
				inflater.inflate(R.menu.vehicle_info_menu_show_delete, menu);
			} else {
				inflater.inflate(R.menu.vehicle_info_menu_show_save, menu);
			}
		}
	}
}
