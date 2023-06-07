package com.example.everyday;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.request.*;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<MainPageModel> {

  private TextView adviceSentence;
  private TextView currencySentense;

  private EditText txtConvertFrom;
  private EditText txtConvertTo;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adviceSentence = findViewById(R.id.adviceSentence);
        currencySentense = findViewById(R.id.currency);

        txtConvertFrom = findViewById(R.id.convert_from);
        txtConvertTo = findViewById(R.id.convert_to);

       if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }

      Bundle query = new Bundle();

      query.putString("MONEY_FROM", "EUR");
      query.putString("MONEY_TO", "BRL");

      getSupportLoaderManager().restartLoader(0, query, this);
    }

    @NonNull
    @Override
    public Loader<MainPageModel> onCreateLoader(int id, @Nullable Bundle args) {
        return new MainPageLoader(this, args);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<MainPageModel> loader, MainPageModel data) {
      if (data.hasError()) {
        adviceSentence.setText("ERROR: " + data.getError());
        return;
      }

        // adviceSentence.setText(String.valueOf(data.getWeather().getTemp()));
      adviceSentence.setText(String.valueOf(data.getRandomAdvice()));
      currencySentense.setText(String.valueOf(data.getCurrencyTo()));

    }

    @Override
    public void onLoaderReset(@NonNull Loader<MainPageModel> loader) { /* Not implmented */ }

    public void convertMoney(View v){
        Log.i("MORTE", "API DO DINHERO");
        Log.d("MORTE", "API DO DINHERO");
        Log.e("MORTE", "API DO DINHEIRO");

        Bundle query = new Bundle();

        // query.putString("API", FreeCurrencyUtils.API_ID);
        query.putString("MONEY_FROM", txtConvertFrom.getText().toString());
        query.putString("MONEY_TO", txtConvertTo.getText().toString());

        getSupportLoaderManager().restartLoader(0, query, this);
    }
}
