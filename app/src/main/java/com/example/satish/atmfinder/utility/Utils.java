package com.example.satish.atmfinder.utility;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by satish on 12.03.2016.
 */
public  class Utils {
    Context context;
    static boolean isNetworkAvailable;

    public static Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(new File(application.getCacheDir(), "examplecached"), cacheSize);
        return cache;
    }


    public static OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
       return client;
    }

    public static Retrofit provideRetrofit(Application app, Context context) {

        isNetworkAvailable=isNetworkAvailable(context);
        Cache cache = provideOkHttpCache(app);
        OkHttpClient okHttpClient = provideOkHttpClient(cache);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_CHASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
       return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

}
