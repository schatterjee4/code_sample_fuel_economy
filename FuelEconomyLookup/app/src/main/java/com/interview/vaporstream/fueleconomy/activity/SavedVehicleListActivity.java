package com.interview.vaporstream.fueleconomy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.interview.vaporstream.fueleconomy.FuelEconomyApplication;
import com.interview.vaporstream.fueleconomy.databinding.ActivitySavedVehiclesBinding;
import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.R;
import com.interview.vaporstream.fueleconomy.model.LocalVehicleRecord;

import java.util.List;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by mperkins on 9/29/16.
 */

public class SavedVehicleListActivity extends FuelEconomyBaseActivity {

	ActivitySavedVehiclesBinding binding;


	@Override
	protected int LAYOUT_RESOURCE_ID () {
		return R.layout.activity_saved_vehicles;
	}

	@Override
	protected void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void setLayout () {
		binding = DataBindingUtil.setContentView(this, LAYOUT_RESOURCE_ID());
		binding.setController(getController());
		setTitle(R.string.activity_saved_vehicle_list_title);
	}

	@Override
	protected void findControls () {
		progressLayout = binding.progressIndicator;
		progressText = binding.progressText;
		noConnectionLayout = binding.noConnectionLayout;

		binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				getController().launchAddVehicle(SavedVehicleListActivity.this);
			}
		});

		binding.savedVehicleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
			if(FuelEconomyApplication.getSharedInstance().isNetworkAvailable()) {
				getController().setSelectedVehicle((LocalVehicleRecord) binding.savedVehicleList.getAdapter().getItem(position));
				getController().launchVehicleInformationScreen(SavedVehicleListActivity.this);
			} else {
				Toast.makeText(SavedVehicleListActivity.this, "Can't load this information at this time.  Please establish an internet connection and try again.", Toast.LENGTH_LONG).show();
			}
			}
		});

		loadData();
	}

	private void loadData () {

		binding.savedVehicleList.setAdapter(new ArrayAdapter<>(SavedVehicleListActivity.this
				, android.R.layout.simple_list_item_1
				, getController().getDataReference().getAllVehicles(null, null)));

	}

	@Override
	public boolean onCreateOptionsMenu (Menu menu) {
		MenuInflater inflater = getMenuInflater();
		menu.clear();
		inflater.inflate(R.menu.menu_saved_menu_search, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected (android.view.MenuItem item) {
		switch (item.getItemId()) {
			case R.id.search:
				getController().launchSearchForVehicle(this);
				break;
			case android.R.id.home:
				finish();
				break;
		}

		return true;
	}

	@Override
	protected void setControlCallbacks () {

	}

	@Override
	protected void onPause () {
		super.onPause();
	}

	@Override
	protected void onResume () {
		super.onResume();
		loadData();
	}

	@Override
	public void finish () {
		super.finish();
	}

	@Override
	public void handleAppBackgroundStatusChange (BackgroundStatusChangeEvent event) {

	}
}
