package com.interview.vaporstream.fueleconomy.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.interview.vaporstream.fueleconomy.model.MenuItem;

/**
 * Created by mperkins on 9/30/16.
 */

public class FEMenuItemAdapter extends ArrayAdapter<MenuItem> {

	public FEMenuItemAdapter (Context context, int resource) {
		super(context, resource);
	}



}
