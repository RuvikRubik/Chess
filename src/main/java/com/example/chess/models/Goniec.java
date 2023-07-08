package com.example.chess.models;

import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static com.example.chess.Main.BOARD_SIZE;

public class Goniec extends Figura{

    public Goniec(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
    public String nazwa(){
        if(getKolor().equals(Color.BLACK)){
            return "bialy-goniec";
        }else{
            return"czarny-goniec";
        }
    }
    @Override
    public List<Pair<Integer,Integer>> GeneratePossibleMoves(Figura[][] figures) {
        List<Pair<Integer, Integer>> field = new ArrayList<>();
        int col = getColumn();
        int row = getRow();
        for(int add =1;add<BOARD_SIZE;add++){
            if(col + add >= BOARD_SIZE || row + add >= BOARD_SIZE){
                break;
            }else{
                if(figures[row + add][col + add] == null){
                    field.add(new Pair<>(row + add,col + add));
                }
                else if(getKolor() != figures[row + add][col + add].getKolor()){
                    field.add(new Pair<>(row + add,col + add));
                    break;
                }
                else{
                    break;
                }
            }
        }
        for(int add =1;add<BOARD_SIZE;add++){
            if(col - add < 0 || row - add < 0){
                break;
            }else{
                if(figures[row - add][col - add] == null){
                    field.add(new Pair<>(row - add,col - add));
                }
                else if(getKolor() != figures[row - add][col - add].getKolor()){
                    field.add(new Pair<>(row - add,col - add));
                    break;
                }
                else{
                    break;
                }
            }
        }
        for(int add =1;add<BOARD_SIZE;add++){
            if(col - add < 0 || row + add >= BOARD_SIZE){
                break;
            }else{
                if(figures[row + add][col - add] == null){
                    field.add(new Pair<>(row + add,col - add));
                }
                else if(getKolor() != figures[row + add][col - add].getKolor()){
                    field.add(new Pair<>(row + add,col - add));
                    break;
                }
                else{
                    break;
                }
            }
        }
        for(int add =1;add<BOARD_SIZE;add++){
            if(col + add >= BOARD_SIZE || row - add < 0){
                break;
            }else{
                if(figures[row - add][col + add] == null){
                    field.add(new Pair<>(row - add,col + add));
                }
                else if(getKolor() != figures[row - add][col + add].getKolor()){
                    field.add(new Pair<>(row - add,col + add));
                    break;
                }
                else{
                    break;
                }
            }
        }
        return field;
    }

    @Override
    public String toString() {
        return "Goniec";
    }
}
