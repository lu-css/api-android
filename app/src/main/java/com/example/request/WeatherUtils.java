package com.example.request;

import android.net.Uri;

import com.example.models.WeatherModel;
import com.example.models.Localization;

import java.net.URL;


import org.json.JSONObject;

public class WeatherUtils {
    private static final String BASE_URL = "https://api.weatherapi.com/v1";

    // COMO ESCONDE ISSO ?????
    // USar dotenv sei la
    public static final String API_KEY = "75a656b54dd14d48aca135728230305";

    public static WeatherModel getCurrentWhether() throws Exception {
        Localization localization = IPUtils.getLocation();

        String lonlat = String.format("%s,%s", localization.lat, localization.lon);

        Uri uri = Uri.parse(BASE_URL + "/current.json").buildUpon()
        .appendQueryParameter("key", API_KEY)
        .appendQueryParameter("q", lonlat).build();

        URL url = new URL(uri.toString());

        JSONObject json = RequestUtils.get(url);

        JSONObject current = json.getJSONObject("current");

        double temp = current.getDouble("temp_c");

        String condition = current.getJSONObject("condition").getString("text");
        String conditionImg = current.getJSONObject("condition").getString("icon");

        return new WeatherModel(condition, conditionImg, temp, localization);
    }
}

