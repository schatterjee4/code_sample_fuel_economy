package com.interview.vaporstream.fueleconomy.model;

import org.simpleframework.xml.Root;

/**
 * Created by mperkins on 9/29/16.
 */

@Root (name="menuItem")
public class MenuItem {

	private String text;
	private String value;

	public MenuItem() {

	}

	public MenuItem (String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getText () {
		return text;
	}

	public void setText (String text) {
		this.text = text;
	}

	public String getValue () {
		return value;
	}

	public void setValue (String value) {
		this.value = value;
	}
}
