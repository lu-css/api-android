package com.example.request;

import android.net.Uri;

import org.json.JSONObject;

import java.net.URL;

public class FreeCurrencyUtils {
    private static final String API_KEY = "9umm2yyZDLNOtQVLmx1HiGU7IM4PCRnNaFObtMpB";
    private static final String BASE_URL = "https://api.freecurrencyapi.com/v1";

    public static final String API_ID = "CONVERT_MONEY";

    public static double convertedAmmount(String from, String to) throws Exception{
        Uri uri = Uri.parse(BASE_URL + "/latest").buildUpon()
                .appendQueryParameter("apikey", API_KEY)
                .appendQueryParameter("base_currency", from)
                .appendQueryParameter("currencies", to).build();

        JSONObject response = RequestUtils.get(new URL(uri.toString())).getJSONObject("data");

        return response.getDouble(to);
    }
}
