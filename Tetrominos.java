package sample;

import javafx.scene.shape.Rectangle;

public class Tetrominos {

    static  final  int XMAX = Main.XMAX;
    static final int YMAX = Main.YMAX;
    static final int SIZE = Main.SIZE;
   

    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    String name;
    int etat;

    public Tetrominos(){

    }

    public Tetrominos(String name){

        this.etat = 1;

        this.a = new Rectangle(Main.SIZE-1,Main.SIZE-1);
        this.b = new Rectangle(Main.SIZE-1,Main.SIZE-1);
        this.c = new Rectangle(Main.SIZE-1,Main.SIZE-1);
        this.d = new Rectangle(Main.SIZE-1,Main.SIZE-1);


        // i o t l j z s
        if(name.toUpperCase() == "I"){

            this.name = "I";
            this.a.setX(XMAX/2);
            this.b.setX(XMAX/2);
            this.c.setX(XMAX/2);
            this.d.setX(XMAX/2);

            this.a.setY(0);
            this.b.setY(1*SIZE);
            this.c.setY(2*SIZE);
            this.d.setY(3*SIZE);

        }
        else if (name.toUpperCase() == "O"){

            this.name = "O";
            this.a.setX(XMAX/2);
            this.b.setX(XMAX/2);
            this.c.setX((XMAX/2)+SIZE);
            this.d.setX((XMAX/2)+SIZE);

            this.a.setY(0);
            this.b.setY(1*SIZE);
            this.c.setY(0);
            this.d.setY(1*SIZE);
        }
        else if (name.toUpperCase() == "T"){
            this.name = "T";
            this.a.setX(XMAX/2);
            this.b.setX(XMAX/2);
            this.c.setX((XMAX/2)+SIZE);
            this.d.setX((XMAX/2)-SIZE);

            this.a.setY(0);
            this.b.setY(1*SIZE);
            this.c.setY(0);
            this.d.setY(0);
        }
        else if (name.toUpperCase() == "L"){

            this.name = "L";
            this.a.setX(XMAX/2);
            this.b.setX(XMAX/2);
            this.c.setX((XMAX/2));
            this.d.setX((XMAX/2)+SIZE);

            this.a.setY(0);
            this.b.setY(1*SIZE);
            this.c.setY(2*SIZE);
            this.d.setY(2*SIZE);
        }
        else if (name.toUpperCase() == "J"){
            this.name = "J";
            this.a.setX(XMAX/2);
            this.b.setX(XMAX/2);
            this.c.setX((XMAX/2));
            this.d.setX((XMAX/2)-SIZE);

            this.a.setY(0);
            this.b.setY(1*SIZE);
            this.c.setY(2*SIZE);
            this.d.setY(2*SIZE);
        }
        else if (name.toUpperCase() == "Z"){
            this.name = "Z";
            this.a.setX(XMAX/2);
            this.b.setX(XMAX/2);
            this.c.setX((XMAX/2)+SIZE);
            this.d.setX((XMAX/2)-SIZE);

            this.a.setY(0);
            this.b.setY(1*SIZE);
            this.c.setY(1*SIZE);
            this.d.setY(0);
        }
        else if (name.toUpperCase() == "S"){
            this.name = "S";
            this.a.setX(XMAX/2);
            this.b.setX(XMAX/2);
            this.c.setX((XMAX/2)+SIZE);
            this.d.setX((XMAX/2)-SIZE);

            this.a.setY(0);
            this.b.setY(1*SIZE);
            this.c.setY(0);
            this.d.setY(1*SIZE);
        }
    }

