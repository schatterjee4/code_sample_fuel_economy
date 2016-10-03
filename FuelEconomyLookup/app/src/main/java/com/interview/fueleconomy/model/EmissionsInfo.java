package com.interview.fueleconomy.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import io.realm.annotations.PrimaryKey;

/**
 * Created by mperkins on 9/29/16.
 */

@Root (name = "emissionsInfo")
public class EmissionsInfo {

	@PrimaryKey
	@Element
	private int id;

	@Element
	private String efid;

	@Element
	private int salesArea;

	@Element
	private float score;

	@Element
	private float scoreAlt;

	@Element
	private float smartwayScore;

	@Element
	private String standard;

	@Element
	private String stdText;

	public EmissionsInfo () {

	}

	public int getId () {
		return id;
	}

	public String getEfid () {
		return efid;
	}

	public int getSalesArea () {
		return salesArea;
	}

	public float getScore () {
		return score;
	}

	public float getScoreAlt () {
		return scoreAlt;
	}

	public float getSmartwayScore () {
		return smartwayScore;
	}

	public String getStandard () {
		return standard;
	}

	public String getStdText () {
		return stdText;
	}

}
