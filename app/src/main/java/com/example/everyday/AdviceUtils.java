package com.example.everyday;

import android.net.Uri;
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

public class AdviceUtils extends AsyncTaskLoader<String>{
  private static final String LOG_TAG = AdviceUtils.class.getSimpleName();
  private static final String BASE_URL = "https://api.adviceslip.com";

  AdviceUtils(Context context) {
    super(context);
  }

  @Override
  protected void onStartLoading(){
    Log.d(LOG_TAG, "StarLoading");
    super.onStartLoading();
    forceLoad();
  }

  @Override
  @Nullable
  public String loadInBackground(){
    Log.d(LOG_TAG, "LoadInBackground");
    return getRandomAdvice();
  }

  /**
   * <p>
   * This method extracts sentence from a randon Slip.
   * </p>
   * 
   * @param A Slip JSON object.
   * @return a randonly Adivice text.
   */
  public static String extractAdvice(JSONObject spitJson) {
    try {
      return spitJson.getJSONObject("slip").getString("advice");
    } catch (Exception e) {
      Log.e(LOG_TAG, "Não foi possível pegar o campo advice");
      return null;
    }
  }

  /**
   * <p>
   * Returns a random Advice.
   * </p>
   * 
   * @return A randonly Adivice text.
   */
  public static String getRandomAdvice() {
    return extractAdvice(makeRandomAdviceRequest());
  }

  static JSONObject makeRandomAdviceRequest() {
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String bookJSONString = null;

    try {
      String adviceUrl = BASE_URL + "/advice";
      Log.d(LOG_TAG, "MakerandomAdviceRequest => " + adviceUrl);

      Uri builtURI = Uri.parse(adviceUrl).buildUpon().build();
      URL requestURL = new URL(builtURI.toString());
      urlConnection = (HttpURLConnection) requestURL.openConnection();

      urlConnection.connect();
      Log.d(LOG_TAG, "MakerandomAdviceRequest => " + "Conected");

      InputStream inputStream = urlConnection.getInputStream();
      reader = new BufferedReader(new InputStreamReader(inputStream));
      StringBuilder builder = new StringBuilder();
      String buffer;

      while ((buffer = reader.readLine()) != null) {
        builder.append(buffer);
        builder.append("\n");
      }
      if (builder.length() == 0) {
      Log.e(LOG_TAG, "Nenhuma resposta");
        return null;
      }
      bookJSONString = builder.toString();
    } catch (IOException e) {
      Log.e(LOG_TAG, "Erro durante request");
      e.printStackTrace();
    } finally {

      if (urlConnection != null) {
        urlConnection.disconnect();
      }
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    Log.d(LOG_TAG, bookJSONString);

    try {
      return new JSONObject(bookJSONString);
    } catch (Exception e) {
      Log.e(LOG_TAG, "Erro ao transformar em JSON");
      return null;
    }

  }
}
