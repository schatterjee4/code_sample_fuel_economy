package com.interview.fueleconomy.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.List;


import io.realm.annotations.PrimaryKey;

/**
 * Created by mperkins on 9/29/16.
 */

@Root (name = "vehicle", strict = false)
public class Vehicle {

	@PrimaryKey
	@Element(required = false)
	private String id;

	@Element(required = false)
	private String atvType;

	@Element(required = false)
	private String barrels08;

	@Element(required = false)
	private String barrelsA08;

	@Element(required = false)
	private String c240Dscr;

	@Element(required = false)
	private String c240bDscr;

	@Element(required = false)
	private String charge120;

	@Element(required = false)
	private String charge240;

	@Element(required = false)
	private String charge240b;

	@Element(required = false)
	private String city08;

	@Element(required = false)
	private String city08U;

	@Element(required = false)
	private String cityA08;

	@Element(required = false)
	private String cityA08U;

	@Element(required = false)
	private String cityCD;

	@Element(required = false)
	private String cityE;

	@Element(required = false)
	private String cityUF;

	@Element(required = false)
	private String co2;

	@Element(required = false)
	private String co2A;

	@Element(required = false)
	private String co2TailpipeAGpm;

	@Element(required = false)
	private String co2TailpipeGpm;

	@Element(required = false)
	private String comb08;

	@Element(required = false)
	private String comb08U;

	@Element(required = false)
	private String combA08;

	@Element(required = false)
	private String combA08U;

	@Element(required = false)
	private String combE;

	@Element(required = false)
	private String combinedCD;

	@Element(required = false)
	private String combinedUF;

	@Element(required = false)
	private String createdOn;

	@Element(required = false)
	private String cylinders;

	@Element(required = false)
	private String displ;

	@Element(required = false)
	private String drive;

	@Element(required = false)
	private String engId;

	@Element(required = false)
	private String eng_dscr;

	@Element(required = false)
	private String evMotor;

	@Element(required = false)
	private String feScore;

	@Element(required = false)
	private String fuelCost08;

	@Element(required = false)
	private String fuelCostA08;

	@Element(required = false)
	private String fuelType;

	@Element(required = false)
	private String fuelType1;

	@Element(required = false)
	private String fuelType2;

	@Element(required = false)
	private String ghgScore;

	@Element(required = false)
	private String ghgScoreA;

	@Element(required = false)
	private Boolean guzzler;

	@Element(required = false)
	private String highway08;

	@Element(required = false)
	private String highway08U;

	@Element(required = false)
	private String highwayA08;

	@Element(required = false)
	private String highwayA08U;

	@Element(required = false)
	private String highwayCD;

	@Element(required = false)
	private String highwayE;

	@Element(required = false)
	private String highwayUF;

	@Element(required = false)
	private String hlv;

	@Element(required = false)
	private String hpv;

	@Element(required = false)
	private String lv2;

	@Element(required = false)
	private String lv4;

	@Element(required = false)
	private String make;

	@Element(required = false)
	private String mfrCode;

	@Element(required = false)
	private String model;

	@Element(required = false)
	private String modifiedOn;

	@Element(required = false)
	private String mpgData;

	@Element(required = false)
	private Boolean phevBlended;

	@Element(required = false)
	private String phevCity;

	@Element(required = false)
	private String phevComb;

	@Element(required = false)
	private String phevHwy;

	@Element(required = false)
	private String pv2;

	@Element(required = false)
	private String pv4;

	@Element(required = false)
	private String range;

	@Element(required = false)
	private String rangeA;

	@Element(required = false)
	private String rangeCity;

	@Element(required = false)
	private String rangeCityA;

	@Element(required = false)
	private String rangeHwy;

	@Element(required = false)
	private String rangeHwyA;

	@Element(required = false)
	private String startStop;

	@Element(required = false)
	private String trans_dscr;

	@Element(required = false)
	private String trany;

	@Element(required = false)
	private String UCity;

	@Element(required = false)
	private String UCityA;

	@Element(required = false)
	private String UHighway;

	@Element(required = false)
	private String UHighwayA;

	@Element(required = false)
	private String VClass;

	@Element(required = false)
	private String year;

	@Element(required = false)
	private String youSaveSpend;

	@Element(required = false)
	private Boolean sCharger;

	@Element(required = false)
	private Boolean tCharger;

	@ElementList(name="emissionsList", required=false, inline = true)
	private List<EmissionsInfo> emissionsList;

	public Vehicle () {

	}

	public String getId () {
		return id;
	}

	public String getAtvType () {
		return atvType;
	}

	public String getBarrels08 () {
		return barrels08;
	}

	public String getBarrelsA08 () {
		return barrelsA08;
	}

