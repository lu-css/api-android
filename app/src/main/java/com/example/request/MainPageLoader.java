package com.example.request;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.request.models.WeatherModel;

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
        String money_from = query.getString("MONEY_FROM");
        String money_to = query.getString("MONEY_TO");

        Log.d("API_MONEY", money_from);
        Log.d("API_MONEY", money_to);

      try {
          String advice = AdviceUtils.getRandomAdvice();
          WeatherModel weather = WeatherUtils.getCurrentWhether();
          double currency = FreeCurrencyUtils.convertedAmmount(
                  money_from,
                  money_to
          );

          return new MainPageModel(advice, weather, currency);
      } catch (Exception e) {
        return new MainPageModel(e.getMessage());
      }
    }
}
