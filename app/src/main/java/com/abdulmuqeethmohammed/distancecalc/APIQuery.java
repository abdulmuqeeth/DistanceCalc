package com.abdulmuqeethmohammed.distancecalc;

import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Abdul Muqeeth Mohammed
 */


public class APIQuery extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            while((inputLine=inputBuffer.readLine())!=null){

                response.append(inputLine);
            }

            inputBuffer.close();

            statusParse(response);
            distanceParse(response);

        } catch (IOException e) {}

        return null;
    }

    //This method is used to parse the JSON response
    private String statusParse(StringBuffer response){
        String status = null;

        try{
            JSONObject responseJSON = new JSONObject(response.toString());

            status = responseJSON.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getString("status");
        } catch (JSONException e){}

        return status;
    }
    //Method to parse driving distance from the json response
    private String distanceParse(StringBuffer response) {
        String distance = null;

        try{
            JSONObject responseJSON = new JSONObject(response.toString());

            JSONObject distanceObject = new JSONObject(responseJSON.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getString("distance"));
            distance = distanceObject.getString("text");
        } catch (JSONException e){}

        return distance;
    }
}



