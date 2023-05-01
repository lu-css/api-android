package com.example.request;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class MainPageLoader extends AsyncTaskLoader<MainPageModel>{
    private Bundle query;

    public MainPageLoader(Context context, Bundle query) {
        super(context);
        this.query = query;
    }

    @Override
    protected void onStartLoading(){
        super.onStartLoading();
        forceLoad();
    }

    @Override
    @Nullable
    public MainPageModel loadInBackground(){
        String advice = AdviceUtils.getRandomAdvice();

        return new MainPageModel(advice);
    }
}
