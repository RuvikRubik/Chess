package com.example.chess.models;

import javafx.scene.paint.Color;

public class Wieza extends Figura{

    public Wieza(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
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
