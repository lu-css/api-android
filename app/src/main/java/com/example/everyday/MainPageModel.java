package com.example.everyday;

class MainPageModel{
  private String randomAdvice;

  public MainPageModel(String randomAdvice){
    this.randomAdvice = randomAdvice;
  } 

  public String getRandomAdvice(){
    return this.randomAdvice;
  }  
}
