package com.example.chess.models;

import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static com.example.chess.Main.BOARD_SIZE;

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
        int col = getColumn();
        int row = getRow();
        if(getKolor() == Color.BLACK){
            if(!move){
                if(figures[row+1][col] == null){
                    field.add(new Pair<>(row+1,col));
                    if(figures[row+2][col] == null){
                        field.add(new Pair<>(row+2,col));
                    }
                }
            }else{
                if(figures[row+1][col] == null){
                    field.add(new Pair<>(row+1,col));
                }
            }
            if(row + 1 < BOARD_SIZE && col + 1 < BOARD_SIZE || figures[row+1][col+1] != null && figures[row+1][col+1].getKolor() != getKolor()){
                field.add(new Pair<>(row+1,col+1));
            }
            if(row + 1 < BOARD_SIZE && col - 1 >=0 || figures[row+1][col-1] != null && figures[row+1][col-1].getKolor() != getKolor()){
                field.add(new Pair<>(row+1,col-1));
            }

        }else{
            if(!move){
                if(figures[row-1][col] == null){
                    field.add(new Pair<>(row-1,col));
                    if(figures[row-2][col] == null){
                        field.add(new Pair<>(row-2,col));
                    }
                }
            }else{
                if(figures[row-1][col] == null){
                    field.add(new Pair<>(row-1,col));
                }
            }
            if(row - 1 >= 0 && col + 1 < BOARD_SIZE && figures[row-1][col+1] != null && figures[row-1][col+1].getKolor() != getKolor()){
                field.add(new Pair<>(row-1,col+1));
            }
            if(row - 1 >= 0 && col - 1 >= 0 && figures[row-1][col-1] != null && figures[row-1][col-1].getKolor() != getKolor()){
                field.add(new Pair<>(row-1,col-1));
            }
        }

        return field;
    }
    @Override
    public String toString() {
        return "Pionek";
    }
}
