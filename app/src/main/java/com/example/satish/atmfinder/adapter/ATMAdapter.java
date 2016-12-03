package com.example.satish.atmfinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.satish.atmfinder.model.Location;
import com.example.satish.atmfinder.R;

import java.util.List;

/**
 * Created by satish on 12.03.2016.
 * ATM adapter to render atm data.
 */
public class ATMAdapter extends BaseAdapter {

    private static String TAG = "ATMAdapter";
    private List<Location> mATMLocations;
    private Context mContext;

    public ATMAdapter(Context context, List<Location> atmLocations) {
        super();
        this.mContext = context;
        this.mATMLocations = atmLocations;
    }

    @Override
    public int getCount() {
        return mATMLocations.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.atm_list_item, parent, false);
        TextView txtAtmName = (TextView) v.findViewById(R.id.atmName);
        TextView txtAtmAddress = (TextView) v.findViewById(R.id.atmAddress);
        TextView txtAtmDistance = (TextView) v.findViewById(R.id.atmDistance);

        Location location = mATMLocations.get(position);

        txtAtmName.setText(location.getName());
        txtAtmAddress.setText(location.getAddress() + "\n" + location.getCity() + ", " + location.getState()  + " " + location.getZip());
        txtAtmDistance.setText(location.getDistance() + " miles");

        return v;
    }
}
