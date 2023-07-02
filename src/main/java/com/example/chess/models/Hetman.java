package com.example.chess.models;

import javafx.scene.paint.Color;

public class Hetman extends Figura{

    public Hetman(Color kolor){
        super(kolor);
    }

    public String nazwa(){
        if(getKolor().equals(Color.BLACK)){
            return "bialy-hetman";
        }else{
            return"czarny-hetman";
        }
    }
    @Override
    public String toString() {
        return "Hetman";
    }
}
