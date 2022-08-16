package Assignment5_000836816;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




/** this main class of in which I design the game
 *
 * @author Mohamed Gufran Sarfaraz Mansuri
 */
public class Rock_Paper_Scissor_Game extends Application {

    // TODO: Instance Variables for View Components and Model

    //this are the labels which is Displayed on the GUI
    private Label toStringLabel1,score1,score2,displayLable;

    //this is the graphic context
    private GraphicsContext gc2,gc;

    //this is the player objects 1&2
    private Player1 p1;
    private Player2 p2;

    // this is the text field in which the user enters rock, paper or scissor
    private TextField userField;

    // TODO: Private Event Handlers and Helper Methods

    // this method is kind of refresh method
    private void play1() {
        //draws both the canvas
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0,0,200,200);
        gc2.setFill(Color.LIGHTBLUE);
        gc2.fillRect(0,0,200,200);

        // generating the random integer for displaying either it is rock paper or scissor
        p1.setShow();

        // this whole if else statements is determining who is gonna win the game
        if (p1.getShow() == 1 &&  p2.getShow() == 3){
            p1.scoreP1 = p1.scoreP1 +1;
            p1.draw(gc);
            p2.draw(gc2);
            displayLable.setVisible(false); // turning the visibility oof a label which shows it is a tie or not


        }
        else if (p1.getShow() == 2 && p2.getShow() ==1) {
            p1.scoreP1 = p1.scoreP1 + 1;
            p1.draw(gc);
            p2.draw(gc2);
            displayLable.setVisible(false); //// turning the visibility oof a label which shows it is a tie or not


        }
        else if (p1.getShow() == 3 && p2.getShow() == 2){
            p1.scoreP1 += 1;
            p1.draw(gc);
            p2.draw(gc2);
            displayLable.setVisible(false);// turning the visibility oof a label which shows it is a tie or not


        }
        else if (p1.getShow() == 1 && p2.getShow() == 2){
            p2.scoreP2 = p2.scoreP2 + 1;
            p1.draw(gc);
            p2.draw(gc2);
            displayLable.setVisible(false);// turning the visibility oof a label which shows it is a tie or not

        }
        else if (p1.getShow() == 2 && p2.getShow() == 3){
            p2.scoreP2 = p2.scoreP2 + 1;
            p1.draw(gc);
            p2.draw(gc2);
            displayLable.setVisible(false);// turning the visibility oof a label which shows it is a tie or not


        }
        else if (p1.getShow() == 3 && p2.getShow() == 1){
            p2.scoreP2 = p2.scoreP2 + 1;
            p1.draw(gc);
            p2.draw(gc2);
            displayLable.setVisible(false);// turning the visibility oof a label which shows it is a tie or not

        }
        else if ((p1.getShow() == 1 && p2.getShow() == 1) || (p1.getShow() == 2 && p2.getShow() == 2) || (p1.getShow() == 3 && p2.getShow() == 3)){
            p1.draw(gc);
            p2.draw(gc2);
            displayLable.setVisible(true);
            displayLable.setText("IT'S A TIE!!!!");// turning the visibility on a label which shows it is a tie or not

        }

    }

    /**
     * this is our event handler method
     *
     */

    private void play(ActionEvent event){

        // this is displaying the score label of both the players
        score1.setText(String.valueOf("score " + p1.scoreP1));
        score2.setText(String.valueOf("score " + p2.scoreP2));

        // this method is converting the user input into an integer to determine whos is going to win
        if (userField.getText().equalsIgnoreCase("rock")){
            p2.setShow(3);
        }
        else if (userField.getText().equalsIgnoreCase("paper")){
            p2.setShow(1);
        }
        else if (userField.getText().equalsIgnoreCase("scissor")){
            p2.setShow(2);
        }

        // playing the refresh method
        play1();

        // displaying the
        toStringLabel1.setText(p1.toString());
    }
    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 590, 330); // set the size here
        stage.setTitle("Rock Paper Scissor Game"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        p1 = new Player1(0);
        p2 = new Player2(0);

        // 2. Create the GUI components
        toStringLabel1 = new Label("null");
        displayLable = new Label("");


        userField = new TextField("rock,paper or scissor");


        score1 = new Label("0");
        score2 =  new Label("0");

        Canvas c = new Canvas(200,200);
        gc = c.getGraphicsContext2D();


        Canvas c2 = new Canvas(200,200);
        gc2 = c2.getGraphicsContext2D();


        Button setButton = new Button("PLAY!!!");

        // 3. Add components to the root
        root.getChildren().addAll(toStringLabel1,userField,score1,score2,c,c2,setButton,displayLable);

        // 4. Configure the components (colors, fonts, size, location)
        score1.relocate(10,20);
        score2.relocate(530,20);

        c.relocate(10,40);
        c2.relocate(380,40);

        toStringLabel1.relocate(10,250);
        displayLable.relocate(265,200);
        displayLable.setStyle("-fx-background-color:crimson; -fx-text-fill:silver");

        userField.relocate(430,250);
        userField.requestFocus();


        setButton.relocate(265,290);


        // 5. Add Event Handlers and do final setup
        setButton.setOnAction(this::play);
        play1();

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
