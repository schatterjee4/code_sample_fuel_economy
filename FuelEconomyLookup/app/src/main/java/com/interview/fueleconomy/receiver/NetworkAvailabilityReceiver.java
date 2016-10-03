package com.interview.fueleconomy.receiver;

import android.app.ExpandableListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.interview.fueleconomy.FuelEconomyApplication;
import com.interview.fueleconomy.event.NetworkAvailabilityChangeEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mperkins on 9/30/16.
 */

public class NetworkAvailabilityReceiver extends BroadcastReceiver {

	@Override
	public void onReceive (Context context, Intent intent) {
		FuelEconomyApplication.getSharedInstance().checkForNetworkAvailability();
	}

}
