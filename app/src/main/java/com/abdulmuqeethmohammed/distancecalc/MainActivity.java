package com.abdulmuqeethmohammed.distancecalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText coordinate1;
    private EditText coordinate2;
    private Button goButton;
    private String loc1;
    private String loc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinate1 = (EditText) findViewById(R.id.coordinate1);
        coordinate2 = (EditText) findViewById(R.id.coordinate2);

        goButton = (Button) findViewById(R.id.goButton);

        goButton.setOnClickListener(goOnClick);
    }

    private View.OnClickListener goOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loc1 = coordinate1.getText().toString();
            loc2 = coordinate2.getText().toString();

            Intent calcIntent = new Intent(MainActivity.this, DistanceActivity.class);

            if(!loc1.isEmpty() && !loc2.isEmpty()){
                calcIntent.putExtra("loc1", loc1);
                calcIntent.putExtra("loc2", loc2);
                startActivity(calcIntent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Please enter the coordinates", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
