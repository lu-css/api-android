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

        return get(buildedUrl);
    }

    public static JSONObject get(URL url) throws IOException, Exception  {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

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
    public static URL buildURL(String url, String... params) throws MalformedURLException {
        Uri uri = Uri.parse(url);

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
