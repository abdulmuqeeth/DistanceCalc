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

            Intent calcIntent = new Intent(MainActivity.this, DistanceActivity.class);

            if(!lat1.isEmpty() && !lat2.isEmpty() && !long2.isEmpty() && !long2.isEmpty()){
                calcIntent.putExtra("lat1", lat1);
                calcIntent.putExtra("long1", long1);
                calcIntent.putExtra("lat2", lat2);
                calcIntent.putExtra("long2", long2);
                startActivity(calcIntent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Please enter the coordinates correctly", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
