package com.example.chess.models;

import javafx.scene.paint.Color;

public class Goniec extends Figura{

    public Goniec(Color kolor){
        super(kolor);
    }
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
