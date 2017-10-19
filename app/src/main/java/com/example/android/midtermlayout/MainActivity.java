package com.example.android.midtermlayout;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private MidtermLinearLayout view;
    private Weather weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonHandler bh = new ButtonHandler();
        CelsiusHandler ch = new CelsiusHandler();
        view = new MidtermLinearLayout(this, bh, ch);
        setContentView(view);
    }

    private class ZipAsynchTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Weather doInBackground(String... params) {
            //String [] weatherArr = new String[2];
            //weather = null;
            URL url = NetworkUtils.buildURL(params[0]);

            try{
                String response = NetworkUtils.getResponseFromHttpUrl(url.toString());

                JSONObject jsonResponse = new JSONObject(response);
                Log.d("params", jsonResponse.toString());
                JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                JSONObject descrObj = jsonArray.getJSONObject(0);

//                weatherArr[1] = jsonResponse.getJSONObject("main").get("temp").toString();
//             //   JSONObject description = descrObj.getJSONObject("description");
//                weatherArr[0] = descrObj.get("description").toString();
                weather = new Weather(descrObj.get("description").toString(), jsonResponse.getJSONObject("main").get("temp").toString());

            } catch (Exception e){
                e.printStackTrace();
            }
            return weather;
        }

        @Override
        protected void onPostExecute(Weather response){
            view.displayText(response);
        }
    }

    private class ButtonHandler implements View.OnClickListener{

        public void onClick(View v){
            String userInput = view.getTextInput();
            view.clearResult();
            new ZipAsynchTask().execute(userInput);
        }
    }

    private class CelsiusHandler implements View.OnClickListener{
        public void onClick(View v){
            String celsius = weather.getCelsius();
            view.setCelsius(celsius);
        }
    }
}
