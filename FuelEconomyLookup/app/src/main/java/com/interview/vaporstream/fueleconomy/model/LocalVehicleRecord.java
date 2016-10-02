package com.interview.vaporstream.fueleconomy.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mperkins on 9/30/16.
 */

public class LocalVehicleRecord extends RealmObject {

	@PrimaryKey
	private int vehicleId;

	private String year;
	private String make;
	private String model;

	public LocalVehicleRecord () {
	}

	public LocalVehicleRecord (int vehicleId, String year, String make, String model) {
		this.vehicleId = vehicleId;
		this.year = year;
		this.make = make;
		this.model = model;
	}

	public int getVehicleId () {
		return vehicleId;
	}

	public void setVehicleId (int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getYear () {
		return year;
	}

	public void setYear (String year) {
		this.year = year;
	}

	public String getMake () {
		return make;
	}

	public void setMake (String make) {
		this.make = make;
	}

	public String getModel () {
		return model;
	}

	public void setModel (String model) {
		this.model = model;
	}

	public String toString() {
		return year + " " + make + " " + model;
	}
}
