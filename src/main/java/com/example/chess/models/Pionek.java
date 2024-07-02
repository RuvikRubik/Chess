package com.example.chess.models;

import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.chess.Main.BOARD_SIZE;

public class Pionek extends Figura{

    private boolean move = false;

    public Pionek(Color kolor,int row, int column){
        super(kolor,row,column);
    }
    @Override
    public String nazwa(){
        if(getKolor().equals(Color.WHITE)){
            return "white_pawn";
        }else{
            return"black_pawn";
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
            if(row + 1 < BOARD_SIZE && col + 1 < BOARD_SIZE && figures[row+1][col+1] != null && figures[row+1][col+1].getKolor() != getKolor()){
                field.add(new Pair<>(row+1,col+1));
            }
            if(row + 1 < BOARD_SIZE && col - 1 >=0 && figures[row+1][col-1] != null && figures[row+1][col-1].getKolor() != getKolor()){
                field.add(new Pair<>(row+1,col-1));
            }

        }else{
            if(!move){
                if(figures[row-1][col] == null){
                    field.add(new Pair<>(row-1,col));
                    if(row-2 >=0 && figures[row-2][col] == null){
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

    public void isPromote(Figura[][] plansza, ImageView[][] imageView){

        if(getKolor() == Color.WHITE){
            if (getRow() == 0){
                Promote(plansza,imageView);
            }
        }else{
            if(getRow() == BOARD_SIZE-1){
                Promote(plansza,imageView);
            }
        }
    }

    private Figura wybranaFigura;

    private void Promote(Figura[][] plansza, ImageView[][] imageView) {
        // Tworzenie drugiego okna
        Stage awansStage = new Stage();
        awansStage.setTitle("Awansuj pionka");

        // Tworzenie etykiety
        Label label = new Label("Wybierz figurę, na którą chcesz awansować:");

        // Tworzenie przycisków dla opcji
        Button opcja1Button = new Button("1. Hetman");
        Button opcja2Button = new Button("2. Wieża");
        Button opcja3Button = new Button("3. Goniec");
        Button opcja4Button = new Button("4. Skoczek");

        // Obsługa zdarzeń po kliknięciu przycisków
        opcja1Button.setOnAction(e -> {
            wybranaFigura = new Hetman(getKolor(), getRow(), getColumn());
            changeChessboard(plansza,imageView);
            awansStage.close();
        });

        opcja2Button.setOnAction(e -> {
            wybranaFigura = new Wieza(getKolor(), getRow(), getColumn());
            changeChessboard(plansza,imageView);
            awansStage.close();
        });

        opcja3Button.setOnAction(e -> {
            wybranaFigura = new Goniec(getKolor(), getRow(), getColumn());
            changeChessboard(plansza,imageView);
            awansStage.close();
        });

        opcja4Button.setOnAction(e -> {
            wybranaFigura = new Skoczek(getKolor(), getRow(), getColumn());
            changeChessboard(plansza,imageView);
            awansStage.close();
        });

        // Tworzenie kontenera dla przycisków
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(label, opcja1Button, opcja2Button, opcja3Button, opcja4Button);

        // Tworzenie sceny
        Scene scene = new Scene(vbox, 300, 200);

        awansStage.setScene(scene);
        awansStage.show();

        awansStage.setOnCloseRequest(Event::consume);
    }

    private void changeChessboard(Figura[][] plansza, ImageView[][] imageView){
        plansza[getRow()][getColumn()] = wybranaFigura;
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/" + wybranaFigura.nazwa() + ".png")));
        imageView[getRow()][getColumn()].setImage(image);


    }

    public void setMove(boolean move) {
        this.move = move;
    }
    @Override
    public String toString() {
        return "Pionek";
    }
}
