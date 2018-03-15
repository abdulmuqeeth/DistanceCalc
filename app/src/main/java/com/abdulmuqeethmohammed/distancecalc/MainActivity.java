package com.abdulmuqeethmohammed.distancecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText latitude1;
    private EditText latitude2;
    private EditText longitude1;
    private EditText longitude2;
    private Button goButton;
    private String lat1;
    private String lat2;
    private String long1;
    private String long2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitude1 = (EditText) findViewById(R.id.latitude1);
        latitude2 = (EditText) findViewById(R.id.latitude2);
        longitude1 = (EditText) findViewById(R.id.longitude1);
        longitude2 = (EditText) findViewById(R.id.longitude2);

        goButton = (Button) findViewById(R.id.goButton);

        goButton.setOnClickListener(goOnClick);

    }

    private View.OnClickListener goOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            lat1 = latitude1.getText().toString();
            lat2 = latitude2.getText().toString();
            long1 = longitude1.getText().toString();
            long2 = longitude2.getText().toString();

            String query = getResources().getString(R.string.base_url)+"json?units=imperial&origins="+lat1+","+long1+"&destinations="+lat2+","+long2+"&key="+getResources().getString(R.string.apikey);


            Intent calcIntent = new Intent(MainActivity.this, DistanceActivity.class);

            if(!lat1.isEmpty() && !lat2.isEmpty() && !long2.isEmpty() && !long2.isEmpty()){

                if(!(valueCheck(lat1) && valueCheck(lat2) && valueCheck(long1) && valueCheck(long2))){
                    Toast.makeText(getApplicationContext(), "The values should be between -180 and 180", Toast.LENGTH_SHORT).show();
                }
                else {
                    calcIntent.putExtra("lat1", lat1);
                    calcIntent.putExtra("long1", long1);
                    calcIntent.putExtra("lat2", lat2);
                    calcIntent.putExtra("long2", long2);

                    //Making call to distance matrix API
                    new APIQuery().execute(query);

                    startActivity(calcIntent);
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Please enter all the coordinates", Toast.LENGTH_SHORT).show();
            }
        }
    };

    //Method to valueCheck if the latitude and longitude values fall between -180 and 180
    private boolean valueCheck(String s) {

        return (!(Float.parseFloat(s) > 180 || Float.parseFloat(s) < -180));
    }
}
