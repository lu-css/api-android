package com.example.request;

public class InvalidQueryParams extends Exception{
    private int argsLenght;

    public InvalidQueryParams(int argsLenght) {
        super(String.format("Incorrect Query Params, the parans must be Even, submitted %d args", argsLenght));
        this.argsLenght = argsLenght;
    }

    public int getArgsLenght(){
        return argsLenght;
    }
}
