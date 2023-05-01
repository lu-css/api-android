package com.example.everyday;

import android.util.Log;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import android.net.Uri;
import android.util.Log;
import android.content.Context;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class InvalidQueryParamsLenght extends Exception{
  private int argsLenght; 

  public InvalidQueryParamsLenght(int argsLenght) {
    super(String.format("Incorrect Query Params length, the parans must be Even, submitted %d args", argsLenght));
    this.argsLenght = argsLenght;
  }

  public int getArgsLenght(){
    return argsLenght;
  }
}

public class RequestUtils {

  public static JSONObject get(String url, String... params) throws IOException, Exception  {
    URL buildedUrl = buildURL(url, params);

    HttpURLConnection urlConnection = (HttpURLConnection) buildedUrl.openConnection();

    urlConnection.connect();

    JSONObject response = buildresponse(urlConnection);

    urlConnection.disconnect();

    return response;
  }

  public static URL buildURL(String url, String... params) throws MalformedURLException, InvalidQueryParamsLenght {
    Uri uri = Uri.parse(url);

    int paramsLenght = params.length;

    if (paramsLenght % 2 != 0) {
      throw new InvalidQueryParamsLenght(paramsLenght);
    }

    for(int i = 0; i < paramsLenght; i++) {
      if (i + 1 >= paramsLenght) {
        break;
      }

      uri.buildUpon().appendQueryParameter(params[i], params[i + 1]);
    }

    return new URL(uri.toString());
  }

  private static JSONObject buildresponse(HttpURLConnection connection) throws IOException, Exception {
      InputStream inputStream = connection.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      StringBuilder builder = new StringBuilder();
      String buffer;

      while ((buffer = reader.readLine()) != null) {
        builder.append(buffer);
      }

      String response = builder.toString();

      reader.close();

      return new JSONObject(response);
  }
}
