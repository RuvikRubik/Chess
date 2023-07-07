package com.example.chess.models;

import javafx.scene.paint.Color;

public class Goniec extends Figura{

    public Goniec(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
    public String nazwa(){
        if(getKolor().equals(Color.BLACK)){
            return "bialy-goniec";
        }else{
            return"czarny-goniec";
        }
    }


    @Override
    public String toString() {
        return "Goniec";
    }
}
