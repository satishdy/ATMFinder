package com.example.satish.atmfinder.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.TextView;

import com.example.satish.atmfinder.R;
import com.example.satish.atmfinder.model.Location;
import com.example.satish.atmfinder.utility.Constants;

import java.util.List;

/**
 * Created by satish on 12.03.2016.
 */
public class ATMDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm_details);

        Location location = (Location) getIntent().getSerializableExtra(Constants.EXTRA_LOCATION);
        displayLocationDetails(location);
    }

    private void displayLocationDetails(Location location) {
        TextView textAtmName = (TextView) findViewById(R.id.textAtmLocation);
        TextView textAtmAddress = (TextView) findViewById(R.id.atmAddress);
        TextView textAtmPhone = (TextView) findViewById(R.id.atmPhone);
        TextView textAtmType = (TextView) findViewById(R.id.atmType);
        TextView textLobbyHours = (TextView) findViewById(R.id.lobbyHours);

        textAtmName.setText(location.getName());
        textAtmAddress.setText(location.getAddress() + "\n" + location.getCity() + ", " + location.getState() + " " + location.getZip());
        if (location.getPhone() != null) {
            textAtmPhone.setText(PhoneNumberUtils.formatNumber(location.getPhone()));
        }

        if (location.getAtms() != null) {
            textAtmType.setText(resolveLocationType(location.getLocType(), location.getAtms()));
        }
        textLobbyHours.setText(getLobbyHoursString(location.getLobbyHrs()));

    }

    private String resolveLocationType(String type, int atms) {
        switch (type) {
            case Constants.LOCATION_TYPE_BRANCH:
                return "Branch with " + atms + " atm/s.";
            case Constants.LOCATION_TYPE_ATM:
                return atms + "atm/s";
            default:
                return "";
        }
    }

    private String getLobbyHoursString(List<String> lobbyHours) {
        StringBuilder strLobbyHours = new StringBuilder();
        int count = 0;

        if (lobbyHours.size() == 0) {
            return getString(R.string.error_no_information);
        }

        for (String lobbyHour : lobbyHours) {

            if (lobbyHour.isEmpty()) {
                lobbyHour = "Closed";
            }

            switch (count) {
                case 0:
                    strLobbyHours.append("Sun " + lobbyHour + "\n");
                    break;
                case 1:
                    strLobbyHours.append("Mon " + lobbyHour + "\n");
                    break;
                case 2:
                    strLobbyHours.append("Tue " + lobbyHour + "\n");
                    break;
                case 3:
                    strLobbyHours.append("Wed " + lobbyHour + "\n");
                    break;
                case 4:
                    strLobbyHours.append("Thu " + lobbyHour + "\n");
                    break;
                case 5:
                    strLobbyHours.append("Fri " + lobbyHour + "\n");
                    break;
                case 6:
                    strLobbyHours.append("Sat " + lobbyHour + "\n");
                    break;
            }
            count++;
        }

        return strLobbyHours.toString();
    }

    public void closeActivity(View view) {
        finish();
    }
}
