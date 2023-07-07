package com.example.chess.models;

import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Pionek extends Figura{

    private boolean move = false;

    public Pionek(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
    public String nazwa(){
        if(getKolor().equals(Color.BLACK)){
            return "bialy-pionek";
        }else{
            return"czarny-pionek";
        }
    }
    @Override
    public List<Pair<Integer,Integer>> GeneratePossibleMoves(Figura[][] figures){
        List<Pair<Integer,Integer>> field = new ArrayList<>();
        if(getKolor() == Color.BLACK){
            if(!move){
                if(figures[getRow()+2][getColumn()] == null){
                    field.add(new Pair<>(getRow()+2,getColumn()));
                }
            }
            if(figures[getRow()+1][getColumn()] == null){
                field.add(new Pair<>(getRow()+1,getColumn()));
            }
        }else{
            if(!move){
                if(figures[getRow()-2][getColumn()] == null){
                    field.add(new Pair<>(getRow()-2,getColumn()));
                }
            }
            if(figures[getRow()-1][getColumn()] == null){
                field.add(new Pair<>(getRow()-1,getColumn()));
            }
        }

        return field;
    }
    @Override
    public String toString() {
        return "Pionek";
    }
}