    public void nextState(String name, int etat) {
        if((name == "I" || name == "S" || name == "Z") && etat == 2){
            this.etat =0;
        }
        else if(name == "O"){
            this.etat = 1;
        }
        else if(etat == 4){
           this.etat = 1;
        }
        else{
           this.etat++;
        }

    }
    public static String Nompiece(){
        String choix = "";

        int hasard = (int) (Math.random() * 100);

        if (hasard<15){
            choix = "O";
        }
        else if (hasard<30){
            choix = "T";
        }
        else if (hasard<45){
            choix = "L";
        }
        else if (hasard < 60){
            choix = "J";
        }
        else if (hasard<75){
            choix = "Z";
        }
        else if (hasard < 90){
            choix = "S";
        }
        else{
            choix = "I";
        }

        return choix;
    }


    public void MoveUp(Rectangle morceauPiece){
        int yMorceauPiece = (int) morceauPiece.getY();
        if(morceauPiece.getY()-SIZE > 0) {
            morceauPiece.setY(yMorceauPiece - SIZE);
        }
    }

    public void MoveDown(Rectangle morceauPiece){
        int yMorceauPiece = (int) morceauPiece.getY();
        morceauPiece.setY(yMorceauPiece+SIZE);
    }

    public void MoveLeft(Rectangle morceauPiece){
        int xMorceauPiece = (int) morceauPiece.getX();
        morceauPiece.setX(xMorceauPiece-SIZE);
    }

    public void MoveRight(Rectangle morceauPiece){
        int xMorceauPiece = (int) morceauPiece.getX();
        morceauPiece.setX(xMorceauPiece+SIZE);
    }

