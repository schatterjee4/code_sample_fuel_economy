package com.interview.vaporstream.fueleconomy.http.endpoint;

import com.interview.vaporstream.fueleconomy.http.response.MenuItemsResponse;
import com.interview.vaporstream.fueleconomy.model.Vehicle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mperkins on 9/29/16.
 */

public interface VehicleEndpoint {

	@GET ("/ws/rest/vehicle/{id}")
	Call<Vehicle> getVehicleById (@Path ("id") int id);

	@GET ("/ws/rest/vehicle/menu/year")
	Call<MenuItemsResponse> getListOfModelYears ();

	@GET ("/ws/rest/vehicle/menu/make")
	Call<MenuItemsResponse> getListOfMakes (@Query ("year") String year);

	@GET ("/ws/rest/vehicle/menu/model")
	Call<MenuItemsResponse> getListOfModels (@Query ("year") String year, @Query ("make") String make);

	@GET ("/ws/rest/vehicle/menu/options")
	Call<MenuItemsResponse> getListOfVehicleOptions (@Query ("year") String year, @Query ("make") String make, @Query ("model") String model);

}