	public String getC240Dscr () {
		return c240Dscr;
	}

	public String getC240bDscr () {
		return c240bDscr;
	}

	public String getCharge120 () {
		return charge120;
	}

	public String getCharge240 () {
		return charge240;
	}

	public String getCharge240b () {
		return charge240b;
	}

	public String getCity08 () {
		return city08;
	}

	public String getCity08U () {
		return city08U;
	}

	public String getCityA08 () {
		return cityA08;
	}

	public String getCityA08U () {
		return cityA08U;
	}

	public String getCityCD () {
		return cityCD;
	}

	public String getCityE () {
		return cityE;
	}

	public String getCityUF () {
		return cityUF;
	}

	public String getCo2 () {
		return co2;
	}

	public String getCo2A () {
		return co2A;
	}

	public String getCo2TailpipeAGpm () {
		return co2TailpipeAGpm;
	}

	public String getCo2TailpipeGpm () {
		return co2TailpipeGpm;
	}

	public String getComb08 () {
		return comb08;
	}

	public String getComb08U () {
		return comb08U;
	}

	public String getCombA08 () {
		return combA08;
	}

	public String getCombA08U () {
		return combA08U;
	}

	public String getCombE () {
		return combE;
	}

	public String getCombinedCD () {
		return combinedCD;
	}

	public String getCombinedUF () {
		return combinedUF;
	}

	public String getCreatedOn () {
		return createdOn;
	}

	public String getCylinders () {
		return cylinders;
	}

	public String getDispl () {
		return displ;
	}

	public String getDrive () {
		return drive;
	}

	public String getEngId () {
		return engId;
	}

	public String getEng_dscr () {
		return eng_dscr;
	}

	public String getEvMotor () {
		return evMotor;
	}

	public String getFeScore () {
		return feScore;
	}

	public String getFuelCost08 () {
		return fuelCost08;
	}

	public String getFuelCostA08 () {
		return fuelCostA08;
	}

	public String getFuelType () {
		return fuelType;
	}

	public String getFuelType1 () {
		return fuelType1;
	}

	public String getFuelType2 () {
		return fuelType2;
	}

	public String getGhgScore () {
		return ghgScore;
	}

	public String getGhgScoreA () {
		return ghgScoreA;
	}

	public Boolean getGuzzler () {
		return guzzler;
	}

	public String getHighway08 () {
		return highway08;
	}

	public String getHighway08U () {
		return highway08U;
	}

	public String getHighwayA08 () {
		return highwayA08;
	}

	public String getHighwayA08U () {
		return highwayA08U;
	}

	public String getHighwayCD () {
		return highwayCD;
	}

	public String getHighwayE () {
		return highwayE;
	}

	public String getHighwayUF () {
		return highwayUF;
	}

	public String getHlv () {
		return hlv;
	}

	public String getHpv () {
		return hpv;
	}

	public String getLv2 () {
		return lv2;
	}

	public String getLv4 () {
		return lv4;
	}

	public String getMake () {
		return make;
	}

	public String getMfrCode () {
		return mfrCode;
	}

	public String getModel () {
		return model;
	}

	public String getModifiedOn () {
		return modifiedOn;
	}

	public String getMpgData () {
		return mpgData;
	}

	public Boolean getPhevBlended () {
		return phevBlended;
	}

	public String getPhevCity () {
		return phevCity;
	}

	public String getPhevComb () {
		return phevComb;
	}

	public String getPhevHwy () {
		return phevHwy;
	}

	public String getPv2 () {
		return pv2;
	}

	public String getPv4 () {
		return pv4;
	}

	public String getRange () {
		return range;
	}

	public String getRangeA () {
		return rangeA;
	}

	public String getRangeCity () {
		return rangeCity;
	}

	public String getRangeCityA () {
		return rangeCityA;
	}

	public String getRangeHwy () {
		return rangeHwy;
	}

	public String getRangeHwyA () {
		return rangeHwyA;
	}

	public String getStartStop () {
		return startStop;
	}

	public String getTrans_dscr () {
		return trans_dscr;
	}

	public String getTrany () {
		return trany;
	}

	public String getUCity () {
		return UCity;
	}

	public String getUCityA () {
		return UCityA;
	}

	public String getUHighway () {
		return UHighway;
	}

	public String getUHighwayA () {
		return UHighwayA;
	}

	public String getVClass () {
		return VClass;
	}

	public String getYear () {
		return year;
	}

	public String getYouSaveSpend () {
		return youSaveSpend;
	}

	public Boolean getsCharger () {
		return sCharger;
	}

	public Boolean gettCharger () {
		return tCharger;
	}

	public List<EmissionsInfo> getEmissionsList () {
		return emissionsList;
	}

}
