package com.example.models;

public class Localization{
  public double lat;
  public double lon;

  public String ip;
  public String countryName;
  public String countryCode;
  public String timezone;
  public String zipCode;
  public String city;
  public String region;

  public Localization(double lat, double lon, String ip, String countryName, String countryCode, String timezome, String zipCode, String city, String region) {
    this.lat = lat;
    this.lon = lon;

    this.ip = ip;
    this.countryName = countryName;
    this.countryCode = countryCode;
    this.timezone = timezome;
    this.zipCode = zipCode;
    this.city = city;
    this.region = region;
  }

  public Localization() {
    this.lat = 0;
    this.lon = 0;

    this.ip = null;
    this.countryName = null;
    this.countryCode = null;
    this.timezone = null;
    this.zipCode = null;
    this.city = null;
    this.region = null;
  }
}
