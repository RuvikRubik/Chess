package com.example.chess.models;

import javafx.scene.paint.Color;
import javafx.util.Pair;
import java.util.List;

public class Figura {

    private final Color kolor;
    private int column, row;
    Figura(Color kolor,int row, int column){
        this.kolor = kolor;
        this.column = column;
        this.row = row;
    }

    public String nazwa(){
        return null;
    }

    public Color getKolor() {
        return kolor;
    }

    public List<Pair<Integer,Integer>> GeneratePossibleMoves(Figura[][] figures){
        return null;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
