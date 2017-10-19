package com.example.android.midtermlayout;

import android.util.Log;

/**
 * Created by globe_000 on 10/18/2017.
 */

public class Weather {

    private String description;
    private double temp;
    private double celsius;

    public Weather(String description, String dbl){
        this.description = description;
        Double temp = new Double(dbl);
        this.temp = temp;
        this.celsius = (this.temp - 32) * (0.5555555555555555555555555555555555555555556);
        Log.d("JAMES", getCelsius());
    }


    public String getTempString(){
        Double tempDbl = new Double(temp);
        return tempDbl.toString();
    }


    public String getCelsius(){
        Double temp = new Double(this.celsius);
        return temp.toString();
    }

    public String toString(){
        return ("Description : " + this.description + "\n" + "Temp : " + getTempString());
    }
}
