package com.example.chess.models;

import javafx.scene.paint.Color;

public class Skoczek extends Figura{

    public Skoczek(Color kolor){
        super(kolor);
    }

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
