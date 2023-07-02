package com.example.chess.models;

import javafx.scene.paint.Color;

public class Wieza extends Figura{

    public Wieza(Color kolor){
        super(kolor);
    }

    public String nazwa(){
        if(getKolor().equals(Color.BLACK)){
            return "biala-wieza";
        }else{
            return"czarna-wieza";
        }
    }
    @Override
    public String toString() {
        return "Wieza";
    }
}
