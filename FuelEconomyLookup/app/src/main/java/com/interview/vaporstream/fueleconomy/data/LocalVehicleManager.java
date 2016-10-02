package com.interview.vaporstream.fueleconomy.data;

import android.support.annotation.StringDef;

import com.interview.vaporstream.fueleconomy.model.LocalVehicleRecord;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by mperkins on 9/30/16.
 */

public class LocalVehicleManager {

	public static final String COLUMN_YEAR = "year";
	public static final String COLUMN_MAKE = "make";
	public static final String COLUMN_MODEL = "model";

	public LocalVehicleRecord getVehicleByVehicleId (int vehicleId) {
		return getBaseQuery().equalTo("vehicleId", vehicleId).findFirst();
	}

	private RealmQuery<LocalVehicleRecord> getBaseQuery () {
		synchronized (RealmQuery.class) {
			return Realm.getDefaultInstance().where(LocalVehicleRecord.class);
		}
	}

	public void getAllVehiclesAsync (RealmChangeListener<RealmResults<LocalVehicleRecord>> listener, @SORTABLE_COLUMNS String[] sortColumn, Sort[] sortDirection) {
		if (sortColumn != null && sortDirection != null && sortColumn.length > 0 && sortColumn.length == sortDirection.length) {
			getBaseQuery().findAllSortedAsync(sortColumn, sortDirection).addChangeListener(listener);
		} else {
			getBaseQuery().findAllAsync().addChangeListener(listener);
		}
	}

	public List<LocalVehicleRecord> getAllVehicles(@SORTABLE_COLUMNS String[] sortColumn, Sort[] sortDirection){
		if (sortColumn != null && sortDirection != null && sortColumn.length > 0 && sortColumn.length == sortDirection.length) {
			return getBaseQuery().findAllSorted(sortColumn, sortDirection);
		} else {
			return getBaseQuery().findAll();
		}
	}

	public void saveLocalVehicle (final LocalVehicleRecord vehicleRecord) {
		if(getVehicleByVehicleId(vehicleRecord.getVehicleId()) == null) {
			Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
				@Override
				public void execute (Realm realm) {
					Realm.getDefaultInstance().copyToRealm(vehicleRecord);
				}
			});
		}
	}

	public void deleteLocalVehicle(final LocalVehicleRecord vehicle) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute (Realm realm) {
				vehicle.deleteFromRealm();
			}
		});
	}

	@Retention (RetentionPolicy.SOURCE)
	@StringDef ({COLUMN_YEAR, COLUMN_MAKE, COLUMN_MODEL})
	public @interface SORTABLE_COLUMNS {

	}

}