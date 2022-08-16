package Assignment5_000836816;
/**
 * this is a player1 class which determines a random variable
 * and draws the object
 * rock - circle
 * paper - rectangle
 * scissor - triangle
 * @author Mohamed Gufran Sarfaraz Mansuri
 */

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class Player1 {
    // this is going store the int value of rock paper or scissor
   private int show;

   //this is the public integer to add the score of the player
   public int scoreP1 = 0;

    /**
     * this is the contructor of this class which set the value of the show
     * @param show
     */
    public Player1(int show) {
        this.show = (int)(Math.random()*3 + 1);
    }

    /**
     * return the value of the show
     * @return show
     */
    public int getShow() {
        return show;
    }

    /**
     * this is the setter method of this class which set the value of the show
     */
    public void setShow() {
        this.show = (int)(Math.random()*3 + 1);
    }

    /**
     * this method draws the figures of rock as circle paper as rectangle and scissors as triangle
     * @param gc
     */
    public void draw(GraphicsContext gc){
        if (getShow() == 1 ){
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(10);
            gc.strokeRect(25.0,25.0,150.0,150.0);
        }
        else if (getShow() == 2){
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(10);
            gc.strokePolygon(new double[]{90, 190, 10},
                    new double[]{30, 170, 170}, 3);
        }
        else if (getShow() == 3){
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(10);
            gc.strokeOval(25.0,25.0,150.0,150.0);
        }
    }

    /**
     * it a too string method for label
     * @return
     */
    @Override
    public String toString() {
        if(getShow() == 1){
            return "Paper";
        }else if (getShow() == 2 ){
            return "Scissor";
        }else{
            return "Rock";
        }


    }
}
