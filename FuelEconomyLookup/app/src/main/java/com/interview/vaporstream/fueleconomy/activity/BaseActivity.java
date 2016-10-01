package com.interview.vaporstream.fueleconomy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by mperkins on 9/28/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

	@LayoutRes protected abstract int LAYOUT_RESOURCE_ID();
	protected abstract void setLayout();
	protected abstract void findControls();
	protected abstract void setControlCallbacks();

	@Override
	protected void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setLayout();
		findControls();
		setControlCallbacks();
	}

	@Override
	protected void onPause () {
		super.onPause();
		EventBus.getDefault().register(this);
	}

	@Override
	protected void onResume () {
		super.onResume();
	}

	@Override
	public void finish() {
		EventBus.getDefault().unregister(this);
		super.finish();
	}

	@Subscribe
	protected abstract void handleInternetAvailabilityChange(NetworkAvailabilityChangeEvent event);

	@Subscribe
	protected abstract void handleAppBackgroundStatusChange(BackgroundStatusChangeEvent event);


}
