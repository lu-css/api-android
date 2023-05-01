package com.example.everyday;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class MainPageTaskLoader extends AsyncTaskLoader<MainPageModel>{
  private String randomAdivce;
  private Bundle query;

  MainPageTaskLoader(Context context, Bundle query) {
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

    String advice = AdviceUtils.getRandomAdvice();

    MainPageModel model = new MainPageModel(advice);
    return model;
  }

  public String getAdivice(){
    return this.randomAdivce;
  }
}
