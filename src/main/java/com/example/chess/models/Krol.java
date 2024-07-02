package com.example.chess.models;

import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static com.example.chess.Main.BOARD_SIZE;

public class Krol extends Figura{

    public Krol(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
    public String nazwa(){
        if(getKolor().equals(Color.WHITE)){
            return "white_king";
        }else{
            return"black_king";
        }
    }

    @Override
    public List<Pair<Integer,Integer>> GeneratePossibleMoves(Figura[][] figures) {
        List<Pair<Integer, Integer>> field = new ArrayList<>();
        int col = getColumn();
        int row = getRow();
        List<Pair<Integer, Integer>> possiblemoves = List.of(
                new Pair<>(1, 0),
                new Pair<>(1, 1),
                new Pair<>(1, -1),
                new Pair<>(-1, 0),
                new Pair<>(-1, 1),
                new Pair<>(-1, -1),
                new Pair<>(0, -1),
                new Pair<>(0, 1)
        );
        for(Pair<Integer, Integer> moves: possiblemoves){
            if(col + moves.getValue() < BOARD_SIZE && col + moves.getValue() >= 0 && row + moves.getKey() < BOARD_SIZE && row + moves.getKey() >=0){
                if(figures[row + moves.getKey()][col + moves.getValue()] == null || figures[row + moves.getKey()][col + moves.getValue()].getKolor() != getKolor()){
                    field.add(new Pair<>(row + moves.getKey(),col + moves.getValue()));
                }
            }
        }
        return field;
    }

    @Override
    public String toString() {
        return "Krol";
    }
}
