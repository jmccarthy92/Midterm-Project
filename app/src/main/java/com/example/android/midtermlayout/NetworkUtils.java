package com.example.android.midtermlayout;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by globe_000 on 10/18/2017.
 */

public class NetworkUtils {


    public static String getResponseFromHttpUrl(String url) throws IOException {
        URL theURL= new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) theURL.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static URL buildURL(String zip){
        Uri builtUri =  Uri.parse("http://api.openweathermap.org/data/2.5/weather").buildUpon()
                .appendQueryParameter("appid","1bf836128b99c7f5fc47cbf1cc46e073")
                .appendQueryParameter("zip", zip)
                .appendQueryParameter("units", "Imperial")
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException mfe){
            mfe.printStackTrace();
        }
        return url;
    }
}
