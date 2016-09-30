package com.interview.vaporstream.fueleconomy.http.response;

import com.interview.vaporstream.fueleconomy.model.MenuItem;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by mperkins on 9/29/16.
 */

@Root (name="menuItems")
public class MenuItemsResponse {

	@ElementList
	private List<MenuItem> menuItemList;

	public MenuItemsResponse(){

	}

	public List<MenuItem> getMenuItemList () {
		return menuItemList;
	}
}
