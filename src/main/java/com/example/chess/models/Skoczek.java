package com.example.chess.models;

import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static com.example.chess.Main.BOARD_SIZE;

public class Skoczek extends Figura{

    public Skoczek(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
    public String nazwa(){
        if(getKolor().equals(Color.WHITE)){
            return "white_knight";
        }else{
            return"black_knight";
        }
    }

    @Override
    public List<Pair<Integer,Integer>> GeneratePossibleMoves(Figura[][] figures) {
        List<Pair<Integer, Integer>> field = new ArrayList<>();
        int col = getColumn();
        int row = getRow();

        if(row + 2 < BOARD_SIZE && col + 1 < BOARD_SIZE){
            if(figures[row+2][col+1] == null || figures[row+2][col+1].getKolor() != getKolor()){
                field.add(new Pair<>(row+2,col+1));
            }
        }
        if(row + 2 < BOARD_SIZE && col - 1 >= 0){
            if(figures[row+2][col-1] == null || figures[row+2][col-1].getKolor() != getKolor()){
                field.add(new Pair<>(row+2,col-1));
            }
        }

        if(row - 2 >= 0 && col + 1 < BOARD_SIZE){
            if(figures[row-2][col+1] == null || figures[row-2][col+1].getKolor() != getKolor()){
                field.add(new Pair<>(row-2,col+1));
            }
        }
        if(row - 2 >= 0 && col - 1 >= 0){
            if(figures[row-2][col-1] == null || figures[row-2][col-1].getKolor() != getKolor()){
                field.add(new Pair<>(row-2,col-1));
            }
        }

        if(row + 1 < BOARD_SIZE && col + 2 < BOARD_SIZE){
            if(figures[row+1][col+2] == null || figures[row+1][col+2].getKolor() != getKolor()){
                field.add(new Pair<>(row+1,col+2));
            }
        }
        if(row - 1 >= 0 && col + 2 < BOARD_SIZE){
            if(figures[row-1][col+2] == null || figures[row-1][col+2].getKolor() != getKolor()){
                field.add(new Pair<>(row-1,col+2));
            }
        }

        if(row + 1 < BOARD_SIZE &&  col - 2 >= 0){
            if(figures[row+1][col-2] == null || figures[row+1][col-2].getKolor() != getKolor()){
                field.add(new Pair<>(row+1,col-2));
            }
        }
        if(row - 1 >= 0 &&  col - 2 >= 0){
            if(figures[row-1][col-2] == null || figures[row-1][col-2].getKolor() != getKolor()){
                field.add(new Pair<>(row-1,col-2));
            }
        }

        return field;
    }

    @Override
    public String toString() {
        return "Skoczek";
    }
}
