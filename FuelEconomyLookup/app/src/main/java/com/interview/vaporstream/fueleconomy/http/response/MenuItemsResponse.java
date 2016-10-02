package com.interview.vaporstream.fueleconomy.http.response;

import com.interview.vaporstream.fueleconomy.model.MenuItem;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mperkins on 9/29/16.
 */

@Root(strict = false)
public class MenuItemsResponse {

	@ElementList(name = "menuItems", inline = true, required = false)
	private List<MenuItem> menuItemList;

	public MenuItemsResponse () {

	}

	public List<MenuItem> getMenuItemList () {
		if(menuItemList == null || menuItemList.size() == 0) {
			return new ArrayList<>();
		} else {
			List<MenuItem> items = new ArrayList<>();
			items.add(new MenuItem("", null));
			if (menuItemList != null) {
				items.addAll(menuItemList);
			}
			return items;
		}
	}
}
