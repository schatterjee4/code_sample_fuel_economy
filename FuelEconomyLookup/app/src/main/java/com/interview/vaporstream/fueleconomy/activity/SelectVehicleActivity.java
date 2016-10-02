package com.interview.vaporstream.fueleconomy.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.interview.vaporstream.fueleconomy.R;
import com.interview.vaporstream.fueleconomy.databinding.ActivitySelectVehicleBinding;
import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.http.response.MenuItemsResponse;
import com.interview.vaporstream.fueleconomy.model.MenuItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by mperkins on 9/28/16.
 */

public class SelectVehicleActivity extends FuelEconomyBaseActivity {

	private ActivitySelectVehicleBinding binding;

	private static final String INTENT_FLAG_SAVE = "save";
	private boolean isSaveMode = false;

	public static Intent getSelectVehicleActivityIntent (Context context, boolean save) {
		Intent intent = new Intent(context, SelectVehicleActivity.class);
		intent.putExtra(INTENT_FLAG_SAVE, save);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return intent;
	}

	@Override
	protected void onCreate (@Nullable Bundle savedInstanceState) {
		if(getIntent().hasExtra(INTENT_FLAG_SAVE)) {
			isSaveMode = getIntent().getBooleanExtra(INTENT_FLAG_SAVE, false);
		}
		super.onCreate(savedInstanceState);
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	protected void onPause () {
		super.onPause();
	}

	@Override
	public boolean onOptionsItemSelected (android.view.MenuItem item) {
		switch(item.getItemId()){
			case android.R.id.home:
				finish();
				break;
			default:
				return super.onOptionsItemSelected(item);
		}

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
		progressLayout = binding.progressIndicator;
		progressText = binding.progressText;
		noConnectionLayout = binding.noConnectionLayout;

		if(isSaveMode) {
			binding.selectVehicleButtonSubmit.setText(R.string.activity_select_vehicle_save_button);
		} else {
			binding.selectVehicleButtonSubmit.setText(R.string.activity_select_vehicle_show);
		}
	}

	@Override
	protected void setControlCallbacks () {

		binding.selectYearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
				getController().setSelectedYear((MenuItem) binding.selectYearSpinner.getAdapter().getItem(position));
				binding.selectMakeSpinner.setAdapter(null);
				binding.selectModelSpinner.setAdapter(null);
				binding.selectVehicleSpinner.setAdapter(null);
				loadMakes(getController().getSelectedYear());
			}

			@Override
			public void onNothingSelected (AdapterView<?> parent) {

			}
		});

		binding.selectMakeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
				getController().setSelectedMake((MenuItem) binding.selectMakeSpinner.getAdapter().getItem(position));
				binding.selectModelSpinner.setAdapter(null);
				binding.selectVehicleSpinner.setAdapter(null);
				loadModels(getController().getSelectedYear(), getController().getSelectedMake());
			}

			@Override
			public void onNothingSelected (AdapterView<?> parent) {

			}
		});

		binding.selectModelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
				getController().setSelectedModel((MenuItem) binding.selectModelSpinner.getAdapter().getItem(position));
				binding.selectVehicleSpinner.setAdapter(null);
				loadVehicles(getController().getSelectedYear(), getController().getSelectedMake(), getController().getSelectedModel());
			}

			@Override
			public void onNothingSelected (AdapterView<?> parent) {

			}
		});

		binding.selectVehicleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
				getController().setSelectedVehicle((MenuItem) binding.selectVehicleSpinner.getAdapter().getItem(position));
			}

			@Override
			public void onNothingSelected (AdapterView<?> parent) {

			}
		});

		binding.selectVehicleButtonSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				if(getController().getSelectedVehicle() != null) {
					if(isSaveMode) {
						getController().saveVehicle();
					} else {
						getController().launchVehicleInformationScreen(SelectVehicleActivity.this);
					}
					finish();
				} else {
					// Show "Must select a vehicle" prompt
				}
			}
		});

		loadData();
	}

	private void loadData () {
		loadYears();
	}

	private void loadYears () {
		updateProgressMessageAndShow(R.string.progress_loading_data_years);

		getController().getAllModelYearsAsync(new Callback<MenuItemsResponse>() {
			@Override
			public void onResponse (Call<MenuItemsResponse> call, Response<MenuItemsResponse> response) {
				binding.selectYearSpinner.setAdapter(new ArrayAdapter<>(SelectVehicleActivity.this, android.R.layout.simple_spinner_dropdown_item, response.body().getMenuItemList()));
				stopProgress();
			}

			@Override
			public void onFailure (Call<MenuItemsResponse> call, Throwable t) {
				stopProgress();
			}
		});
	}

	private void loadMakes(String year) {
		if(year != null) {
			updateProgressMessageAndShow(R.string.progress_loading_data_makes);

			getController().getAllMakesAsync(year, new Callback<MenuItemsResponse>() {
				@Override
				public void onResponse (Call<MenuItemsResponse> call, Response<MenuItemsResponse> response) {
					binding.selectMakeSpinner.setAdapter(new ArrayAdapter<>(SelectVehicleActivity.this, android.R.layout.simple_spinner_dropdown_item, response.body().getMenuItemList()));
					stopProgress();
				}

				@Override
				public void onFailure (Call<MenuItemsResponse> call, Throwable t) {
					stopProgress();
				}
			});
		}
	}

	private void loadModels(String year, String make) {
		if(year != null && make != null) {
			updateProgressMessageAndShow(R.string.progress_loading_data_models);

			getController().getAllModelsAsync(year, make, new Callback<MenuItemsResponse>() {
				@Override
				public void onResponse (Call<MenuItemsResponse> call, Response<MenuItemsResponse> response) {
					binding.selectModelSpinner.setAdapter(new ArrayAdapter<>(SelectVehicleActivity.this, android.R.layout.simple_spinner_dropdown_item, response.body().getMenuItemList()));
					stopProgress();
				}

				@Override
				public void onFailure (Call<MenuItemsResponse> call, Throwable t) {
					stopProgress();
				}
			});
		}
	}

	private void loadVehicles(String year, String make, String model) {
		if(year != null && make != null && model != null) {
			updateProgressMessageAndShow(R.string.progress_loading_data_vehicles);

			getController().getAllVehiclesAsync(year, make, model, new Callback<MenuItemsResponse>() {
				@Override
				public void onResponse (Call<MenuItemsResponse> call, Response<MenuItemsResponse> response) {
					binding.selectVehicleSpinner.setAdapter(new ArrayAdapter<>(SelectVehicleActivity.this, android.R.layout.simple_spinner_dropdown_item, response.body().getMenuItemList()));
					stopProgress();
				}

				@Override
				public void onFailure (Call<MenuItemsResponse> call, Throwable t) {
					stopProgress();
				}
			});
		}
	}

	@Override
	public void handleAppBackgroundStatusChange (BackgroundStatusChangeEvent event) {
		finish();
	}
}
