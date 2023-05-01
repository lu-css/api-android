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

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<MainPageModel> {

  private TextView adviceSentence;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("opa", "Main Activity - Runned");
        

        adviceSentence = findViewById(R.id.adviceSentence);

       if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }

      Bundle queryBundle = new Bundle();
      queryBundle.putString("coin_from", "BRL");
      queryBundle.putString("coin_to", "USD");

      getSupportLoaderManager().restartLoader(0, queryBundle, this);
    }

   @NonNull
    @Override
    public Loader<MainPageModel> onCreateLoader(int id, @Nullable Bundle args) {
      Bundle queryBundle = new Bundle();
      queryBundle.putString("coin_from", "BRL");
      queryBundle.putString("coin_to", "USD");

        return new MainPageTaskLoader(this, queryBundle);
    }
    @Override
    public void onLoadFinished(@NonNull Loader<MainPageModel> loader, MainPageModel data) {
        adviceSentence.setText(data.getRandomAdvice());
    }
    @Override
    public void onLoaderReset(@NonNull Loader<MainPageModel> loader) {
        // obrigatório implementar, nenhuma ação executada
    }
}
