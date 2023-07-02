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

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 80;

    private Figura[][] plansza = new Figura[8][8];

    private void CreateBoard(){
        plansza[0][0] = new Wieza(Color.BLACK);
        plansza[0][1] = new Skoczek(Color.BLACK);
        plansza[0][2] = new Goniec(Color.BLACK);
        plansza[0][3] = new Hetman(Color.BLACK);
        plansza[0][4] = new Krol(Color.BLACK);
        plansza[0][5] = new Goniec(Color.BLACK);
        plansza[0][6] = new Skoczek(Color.BLACK);
        plansza[0][7] = new Wieza(Color.BLACK);
        for(int row = 0;row <8;row++){
            plansza[1][row] = new Pionek(Color.BLACK);
        }
        plansza[7][0] = new Wieza(Color.WHITE);
        plansza[7][1] = new Skoczek(Color.WHITE);
        plansza[7][2] = new Goniec(Color.WHITE);
        plansza[7][3] = new Krol(Color.WHITE);
        plansza[7][4] = new Hetman(Color.WHITE);
        plansza[7][5] = new Goniec(Color.WHITE);
        plansza[7][6] = new Skoczek(Color.WHITE);
        plansza[7][7] = new Wieza(Color.WHITE);
        for(int row = 0;row <8;row++){
            plansza[6][row] = new Pionek(Color.WHITE);
        }


    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        CreateBoard();
        // Utwórz pola na planszy
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                if ((row + col) % 2 == 0) {
                    square.setFill(Color.WHITE);
                } else {
                    square.setFill(Color.BLACK);
                }
                gridPane.add(square, col, row);

                if(plansza[row][col] != null){
                    ImageView imageView = new ImageView();
                    imageView.setFitWidth(SQUARE_SIZE);
                    imageView.setFitHeight(SQUARE_SIZE);
                    Figura piece = plansza[row][col];

                    File imageFile = new File(piece.nazwa() + ".png");
                    String absolutePath = imageFile.toURI().toURL().toString();
                    Image image = new Image(absolutePath);
                    imageView.setImage(image);
                    gridPane.add(imageView, col, row);
                }
            }
        }

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Szachy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
