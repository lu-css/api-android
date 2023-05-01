package com.example.request;

public class MainPageModel{
    private final String randomAdvice;

    public MainPageModel(String randomAdvice){
        this.randomAdvice = randomAdvice;
    }

    public String getRandomAdvice(){
        return this.randomAdvice;
    }
}
