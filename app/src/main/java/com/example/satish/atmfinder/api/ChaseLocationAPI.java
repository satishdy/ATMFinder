package com.example.satish.atmfinder.api;

import com.example.satish.atmfinder.model.Atm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by satish on 12.03.2016.
 * Retrofit Chase API calls.
 */
public interface ChaseLocationAPI {

    @GET("/PSRWeb/location/list.action")
    Call<Atm> getATMLocations(@Query("lat") String lat, @Query("lng") String lng);
}
