package com.interview.vaporstream.fueleconomy.activity;

import android.content.DialogInterface;
import android.databinding.adapters.LinearLayoutBindingAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.interview.vaporstream.fueleconomy.event.BackgroundStatusChangeEvent;
import com.interview.vaporstream.fueleconomy.event.NetworkAvailabilityChangeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by mperkins on 9/28/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

	private static final int PROGRESS_STOP_DELAY = 1500;
	protected RelativeLayout progressLayout;
	protected TextView progressText;
	protected LinearLayout noConnectionLayout;

	private Handler handler;

	public BaseActivity() {
		handler = new Handler();
	}

	@LayoutRes
	protected abstract int LAYOUT_RESOURCE_ID ();

	@Override
	protected void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
		setLayout();
		findControls();
		setControlCallbacks();
	}

	protected abstract void setLayout ();

	protected abstract void findControls ();

	protected abstract void setControlCallbacks ();

	protected void updateProgressMessageAndShow(final String progressMessage) {
		if(progressLayout != null) {
			runOnUiThread(new Runnable() {
				@Override
				public void run () {
					progressText.setText(progressMessage);
					progressLayout.setVisibility(View.VISIBLE);
				}
			});
		}
	}

	protected void updateProgressMessageAndShow(@StringRes int progressMessageStringResId){
		updateProgressMessageAndShow(getString(progressMessageStringResId));
	}

	protected void stopProgress() {
		if(progressLayout != null) {
			handler.postDelayed(new Runnable() {
				@Override
				public void run () {
					runOnUiThread(new Runnable() {
						@Override
						public void run () {
							progressLayout.setVisibility(View.GONE);
						}
					});
				}
			}, PROGRESS_STOP_DELAY);
		}
	}


	@Override
	protected void onPause () {
		super.onPause();
	}

	@Override
	protected void onResume () {
		super.onResume();

	}

	@Override
	public void finish () {
		EventBus.getDefault().unregister(this);
		super.finish();
	}

	@Subscribe
	public void handleInternetAvailabilityChange (NetworkAvailabilityChangeEvent event){
		if(noConnectionLayout != null) {
			if (event.isNetworkAvailable()) {
				noConnectionLayout.setVisibility(View.GONE);
			} else {
				noConnectionLayout.setVisibility(View.VISIBLE);
			}
		}
	}

	@Subscribe
	public abstract void handleAppBackgroundStatusChange (BackgroundStatusChangeEvent event);

	protected void createDialog(@StringRes int titleResourceId, @StringRes int messageResourceId,
								@StringRes int posButtonResId, @StringRes int negButtonResId,
								DialogInterface.OnClickListener posButtonRunnable,
								DialogInterface.OnClickListener negButtonRunnable) {


		new AlertDialog.Builder(this)
				.setTitle(titleResourceId)
				.setMessage(messageResourceId)
				.setPositiveButton(posButtonResId, posButtonRunnable)
				.setNegativeButton(negButtonResId, negButtonRunnable)
				.show();

	}

}
