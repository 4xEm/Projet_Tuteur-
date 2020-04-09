package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static sample.Controller.place;
import static sample.Controller.affichepuit;

public class Main extends Application {

    Scene Action;

    public static final int SIZE = 25;
    public static final int XMAX = 12 * SIZE;
    public static final int YMAX = 22 * SIZE;
    static final Rectangle PUIT[][] = new Rectangle[YMAX/SIZE][XMAX/SIZE];

    static final int score = 0;
    static final int niveau = 1;


    @Override
    public void start(Stage primaryStage) throws Exception {


        String name = Tetrominos.Nompiece();
        Tetrominos piece = new Tetrominos("T");
        place(piece);

        Pane Affichage = new Pane();

        for (int i = 0; i <YMAX/SIZE ; i++) {
            for (int j = 0; j <XMAX/SIZE ; j++) {
                if(PUIT[i][j] != null){
                    Affichage.getChildren().addAll(PUIT[i][j]);
                }

            }
        }



        Action = new Scene(Affichage, XMAX, YMAX);
        primaryStage.setScene(Action);



        Action.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                piece.Turn();
                place(piece);
                affichepuit();
            } else if (e.getCode() == KeyCode.UP) {
                piece.MoveAllUp();
                place(piece);
                affichepuit();
            } else if (e.getCode() == KeyCode.DOWN) {
                piece.MoveAllDown();
                place(piece);
                affichepuit();
            } else if (e.getCode() == KeyCode.LEFT) {
                piece.MoveAllLeft();
                place(piece);
                affichepuit();
            } else if (e.getCode() == KeyCode.RIGHT) {
                piece.MoveAllRight();
                place(piece);
                affichepuit();
            }

        });
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }




}
