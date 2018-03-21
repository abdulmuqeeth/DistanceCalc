package com.abdulmuqeethmohammed.distancecalc;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DistanceActivity extends AppCompatActivity {

    private double lat1;
    private double long1;
    private double lat2;
    private double long2;

    private TextView geoDist;
    private TextView drivDist;

    private Location loc1;
    private Location loc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        Intent retrievedIntent = getIntent();
        lat1= Double.parseDouble(retrievedIntent.getStringExtra("lat1"));
        lat2= Double.parseDouble(retrievedIntent.getStringExtra("lat2"));
        long1= Double.parseDouble(retrievedIntent.getStringExtra("long1"));
        long2= Double.parseDouble(retrievedIntent.getStringExtra("long2"));

        geoDist = (TextView) findViewById(R.id.eucDistVal);
        drivDist = (TextView) findViewById(R.id.drivDistVal);

        drivDist.setText(retrievedIntent.getStringExtra("driving_distance"));
        geoDistCalc(lat1, long1, lat2, long2);

    }

    /*
    * This method calculates distance between the two locations
    * parameters : latitudes and longitudes of both coordinates as doubles
    * returns : distance in kilometer as float
    */
    private void geoDistCalc(double lat1, double long1, double lat2, double long2){
        loc1 = new Location("");
        loc2 = new Location("");

        loc1.setLatitude(lat1);
        loc1.setLongitude(long1);

        loc2.setLatitude(lat2);
        loc2.setLongitude(long2);
        float a = loc1.distanceTo(loc2);
        geoDist.setText (Float.toString(a/1000));
    }
}
