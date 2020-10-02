import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application{
    //private Coordinate[][] coordinates = new Coordinate[20][12];
    Pane layout;

    @Override
    public void start(Stage primaryStage){
        //Create base layout
        layout = new Pane();
        layout.setStyle("-fx-background-color: black");

        //Create default coordinates, all empty
        //setCoordinates();

        //Set and draw map
       // createMap();

        //Place points
        //createPoints();
        Map map = new Map(layout);

        //Reset points
//        resetPoints();


        //Reset button
        Button reset = new Button("Reset");
        Button show = new Button("Show");
        show.setOnAction(e -> {
            map.printCurrent();
            layout.requestFocus();
        });
        show.setLayoutX(100);
        reset.setOnAction(e -> {
            map.resetPoints();
            layout.requestFocus();
        });
        layout.getChildren().addAll(reset, show);

        //Draw the pointer


        //Add pacman to the layout
        Pacman pacman = new Pacman();
        layout.getChildren().add(pacman);
        map.getCoordinates()[1][1].makePacman();

        Awesome a = new Awesome(9,4);
        Giyo g= new Giyo(9,5);
        Ercome r= new Ercome(9,7);

        layout.getChildren().add(a);
        layout.getChildren().add(g);
        layout.getChildren().add(r);

        new Timer().schedule(new TimerTask()
        {
            public void run()
            {
                a.move(pacman.getPosition());
                g.move(pacman.getPosition());
                r.move(pacman.getPosition());

                //The task you want to do
            }

        },0,1000);


        //Handle keyboard inputs(events)
        layout.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                if (!map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY() - 1].isBox()) {
                    if (map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY() -1].isPoint()) {
                        map.points++;
                        map.updatePointer();
                        layout.getChildren().remove(
                                map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY() -1].getHoldedObject()
                        );
                    }
                    map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY()-1].makePacman();
                    map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY()].makeEmpty();
                    pacman.setPosition(new Coordinate(pacman.getPosition().getX(), pacman.getPosition().getY() -1));
                }
                pacman.rotateUp();
            }
            if (e.getCode() == KeyCode.DOWN) {
                if (!map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY() + 1].isBox()) {
                    if (map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY() + 1].isPoint()) {
                        map.points++;
                        map.updatePointer();
                        layout.getChildren().remove(
                                map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY() + 1].getHoldedObject()
                        );;
                    }
                    map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY()+1].makePacman();
                    map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY()].makeEmpty();
                    pacman.setPosition(new Coordinate(pacman.getPosition().getX(), pacman.getPosition().getY() + 1));
                }
                pacman.rotateDown();
            }
            if (e.getCode() == KeyCode.RIGHT) {
                if (!map.getCoordinates()[pacman.getPosition().getX()+1][pacman.getPosition().getY()].isBox()) {
                    if (map.getCoordinates()[pacman.getPosition().getX() + 1][pacman.getPosition().getY()].isPoint()) {
                        map.points++;
                        map.updatePointer();
                        layout.getChildren().remove(
                                map.getCoordinates()[pacman.getPosition().getX() + 1][pacman.getPosition().getY()].getHoldedObject()
                        );
                    }

                    map.getCoordinates()[pacman.getPosition().getX()+1][pacman.getPosition().getY()].makePacman();
                    map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY()].makeEmpty();
                    pacman.setPosition(new Coordinate(pacman.getPosition().getX()+1, pacman.getPosition().getY()));
                }
                pacman.rotateRight();
            }
            if (e.getCode() == KeyCode.LEFT) {
                if (!map.getCoordinates()[pacman.getPosition().getX()-1][pacman.getPosition().getY()].isBox()) {
                    if (map.getCoordinates()[pacman.getPosition().getX() - 1][pacman.getPosition().getY()].isPoint()) {
                        map.points++;
                        map.updatePointer();
                        layout.getChildren().remove(
                                map.getCoordinates()[pacman.getPosition().getX() - 1][pacman.getPosition().getY()].getHoldedObject()
                        );;
                    }
                    map.getCoordinates()[pacman.getPosition().getX()-1][pacman.getPosition().getY()].makePacman();
                    map.getCoordinates()[pacman.getPosition().getX()][pacman.getPosition().getY()].makeEmpty();
                    pacman.setPosition(new Coordinate(pacman.getPosition().getX()-1, pacman.getPosition().getY()));
                }
                pacman.rotateLeft();
            }
        });


        primaryStage.setScene(new Scene(layout, 20*50, 12*50));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pac - Man");
        primaryStage.show();
        layout.requestFocus();
    }



}