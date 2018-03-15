package com.abdulmuqeethmohammed.distancecalc;

import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Abdul Muqeeth Mohammed
 */


public class APIQuery extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {
        Log.i("APICall", "Inside");

        try {
            URL url = new URL(strings[0]);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            Log.i("Connection Response", connection.getResponseMessage());
        } catch (IOException e) {
            Log.i("Exception", "In doInBackground");
        }

        return null;
    }
}


