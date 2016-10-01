package com.interview.vaporstream.fueleconomy.http;

import com.interview.vaporstream.fueleconomy.http.endpoint.VehicleEndpoint;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by mperkins on 9/29/16.
 */

public class FuelEconomyGovWebReference {

	private static final String FUELECONOMYGOV_URL = "http://www.fueleconomy.gov";

	private static FuelEconomyGovWebReference sharedInstance;
	public static FuelEconomyGovWebReference getSharedInstance() {
		synchronized (FuelEconomyGovWebReference.class) {
			if(sharedInstance == null) {
				sharedInstance = new FuelEconomyGovWebReference();
			}

			return sharedInstance;
		}
	}

	private Retrofit webReference;
	private VehicleEndpoint vehicleEndpoint;

	private FuelEconomyGovWebReference() {
		webReference = new Retrofit.Builder()
				.baseUrl(FUELECONOMYGOV_URL)
				.addConverterFactory(SimpleXmlConverterFactory.create())
				.build();
	}

	public VehicleEndpoint getVehicleEndpoint() {
		if(vehicleEndpoint == null) {
			vehicleEndpoint = webReference.create(VehicleEndpoint.class);
		}

		return vehicleEndpoint;
	}

}
