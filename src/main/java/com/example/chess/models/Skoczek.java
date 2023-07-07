package com.example.chess.models;

import javafx.scene.paint.Color;

public class Skoczek extends Figura{

    public Skoczek(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
    public String nazwa(){
        if(getKolor().equals(Color.BLACK)){
            return "bialy-skoczek";
        }else{
            return"czarny-skoczek";
        }
    }
    @Override
    public String toString() {
        return "Skoczek";
    }
}
