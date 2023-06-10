package com.example.validations;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CurrencyChecks {
    public static boolean validCoin(String coin) throws Exception {
        List validCoins = Arrays.asList(new String[]{
          "USD",
          "BRL",
        });

        boolean containsCoin = validCoins.contains(coin);

        if (!containsCoin)
            throw new Exception(String.format("Invalid Coin \"%s\".", coin));

        return true;
    }
}
