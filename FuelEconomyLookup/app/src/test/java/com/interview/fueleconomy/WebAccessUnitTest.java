package com.interview.fueleconomy;

import com.interview.fueleconomy.http.FuelEconomyGovWebReference;
import com.interview.fueleconomy.http.response.MenuItemsResponse;
import com.interview.fueleconomy.model.Vehicle;

import org.junit.Test;

import static org.junit.Assert.*;

import retrofit2.Response;

/**
 * Created by mperkins on 10/2/16.
 */

public class WebAccessUnitTest {

	@Test
	public void testModelYearRetrieval () throws Exception {

		Response<MenuItemsResponse> response = FuelEconomyGovWebReference
				.getSharedInstance()
				.getVehicleEndpoint()
				.getListOfModelYears()
				.clone()
				.execute();

		assertTrue(response.body().getMenuItemList().size() > 0);

	}

	@Test
	public void testManufacturerRetrieval () throws Exception {

		String availableModelYear = "2009";
		String unavailableModelYear = "1859";

		Response<MenuItemsResponse> availResponse = FuelEconomyGovWebReference
				.getSharedInstance()
				.getVehicleEndpoint()
				.getListOfMakes(availableModelYear)
				.clone()
				.execute();

		assertTrue(availResponse.body().getMenuItemList().size() > 0);

		Response<MenuItemsResponse> unavailResponse = FuelEconomyGovWebReference
				.getSharedInstance()
				.getVehicleEndpoint()
				.getListOfMakes(unavailableModelYear)
				.clone()
				.execute();

		assertTrue(unavailResponse.body().getMenuItemList().size() == 0);

	}

	@Test
	public void testModelRetrieval () throws Exception{

		String year = "2009";
		String make = "Ford";

		Response<MenuItemsResponse> response = FuelEconomyGovWebReference
				.getSharedInstance()
				.getVehicleEndpoint()
				.getListOfModels(year, make)
				.clone()
				.execute();

		assertTrue(response.body().getMenuItemList().size() > 0);

	}

	@Test
	public void testVehicleInfoRetrieval() throws Exception{

		String year = "2009";
		String make = "Ford";
		String model = "F150 Pickup 4WD";

		Response<MenuItemsResponse> response = FuelEconomyGovWebReference
				.getSharedInstance()
				.getVehicleEndpoint()
				.getListOfVehicleOptions(year, make, model)
				.clone()
				.execute();

		assertTrue(response.body().getMenuItemList().size() > 0);
	}

	@Test
	public void testVehicleRetrieval() throws Exception {

		String vehicleId = "26088";
		String year = "2009";
		String make = "Ford";
		String model = "F150 Pickup 4WD";

		Response<Vehicle> response = FuelEconomyGovWebReference
				.getSharedInstance()
				.getVehicleEndpoint()
				.getVehicleById(Integer.parseInt(vehicleId))
				.clone()
				.execute();

		assertEquals(year, response.body().getYear());
		assertEquals(make, response.body().getMake());
		assertEquals(model, response.body().getModel());
	}
}