    public void Turn(){
        switch (this.name) {
            case "I":
                this.nextState("I", this.etat);
                switch (this.etat) {
                    case (1):
                        //action
                        MoveUp(this.a);
                        MoveLeft(this.a);

                        MoveDown(this.c);
                        MoveRight(this.c);

                        MoveDown(this.d);
                        MoveDown(this.d);
                        MoveRight(this.d);
                        MoveRight(this.d);

                        break;
                    case (2):
                        //action
                        MoveRight(this.a);
                        MoveDown(this.a);

                        MoveLeft(this.c);
                        MoveUp(this.c);

                        MoveLeft(this.d);
                        MoveLeft(this.d);
                        MoveUp(this.d);
                        MoveUp(this.d);

                        break;
                }
                break;
            case "O":

                break;
            case "S":
                this.nextState("S", this.etat);
                switch (this.etat) {
                    case (1):
                        //action
                        MoveRight(this.c);
                        MoveDown(this.c);

                        MoveDown(this.b);
                        MoveLeft(this.b);

                        MoveLeft(this.d);
                        MoveLeft(this.d);
                        break;

                    case (2):
                        //action
                        MoveUp(this.c);
                        MoveLeft(this.c);

                        MoveRight(this.b);
                        MoveUp(this.b);

                        MoveRight(this.d);
                        MoveRight(this.d);
                        break;
                }

                break;
            case "Z":
                this.nextState("Z", this.etat);
                switch (this.etat) {
                    case (1):
                        //action
                        MoveDown(this.c);
                        MoveDown(this.c);

                        MoveDown(this.b);
                        MoveLeft(this.b);

                        MoveLeft(this.d);
                        MoveUp(this.d);

                        break;
                    case (2):
                        //action
                        MoveUp(this.c);
                        MoveUp(this.c);

                        MoveRight(this.b);
                        MoveUp(this.b);

                        MoveDown(this.d);
                        MoveRight(this.d);

                        break;
                }
                break;
            case "L":
                this.nextState("L", this.etat);
                switch (this.etat) {
                    case (1):
                        //action
                        MoveUp(this.a);
                        MoveLeft(this.a);

                        MoveDown(this.c);
                        MoveRight(this.c);

                        MoveRight(this.d);
                        MoveRight(this.d);
                        break;
                    case (2):
                        //
                        MoveLeft(this.a);
                        MoveDown(this.a);

                        MoveRight(this.c);
                        MoveUp(this.c);

                        MoveUp(this.d);
                        MoveUp(this.d);
                        break;
                    case (3):
                        //action
                        MoveDown(this.a);
                        MoveRight(this.a);

                        MoveUp(this.c);
                        MoveLeft(this.c);

                        MoveLeft(this.d);
                        MoveLeft(this.d);
                        break;
                    case (4):
                        //Action

                        MoveRight(this.a);
                        MoveUp(this.a);

                        MoveLeft(this.c);
                        MoveDown(this.c);

                        MoveDown(this.d);
                        MoveDown(this.d);
                        break;
                }

                break;
            case "J":
                this.nextState("J", this.etat);
                switch (this.etat) {
                    case (1):
                        //action
                        MoveUp(this.a);
                        MoveRight(this.a);

                        MoveDown(this.c);
                        MoveLeft(this.c);

                        MoveLeft(this.d);
                        MoveLeft(this.d);
                        break;
                    case (2):
                        //action
                        MoveRight(this.a);
                        MoveDown(this.a);

                        MoveLeft(this.c);
                        MoveUp(this.c);

                        MoveUp(this.d);
                        MoveUp(this.d);
                        break;
                    case (3):
                        //action
                        MoveDown(this.a);
                        MoveLeft(this.a);

                        MoveUp(this.c);
                        MoveRight(this.c);

                        MoveRight(this.d);
                        MoveRight(this.d);
                        break;
                    case (4):
                        //Action
                        MoveUp(this.a);
                        MoveLeft(this.a);

                        MoveRight(this.c);
                        MoveDown(this.c);

                        MoveDown(this.d);
                        MoveDown(this.d);
                        break;
                }
                break;
            default:
                this.nextState("T", this.etat);
                switch (this.etat) {
                    case (1):
                            //action
                            MoveRight(this.c);
                            MoveUp(this.c);

                            MoveDown(this.b);
                            MoveRight(this.b);

                            MoveLeft(this.d);
                            MoveDown(this.d);
                        break;
                    case (2):
                        //action
                        MoveUp(this.c);
                        MoveLeft(this.c);

                        MoveRight(this.b);
                        MoveUp(this.b);

                        MoveDown(this.d);
                        MoveRight(this.d);
                        break;
                    case (3):
                        //action
                        MoveLeft(this.c);
                        MoveDown(this.c);

                        MoveUp(this.b);
                        MoveLeft(this.b);

                        MoveRight(this.d);
                        MoveUp(this.d);
                        break;
                    case (4):
                        //Action
                        MoveDown(this.c);
                        MoveRight(this.c);

                        MoveDown(this.b);
                        MoveLeft(this.b);

                        MoveUp(this.d);
                        MoveLeft(this.d);


                        break;
                }
                break;
        }
    }
    public void MoveAllLeft(){
        if(this.a.getX()-SIZE >= 0 && this.b.getX()-SIZE >= 0 && this.c.getX()-SIZE >= 0 && this.d.getX()-SIZE >= 0){
            MoveLeft(this.a);
            MoveLeft(this.b);
            MoveLeft(this.c);
            MoveLeft(this.d);
        }
    }
    public void MoveAllRight(){

        if(this.a.getX()+SIZE<XMAX && this.b.getX()+SIZE <XMAX && this.c.getX()+SIZE < XMAX && this.d.getX()+SIZE  < XMAX) {
            MoveRight(this.a);
            MoveRight(this.b);
            MoveRight(this.c);
            MoveRight(this.d);
        }
    }
    public void MoveAllUp(){
        if(this.a.getY()-SIZE >= 0 && this.b.getY()-SIZE >= 0 && this.c.getY()-SIZE >= 0 && this.d.getY()-SIZE >= 0) {
            MoveUp(this.a);
            MoveUp(this.b);
            MoveUp(this.c);
            MoveUp(this.d);
        }
    }
    public void MoveAllDown(){
        if(this.a.getY()+SIZE<YMAX && this.b.getY()+SIZE <YMAX && this.c.getY()+SIZE < YMAX && this.d.getY()+SIZE  < YMAX) {
            MoveDown(this.a);
            MoveDown(this.b);
            MoveDown(this.c);
            MoveDown(this.d);
        }
    }
}



