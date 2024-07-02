package com.example.chess;

import com.example.chess.models.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Main extends Application {

    public static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 80;

    private final Color WHITE = Color.WHITE;
    private final Color BLACK = Color.BLACK;
    private Rectangle[][] squares;
    private Color currentPlayer = WHITE;
    private ImageView[][] imageViews;
    private boolean Ruch = false;
    private Figura figure;
    private Figura[][] plansza = new Figura[8][8];

    private List<Pair<Integer,Integer>> Possiblemoves;
    private GridPane gridPane;

    private void CreateBoard(){
        plansza[0][0] = new Wieza(Color.BLACK,0,0);
        plansza[0][1] = new Skoczek(Color.BLACK,0,1);
        plansza[0][2] = new Goniec(Color.BLACK,0,2);
        plansza[0][3] = new Hetman(Color.BLACK,0,3);
        plansza[0][4] = new Krol(Color.BLACK,0,4);
        plansza[0][5] = new Goniec(Color.BLACK,0,5);
        plansza[0][6] = new Skoczek(Color.BLACK,0,6);
        plansza[0][7] = new Wieza(Color.BLACK,0,7);
        for(int row = 0;row <8;row++){
            plansza[1][row] = new Pionek(Color.BLACK,1,row);
        }
        plansza[7][0] = new Wieza(Color.WHITE,7,0);
        plansza[7][1] = new Skoczek(Color.WHITE,7,1);
        plansza[7][2] = new Goniec(Color.WHITE,7,2);
        plansza[7][3] = new Krol(Color.WHITE,7,3);
        plansza[7][4] = new Hetman(Color.WHITE,7,4);
        plansza[7][5] = new Goniec(Color.WHITE,7,5);
        plansza[7][6] = new Skoczek(Color.WHITE,7,6);
        plansza[7][7] = new Wieza(Color.WHITE,7,7);
        for(int row = 0;row <8;row++){
            plansza[6][row] = new Pionek(Color.WHITE,6,row);
        }
    }
    private void CreateBoard2(){
        plansza[1][2] = new Pionek(Color.WHITE,1,2);
        plansza[2][2] = new Pionek(Color.BLACK,2,2);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        CreateBoard();
        squares = new Rectangle[8][8];
        imageViews = new ImageView[8][8];
        // Utwórz pola na planszy
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                if ((row + col) % 2 == 0) {
                    square.setFill(Color.WHITE);
                } else {
                    square.setFill(Color.BLACK);
                }
                squares[row][col] = square;
                square.setOnMouseClicked(event -> handlefieldClick(square));
                gridPane.add(square, col, row);

                if(plansza[row][col] != null){
                    ImageView imageView = new ImageView();
                    imageView.setFitWidth(SQUARE_SIZE);
                    imageView.setFitHeight(SQUARE_SIZE);
                    Figura piece = plansza[row][col];
                    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Img/Figures/" + piece.nazwa() + ".png")));
                    imageView.setImage(image);
                    imageView.setOnMouseClicked(event -> handleFigureClick(imageView));
                    imageViews[row][col] = imageView;
                    gridPane.add(imageView, col, row);
                }
            }
        }

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Szachy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleFigureClick(ImageView imageView) {
        int col = GridPane.getColumnIndex(imageView);
        int row = GridPane.getRowIndex(imageView);
        if(!Ruch && plansza[row][col].getKolor() == currentPlayer){
            figure = plansza[row][col];
            Possiblemoves = figure.GeneratePossibleMoves(plansza);
            if(Possiblemoves != null){
                ColorFiled(Color.GOLD);
            }
            //System.out.println("Kliknięto na "+figure.nazwa()+" w wierszu: " + row + ", kolumnie: " + col);
            Ruch = true;
        }else{
            if(Possiblemoves != null) {
                CorrectColorField();
            }
            Ruch = false;
        }
    }

    private void handlefieldClick(Rectangle rectangle) {
        if(Ruch){
            int col = GridPane.getColumnIndex(rectangle);
            int row = GridPane.getRowIndex(rectangle);
            if(correctField(col,row)){
                if(plansza[row][col] != null){
                    ImageView pawnToDelete = imageViews[row][col];
                    gridPane.getChildren().remove(pawnToDelete);
                }
                ImageView pawnToMove = imageViews[figure.getRow()][figure.getColumn()];
                gridPane.getChildren().remove(pawnToMove);
                gridPane.add(pawnToMove,col,row);
                imageViews[figure.getRow()][figure.getColumn()] = null;
                imageViews[row][col] = pawnToMove;
                plansza[figure.getRow()][figure.getColumn()] = null;
                plansza[row][col] = figure;
                figure.setColumn(col);
                figure.setRow(row);
                CorrectColorField();
                Ruch = false;
                if(currentPlayer == WHITE){
                    currentPlayer = BLACK;
                }else{
                    currentPlayer = WHITE;
                }
                if(figure instanceof Pionek){
                    ((Pionek) figure).setMove(true);
                    ((Pionek) figure).isPromote(plansza,imageViews);
                    System.out.println(figure);
                }
            }
            else {
                CorrectColorField();
                Ruch = false;
            }
        }
    }

    private void CorrectColorField(){
        if(Possiblemoves != null){
            for (Pair<Integer, Integer> pair : Possiblemoves) {
                int row = pair.getKey();
                int col = pair.getValue();
                if ((row + col) % 2 == 0) {
                    squares[row][col].setFill(Color.WHITE);
                } else {
                    squares[row][col].setFill(Color.BLACK);
                }
            }
        }

    }

    private boolean correctField(int row,int col){
        if(Possiblemoves != null) {
            for (Pair<Integer, Integer> pair : Possiblemoves) {
                if (pair.getKey() == col && pair.getValue() == row) {
                    return true;
                }
            }
        }
        return false;
    }

    private void ColorFiled(Color color){
        for (Pair<Integer, Integer> pair : Possiblemoves){
            squares[pair.getKey()][pair.getValue()].setFill(color);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
