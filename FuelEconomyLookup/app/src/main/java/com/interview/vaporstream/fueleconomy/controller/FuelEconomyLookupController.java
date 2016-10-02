package com.interview.vaporstream.fueleconomy.controller;

import android.app.Activity;
import android.content.Intent;

import com.interview.vaporstream.fueleconomy.activity.SelectVehicleActivity;
import com.interview.vaporstream.fueleconomy.activity.VehicleInfoActivity;
import com.interview.vaporstream.fueleconomy.http.FuelEconomyGovWebReference;
import com.interview.vaporstream.fueleconomy.http.response.MenuItemsResponse;
import com.interview.vaporstream.fueleconomy.model.LocalVehicleRecord;
import com.interview.vaporstream.fueleconomy.model.MenuItem;
import com.interview.vaporstream.fueleconomy.model.Vehicle;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by mperkins on 9/30/16.
 */

public class FuelEconomyLookupController extends BaseController {

	private static FuelEconomyLookupController sharedInstance;

	public static FuelEconomyLookupController getSharedInstance () {
		synchronized (FuelEconomyGovWebReference.class) {
			if (sharedInstance == null) {
				sharedInstance = new FuelEconomyLookupController();
			}

			return sharedInstance;
		}
	}

	private String selectedYear;
	private String selectedMake;
	private String selectedModel;
	private String selectedVehicle;

	public void getAllModelYearsAsync(Callback<MenuItemsResponse> callback) {
		Call<MenuItemsResponse> call = getWebReference().getVehicleEndpoint().getListOfModelYears().clone();
		call.enqueue(callback);
	}
	public void getAllMakesAsync(String year, Callback<MenuItemsResponse> callback) {
		Call<MenuItemsResponse> call = getWebReference().getVehicleEndpoint().getListOfMakes(year).clone();
		call.enqueue(callback);
	}
	public void getAllModelsAsync(String year, String make, Callback<MenuItemsResponse> callback){
		Call<MenuItemsResponse> call = getWebReference().getVehicleEndpoint().getListOfModels(year, make).clone();
		call.enqueue(callback);
	}
	public void getAllVehiclesAsync(String year, String make, String model, Callback<MenuItemsResponse> callback){
		Call<MenuItemsResponse> call = getWebReference().getVehicleEndpoint().getListOfVehicleOptions(year, make, model).clone();
		call.enqueue(callback);
	}
	public void getVehicleInfoAsync(Callback<Vehicle> callback) {
		Call<Vehicle> call = getWebReference().getVehicleEndpoint().getVehicleById(Integer.valueOf(selectedVehicle)).clone();
		call.enqueue(callback);
	}
	public void launchVehicleInformationScreen(Activity activity) {
		Intent intent = VehicleInfoActivity.getVehicleInfoIntent(activity, Integer.valueOf(selectedVehicle));
		activity.startActivity(intent);
	}
	public void launchAddVehicle(Activity activity) {
		Intent intent = SelectVehicleActivity.getSelectVehicleActivityIntent(activity, true);
		activity.startActivity(intent);
	}
	public void launchSearchForVehicle(Activity activity) {
		Intent intent = SelectVehicleActivity.getSelectVehicleActivityIntent(activity, false);
		activity.startActivity(intent);
	}

	public void saveVehicle() {
		getDataReference().saveLocalVehicle(new LocalVehicleRecord(Integer.parseInt(selectedVehicle), selectedYear, selectedMake, selectedModel));
	}

	public void deleteVehicle() {
		LocalVehicleRecord vehicle = getDataReference().getVehicleByVehicleId(Integer.parseInt(selectedVehicle));
		getDataReference().deleteLocalVehicle(vehicle);
	}

	@Override
	public void init () {

	}

	@Override
	public void destroy () {
		sharedInstance = null;
	}

	public String getSelectedYear () {
		return selectedYear;
	}

	public void setSelectedYear (MenuItem selectedYear) {
		this.selectedYear = selectedYear.getValue();
		this.selectedMake = null;
		this.selectedModel = null;
		this.selectedVehicle = null;
	}

	public String getSelectedMake () {
		return selectedMake;
	}

	public void setSelectedMake (MenuItem selectedMake) {
		this.selectedMake = selectedMake.getValue();
		this.selectedModel = null;
		this.selectedVehicle = null;
	}

	public String getSelectedModel () {
		return selectedModel;
	}

	public void setSelectedModel (MenuItem selectedModel) {
		this.selectedModel = selectedModel.getValue();
		this.selectedVehicle = null;
	}

	public String getSelectedVehicle () {
		return selectedVehicle;
	}

	public void setSelectedVehicle (MenuItem selectedVehicle) {
		this.selectedVehicle = selectedVehicle.getValue();
	}

	public void setSelectedVehicle(LocalVehicleRecord selectedVehicle){
		this.selectedVehicle = String.valueOf(selectedVehicle.getVehicleId());
	}

	public boolean isVehicleInInventory() {
		if(getDataReference().getVehicleByVehicleId(Integer.valueOf(selectedVehicle)) != null) {
			return true;
		}

		return false;
	}
}
