package com.example.chess.models;

import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static com.example.chess.Main.BOARD_SIZE;

public class Hetman extends Figura{

    public Hetman(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
    public String nazwa(){
        if(getKolor().equals(Color.WHITE)){
            return "white_queen";
        }else{
            return"black_queen";
        }
    }
    @Override
    public List<Pair<Integer,Integer>> GeneratePossibleMoves(Figura[][] figures) {
        List<Pair<Integer, Integer>> field = new ArrayList<>();
        int column = getColumn();
        int wiersz = getRow();
        for(int col = getColumn()+1;col<BOARD_SIZE;col++){
            if(figures[wiersz][col] == null){
                field.add(new Pair<>(wiersz,col));
            }
            else if (getKolor() != figures[wiersz][col].getKolor()) {
                field.add(new Pair<>(wiersz,col));
                break;
            }
            else{
                break;
            }
        }
        for(int col = getColumn()-1;col>=0;col--){
            if(figures[wiersz][col] == null){
                field.add(new Pair<>(wiersz,col));
            }
            else if (getKolor() != figures[wiersz][col].getKolor()) {
                field.add(new Pair<>(wiersz,col));
                break;
            }
            else{
                break;
            }
        }
        for(int row = getRow()+1;row<BOARD_SIZE;row++){
            if(figures[row][column] == null){
                field.add(new Pair<>(row,column));
            }
            else if (getKolor() != figures[row][column].getKolor()) {
                field.add(new Pair<>(row,column));
                break;
            }
            else{
                break;
            }
        }
        for(int row = getRow()-1;row>=0;row--){
            if(figures[row][column] == null){
                field.add(new Pair<>(row,column));
            }
            else if (getKolor() != figures[row][column].getKolor()) {
                field.add(new Pair<>(row,column));
                break;
            }
            else{
                break;
            }
        }
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
        return "Hetman";
    }
}
