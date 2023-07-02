package com.example.chess.models;

import javafx.scene.paint.Color;

public class Krol extends Figura{

    public Krol(Color kolor){
        super(kolor);
    }

    public String nazwa(){
        if(getKolor().equals(Color.BLACK)){
            return "bialy-krol";
        }else{
            return"czarny-krol";
        }
    }
    @Override
    public String toString() {
        return "Krol";
    }
}
