package com.interview.vaporstream.fueleconomy.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mperkins on 9/30/16.
 */

public class NetworkAvailabilityReceiver extends BroadcastReceiver {

	@Override
	public void onReceive (Context context, Intent intent) {
		ConnectivityManager cm =
				(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

		EventBus.getDefault().post(new NetworkAvailabilityChangeEvent(isConnected));
	}

}
