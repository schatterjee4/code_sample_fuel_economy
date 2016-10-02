package com.interview.vaporstream.fueleconomy.receiver;

import android.app.ExpandableListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.interview.vaporstream.fueleconomy.FuelEconomyApplication;
import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

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
