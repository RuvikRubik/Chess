package com.example.chess.models;

import javafx.scene.paint.Color;

public class Pionek extends Figura{

    public Pionek(Color kolor){
        super(kolor);
    }

    public String nazwa(){
        if(getKolor().equals(Color.BLACK)){
            return "bialy-pionek";
        }else{
            return"czarny-pionek";
        }
    }
    @Override
    public String toString() {
        return "Pionek";
    }
}
