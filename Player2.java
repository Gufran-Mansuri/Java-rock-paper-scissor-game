package Assignment5_000836816;
/**
 * this is a player1 class which set the value of rock, paper and scissor from the user input
 * and draws the object
 * rock - circle
 * paper - rectangle
 * scissor - triangle
 * @author Mohamed Gufran Sarfaraz Mansuri
 */


import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class Player2 {
    // this is going store the int value of rock paper or scissor
    private int show;

    //this is the public integer to add the score of the player
    public int scoreP2 = 0;


    /**
     * this is the contructor of this class which set the value of the show
     * @param show
     */
    public Player2(int show) {
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
    public void setShow(int show) {
        this.show = show;
    }


    /**
     * this method draws the figures of rock as circle paper as rectangle and scissors as triangle
     * @param gc2
     */
    public void draw(GraphicsContext gc2){
        if (getShow() == 1 ){
            gc2.setStroke(Color.BLACK);
            gc2.setLineWidth(10);
            gc2.strokeRect(25.0,25.0,150.0,150.0);
        }
        else if (getShow() == 2){
            gc2.setStroke(Color.BLACK);
            gc2.setLineWidth(10);
            gc2.strokePolygon(new double[]{90, 190, 10},
                    new double[]{30, 170, 170}, 3);
        }
        else{
            gc2.setStroke(Color.BLACK);
            gc2.setLineWidth(10);
            gc2.strokeOval(25.0,25.0,150.0,150.0);
        }
    }


}
