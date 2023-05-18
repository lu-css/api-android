package com.example.request;

import org.json.JSONObject;

public class AdviceUtils{
    private static final String LOG_TAG = AdviceUtils.class.getSimpleName();
    private static final String BASE_URL = "https://api.adviceslip.com";

    /**
     * <p> This method extracts sentence from a randon Slip. </p>
     *
     * @param slipJson Slip JSON object.
     * @return a randomly Adivice text.
     */
    public static String extractAdvice(JSONObject spitJson) throws Exception {
        return spitJson.getJSONObject("slip").getString("advice");
    }

    /**
     * <p> Returns a random Advice. </p>
     *
     * @return A randonly Adivice text.
     */
    public static String getRandomAdvice() throws Exception{
        return extractAdvice(makeRandomAdviceRequest());
    }

    private static JSONObject makeRandomAdviceRequest() throws Exception {
        return RequestUtils.get(BASE_URL + "/advice");
    }
}
