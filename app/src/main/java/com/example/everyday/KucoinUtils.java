package com.example.everyday;

public class KucoinUtils {
  private String BASE_URL = "<kucoin-base-url>"; 
  private String LOG_TAG = "KUCOIN_API"; 

  // public static float convertFromTo(String from, String to, float ammount){

  // }

  // private static JSONObject MakeConvertFromToRequest(String from, String to) {
  //   HttpURLConnection urlConnection = null;
  //   BufferedReader reader = null;
  //   String bookJSONString = null;

  //   try {
  //     String adviceUrl = BASE_URL + "/advice";

  //     Uri builtURI = Uri.parse(adviceUrl).buildUpon().build();
  //     URL requestURL = new URL(builtURI.toString());
  //     urlConnection = (HttpURLConnection) requestURL.openConnection();

  //     urlConnection.connect();

  //     InputStream inputStream = urlConnection.getInputStream();
  //     reader = new BufferedReader(new InputStreamReader(inputStream));
  //     StringBuilder builder = new StringBuilder();
  //     String buffer;

  //     while ((buffer = reader.readLine()) != null) {
  //       builder.append(buffer);
  //       builder.append("\n");
  //     }
  //     if (builder.length() == 0) {
  //     Log.e(LOG_TAG, "Nenhuma resposta");
  //       return null;
  //     }
  //     bookJSONString = builder.toString();
  //   } catch (IOException e) {
  //     Log.e(LOG_TAG, "Erro durante request");
  //     e.printStackTrace();
  //   } finally {

  //     if (urlConnection != null) {
  //       urlConnection.disconnect();
  //     }
  //     if (reader != null) {
  //       try {
  //         reader.close();
  //       } catch (IOException e) {
  //         e.printStackTrace();
  //       }
  //     }
  //   }
  //   Log.d(LOG_TAG, bookJSONString);

  //   try {
  //     return new JSONObject(bookJSONString);
  //   } catch (Exception e) {
  //     Log.e(LOG_TAG, "Erro ao transformar em JSON");
  //     return null;
  //   }

  // }

}
