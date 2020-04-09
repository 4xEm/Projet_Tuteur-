package sample;

import javafx.scene.shape.Rectangle;

public class Controller {
    /*le but de la class controlleur est de pouvoir defenir des méthodes qui vont influé sur
        nos element de nos classes
     */

    static  final  int XMAX = Main.XMAX;
    static final int YMAX = Main.YMAX;
    static final int SIZE = Main.SIZE;
    static final Rectangle[][] PUIT = Main.PUIT;

    public static void place(Tetrominos piece) {

         Rectangle nPUIT[][] = new Rectangle[YMAX/SIZE][XMAX/SIZE];

        nPUIT[(int) (piece.a.getY()/SIZE)][(int) (piece.a.getX()/SIZE)] = piece.a;
        nPUIT[(int) (piece.b.getY()/SIZE)][(int) (piece.b.getX()/SIZE)] = piece.b;
        nPUIT[(int) (piece.c.getY()/SIZE)][(int) (piece.c.getX()/SIZE)] = piece.c;
        nPUIT[(int) (piece.d.getY()/SIZE)][(int) (piece.d.getX()/SIZE)] = piece.d;

        for (int i = 0; i < YMAX/SIZE; i++) {
            for (int j = 0; j < XMAX/SIZE; j++) {
                PUIT[i][j] = nPUIT[i][j];
            }

        }



    }

    public static  void affichepuit(){
        String res = "";
        for (int i = 0; i <YMAX/SIZE ; i++) {
            res = res + "\n";
            for (int j = 0; j < XMAX/SIZE ; j++) {
                if(PUIT[i][j]!=null) {
                    res= res+"1";
                }
                else {
                    res = res + "0";
                }
            }
        }
        System.out.println(res);
    }







}
