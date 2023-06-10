package com.example.validations;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CurrencyChecks {
    public static String parseCoin(String coin){
        return coin.trim().toUpperCase();
    }
    public static boolean validCoin(String coin) throws Exception {
        if(coin.isEmpty())
            throw new Exception("Empty Coin. Pleace check the field");

        List validCoins = Arrays.asList(new String[]{
          "USD",
          "BRL",
        });

        boolean containsCoin = validCoins.contains(coin);

        if (!containsCoin)
            throw new Exception(String.format("Invalid Coin \"%s\".", coin));

        return true;
    }

    public static String decimalNumbers(double value){
        DecimalFormat d = new DecimalFormat("0.##");
        return d.format(value);
    }
}
