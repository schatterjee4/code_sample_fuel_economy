package com.interview.vaporstream.fueleconomy.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mperkins on 9/29/16.
 */

@Root (name="vehicle")
public class Vehicle extends RealmObject {

	@PrimaryKey
	@Element
	private int id;

	@Element
	private String atvType;

	@Element
	private float barrels08;

	@Element
	private float barrelsA08;

	@Element
	private String c240Dscr;

	@Element
	private String c240bDscr;

	@Element
	private float charge120;

	@Element
	private float charge240;

	@Element
	private float charge240b;

	@Element
	private float city08;

	@Element
	private float city08U;

	@Element
	private float cityA08;

	@Element
	private float cityA08U;

	@Element
	private float cityCD;

	@Element
	private float cityE;

	@Element
	private float cityUF;

	@Element
	private float co2;

	@Element
	private float co2A;

	@Element
	private float co2TailpipeAGpm;

	@Element
	private float co2TailpipeGpm;

	@Element
	private float comb08;

	@Element
	private float comb08U;

	@Element
	private float combA08;

	@Element
	private float combA08U;

	@Element
	private float combE;

	@Element
	private float combinedCD;

	@Element
	private float combinedUF;

	@Element
	private Date createdOn;

	@Element
	private int cylinders;

	@Element
	private String displ;

	@Element
	private String drive;

	@Element
	private int engId;

	@Element
	private String eng_dscr;

	@Element
	private String evMotor;

	@Element
	private float feScore;

	@Element
	private float fuelCost08;

	@Element
	private float fuelCostA08;

	@Element
	private String fuelType;

	@Element
	private String fuelType1;

	@Element
	private String fuelType2;

	@Element
	private float ghgScore;

	@Element
	private float ghgScoreA;

	@Element
	private Boolean guzzler;

	@Element
	private float highway08;

	@Element
	private float highway08U;

	@Element
	private float highwayA08;

	@Element
	private float highwayA08U;

	@Element
	private float highwayCD;

	@Element
	private float highwayE;

	@Element
	private float highwayUF;

	@Element
	private float hlv;

	@Element
	private float hpv;

	@Element
	private float lv2;

	@Element
	private float lv4;

	@Element
	private String make;

	@Element
	private String mfrCode;

	@Element
	private String model;

	@Element
	private Date modifiedOn;

	@Element
	private String mpgData;

	@Element
	private Boolean phevBlended;

	@Element
	private float phevCity;

	@Element
	private float phevComb;

	@Element
	private float phevHwy;

	@Element
	private float pv2;

	@Element
	private float pv4;

	@Element
	private float range;

	@Element
	private float rangeA;

	@Element
	private float rangeCity;

	@Element
	private float rangeCityA;

	@Element
	private float rangeHwy;

	@Element
	private float rangeHwyA;

	@Element
	private String startStop;

	@Element
	private String trans_dscr;

	@Element
	private String trany;

	@Element
	private float UCity;

	@Element
	private float UCityA;

	@Element
	private float UHighway;

	@Element
	private float UHighwayA;

	@Element
	private String VClass;

	@Element
	private int year;

	@Element
	private float youSaveSpend;

	@Element
	private Boolean sCharger;

	@Element
	private Boolean tCharger;

	@ElementList
	private RealmList<EmissionsInfo> emissionsList;

	public Vehicle(){

	}

	public int getId () {
		return id;
	}

	public String getAtvType () {
		return atvType;
	}

	public float getBarrels08 () {
		return barrels08;
	}

	public float getBarrelsA08 () {
		return barrelsA08;
	}

	public String getC240Dscr () {
		return c240Dscr;
	}

	public String getC240bDscr () {
		return c240bDscr;
	}

	public float getCharge120 () {
		return charge120;
	}

	public float getCharge240 () {
		return charge240;
	}

	public float getCharge240b () {
		return charge240b;
	}

	public float getCity08 () {
		return city08;
	}

	public float getCity08U () {
		return city08U;
	}

	public float getCityA08 () {
		return cityA08;
	}

	public float getCityA08U () {
		return cityA08U;
	}

	public float getCityCD () {
		return cityCD;
	}

	public float getCityE () {
		return cityE;
	}

	public float getCityUF () {
		return cityUF;
	}

	public float getCo2 () {
		return co2;
	}

	public float getCo2A () {
		return co2A;
	}

	public float getCo2TailpipeAGpm () {
		return co2TailpipeAGpm;
	}

	public float getCo2TailpipeGpm () {
		return co2TailpipeGpm;
	}

	public float getComb08 () {
		return comb08;
	}

	public float getComb08U () {
		return comb08U;
	}

	public float getCombA08 () {
		return combA08;
	}

	public float getCombA08U () {
		return combA08U;
	}

	public float getCombE () {
		return combE;
	}

	public float getCombinedCD () {
		return combinedCD;
	}

	public float getCombinedUF () {
		return combinedUF;
	}

	public Date getCreatedOn () {
		return createdOn;
	}

	public int getCylinders () {
		return cylinders;
	}

	public String getDispl () {
		return displ;
	}

	public String getDrive () {
		return drive;
	}

	public int getEngId () {
		return engId;
	}

	public String getEng_dscr () {
		return eng_dscr;
	}

	public String getEvMotor () {
		return evMotor;
	}

	public float getFeScore () {
		return feScore;
	}

	public float getFuelCost08 () {
		return fuelCost08;
	}

	public float getFuelCostA08 () {
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

	public float getGhgScore () {
		return ghgScore;
	}

	public float getGhgScoreA () {
		return ghgScoreA;
	}

	public Boolean getGuzzler () {
		return guzzler;
	}

	public float getHighway08 () {
		return highway08;
	}

	public float getHighway08U () {
		return highway08U;
	}

	public float getHighwayA08 () {
		return highwayA08;
	}

	public float getHighwayA08U () {
		return highwayA08U;
	}

	public float getHighwayCD () {
		return highwayCD;
	}

	public float getHighwayE () {
		return highwayE;
	}

	public float getHighwayUF () {
		return highwayUF;
	}

	public float getHlv () {
		return hlv;
	}

	public float getHpv () {
		return hpv;
	}

	public float getLv2 () {
		return lv2;
	}

	public float getLv4 () {
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

	public Date getModifiedOn () {
		return modifiedOn;
	}

	public String getMpgData () {
		return mpgData;
	}

	public Boolean getPhevBlended () {
		return phevBlended;
	}

	public float getPhevCity () {
		return phevCity;
	}

	public float getPhevComb () {
		return phevComb;
	}

	public float getPhevHwy () {
		return phevHwy;
	}

	public float getPv2 () {
		return pv2;
	}

	public float getPv4 () {
		return pv4;
	}

	public float getRange () {
		return range;
	}

	public float getRangeA () {
		return rangeA;
	}

	public float getRangeCity () {
		return rangeCity;
	}

	public float getRangeCityA () {
		return rangeCityA;
	}

	public float getRangeHwy () {
		return rangeHwy;
	}

	public float getRangeHwyA () {
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

	public float getUCity () {
		return UCity;
	}

	public float getUCityA () {
		return UCityA;
	}

	public float getUHighway () {
		return UHighway;
	}

	public float getUHighwayA () {
		return UHighwayA;
	}

	public String getVClass () {
		return VClass;
	}

	public int getYear () {
		return year;
	}

	public float getYouSaveSpend () {
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
