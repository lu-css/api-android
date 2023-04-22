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

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

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
      getSupportLoaderManager().restartLoader(0, queryBundle, this);
    }

   @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new AdviceUtils(this);
    }
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        adviceSentence.setText(data);
    }
    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        // obrigatório implementar, nenhuma ação executada
    }
}
