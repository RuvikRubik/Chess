package com.example.chess.models;

import javafx.scene.paint.Color;

public class Figura {

    private Color kolor;
    Figura(){}
    Figura(Color kolor){
        this.kolor = kolor;
    }

    public String nazwa(){
        return null;
    }

    public Color getKolor() {
        return kolor;
    }

    public void setKolor(Color kolor) {
        this.kolor = kolor;
    }
}
