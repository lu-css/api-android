package com.example.request;

import android.net.Uri;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestUtils {
    /**
     * <p> Makes a generic GET request.</p>
     *
     * @return `JSONObject` with the request response.
     */
    public static JSONObject get(String url, String... params) throws IOException, Exception  {
        URL buildedUrl = buildURL(url, params);

        HttpURLConnection urlConnection = (HttpURLConnection) buildedUrl.openConnection();

        urlConnection.connect();

        JSONObject response = buildresponse(urlConnection);

        urlConnection.disconnect();

        return response;
    }

    /**
     * <p> Vuilds the URL with all queries params </p>
     * <p>Returns a `InvalidQueryParams` if the params are incorrect. The params must contain a pair. </p>
     *
     * @return the formated url as `URL`.
     */
    public static URL buildURL(String url, String... params) throws MalformedURLException, InvalidQueryParams, InvalidQueryParams {
        Uri uri = Uri.parse(url);

        int paramsLenght = params.length;

        if (paramsLenght % 2 != 0) {
            throw new InvalidQueryParams(paramsLenght);
        }

        for(int i = 0; i < paramsLenght; i++) {
            if (i + 1 >= paramsLenght) {
                break;
            }

            uri.buildUpon().appendQueryParameter(params[i], params[i + 1]);
        }

        return new URL(uri.toString());
    }

    /**
     * <p> Builds the response into a `JSONObject`. </p>
     * @params connection A oppened `HttpURLConnection` object.
     *
     * @return The Builded response.
     */
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
