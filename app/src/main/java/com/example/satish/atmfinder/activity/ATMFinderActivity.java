package com.example.satish.atmfinder.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.satish.atmfinder.R;
import com.example.satish.atmfinder.adapter.ATMAdapter;
import com.example.satish.atmfinder.api.ChaseLocationAPI;
import com.example.satish.atmfinder.model.Atm;
import com.example.satish.atmfinder.model.Location;
import com.example.satish.atmfinder.utility.Constants;
import com.example.satish.atmfinder.utility.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by satish on 12.03.2016.
 */
public class ATMFinderActivity extends AppCompatActivity {

    private Retrofit mRetrofit;
    private LocationManager manager;
    private android.location.Location gpsLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm_finder);

        mRetrofit = Utils.provideRetrofit(getApplication(), this);

        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // Request for runtime permissions if its Marshmallow or above otherwise continue.
        if (Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
            return;
        } else {
            if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                gpsLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if (gpsLocation == null) {
                    manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                        @Override
                        public void onLocationChanged(android.location.Location newLocation) {
                            gpsLocation = newLocation;
                            loadAtms(Double.toString(gpsLocation.getLatitude()), Double.toString(gpsLocation.getLongitude()));
                        }

                        @Override
                        public void onStatusChanged(String s, int i, Bundle bundle) {

                        }

                        @Override
                        public void onProviderEnabled(String s) {

                        }

                        @Override
                        public void onProviderDisabled(String s) {

                        }
                    });

                } else {
                    loadAtms(Double.toString(gpsLocation.getLatitude()), Double.toString(gpsLocation.getLongitude()));
                }
            } else {
                showError(getString(R.string.error_location_not_enabled));
                finish();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    try {
                        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                            gpsLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            loadAtms(Double.toString(gpsLocation.getLatitude()), Double.toString(gpsLocation.getLongitude()));
                        } else {
                            showError(getString(R.string.error_location_not_enabled));
                            finish();
                        }
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                } else {
                    showError(getString(R.string.error_location_permission_denied));
                }
                return;
            }
        }
    }

    /**
     * Loads ATM locations based on Lat Long of user's device
     */
    public void loadAtms(String lat, String lng) {
        final ListView atmListView = (ListView) findViewById(R.id.atmList);
        ChaseLocationAPI api = mRetrofit.create(ChaseLocationAPI.class);

        Call<Atm> call = api.getATMLocations(lat, lng);

        call.enqueue(new Callback<Atm>() {
            @Override
            public void onResponse(Call<Atm> call, Response<Atm> response) {

                Atm atm = response.body();

                final List<Location> locations = atm.getLocations();

                if (locations.size() == 0) {
                    showError(getString(R.string.error_atm_not_found));
                }

                ATMAdapter atmAdapter = new ATMAdapter(ATMFinderActivity.this, locations);

                try {
                    atmListView.setAdapter(atmAdapter);
                    atmListView.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapter, View v, int position,
                                                long arg3) {
                            startATMDEtailsActivity(locations.get(position));
                        }
                    });
                } catch (Exception e) {
                    showError(getString(R.string.error_atm_not_found));
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Atm> call, Throwable t) {
                showError(getString(R.string.error_atm_not_found));
            }
        });
    }

    private void startATMDEtailsActivity(Location location) {
        Intent intent = new Intent(this, ATMDetailsActivity.class);
        intent.putExtra(Constants.EXTRA_LOCATION, location);
        startActivity(intent);
    }

    private void showError(String message) {
        Toast.makeText(ATMFinderActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
