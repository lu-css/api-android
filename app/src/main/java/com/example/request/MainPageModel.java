package com.example.request;

import com.example.request.models.WeatherModel;

public class MainPageModel{
    private final String randomAdvice;
    private final WeatherModel weather;

    private final double currency;

    public String usingAPI = null;
    private final String error;

    public MainPageModel(String error) {
        this.randomAdvice = "";
        this.currency= 0;
        this.weather = new WeatherModel();
        this.error = error;
    }

    public MainPageModel(String randomAdvice, WeatherModel weather, double currency){
        this.randomAdvice = randomAdvice;
        this.weather = weather;
        this.currency = currency;

        this.error = null;
    }

    public String getRandomAdvice(){
        return this.randomAdvice;
    }

    public WeatherModel getWeather(){
        return this.weather;
    }

    public String getError() {
      return error;
    }

    public boolean hasError() {
      return error != null;
    }

    public double getCurrencyTo(){ return currency; }

}