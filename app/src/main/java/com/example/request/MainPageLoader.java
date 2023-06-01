package com.example.request;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.request.models.WeatherModel;

import java.util.Currency;
import java.util.concurrent.ExecutionException;

public class MainPageLoader extends AsyncTaskLoader<MainPageModel>{
    private Bundle query;

    public MainPageLoader(Context context, Bundle query) {
        super(context);
        this.query = query;
    }

    @Override
    protected void onStartLoading(){
        super.onStartLoading();
        forceLoad();
    }

    @Override
    @Nullable
    public MainPageModel loadInBackground(){

        if(query.getString("API") != null){
            try{
                switch (query.getString("API")) {
                    case(FreeCurrencyUtils.API_ID):
                        return currencyAPI("USD", "BRL");
                }

            } catch (Exception e) {
                return new MainPageModel(e.getMessage());
            }
        }

        try {
            String advice = AdviceUtils.getRandomAdvice();
          WeatherModel weather = WeatherUtils.getCurrentWhether();
          double currency = FreeCurrencyUtils.convertedAmmount("USD", "BRL");

          return new MainPageModel(advice, weather, currency);
      } catch (Exception e) {
        return new MainPageModel(e.getMessage());
      }
    }

    private static MainPageModel currencyAPI(String from, String to) throws Exception {
        double currency = FreeCurrencyUtils.convertedAmmount(from, to);
        MainPageModel page = new MainPageModel(null, null, currency);

        page.usingAPI = FreeCurrencyUtils.API_ID;
        return page;
    }
}
