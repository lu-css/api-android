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

public class AdviceUtils{
  private static final String LOG_TAG = AdviceUtils.class.getSimpleName();
  private static final String BASE_URL = "https://api.adviceslip.com";

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
      e.printStackTrace();
      return "Erro durante requisição.";
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

  private static JSONObject makeRandomAdviceRequest() {
    try {
      return RequestUtils.get(BASE_URL + "/advice");
    } catch (Exception e) {
      e.printStackTrace();
      //TODO: handle exception
    }

    return null;
  }
}
