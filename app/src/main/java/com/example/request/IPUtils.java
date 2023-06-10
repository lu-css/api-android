package com.example.request;

import org.json.JSONObject;

import com.example.models.Localization;

public class IPUtils {
    public static final String BASE_URL = "https://freeipapi.com";

    public static Localization getLocation() throws Exception{
      JSONObject response = RequestUtils.get(BASE_URL + "/api/json");

      double lat = response.getDouble("latitude");
      double lon = response.getDouble("longitude");

      String ip = response.getString("ipAddress");

      String countryName = response.getString("countryName");
      String countryCode = response.getString("countryCode");

      String timezone = response.getString("timeZone");
      String zipCode = response.getString("zipCode");

      String city = response.getString("cityName");
      String region = response.getString("regionName");

      return new Localization(lat, lon, ip, countryName, countryCode, timezone, zipCode, city, region);
    }
}
