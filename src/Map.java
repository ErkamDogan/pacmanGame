import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Map {
    int points = 0;
    Text pointsEarned;
    public static Coordinate[][] getCoordinates() {
        return coordinates;
    }

    private static Coordinate[][] coordinates = new Coordinate[20][12];
    private Pane layout;
    public Map(Pane _layout){
        layout = _layout;
        setCoordinates();
        createMap();
        createPoints();
        pointsEarned = new Text("Points: " + points);
        pointsEarned.setFill(Color.WHITE);
        pointsEarned.setX(17*50);
        pointsEarned.setY(25);
        layout.getChildren().add(pointsEarned);
    }
    private void createMap() {
        for(int i = 0; i < 20; i++) {
            coordinates[i][0].makeBox();
            coordinates[i][0].setHoldedObject(new Box(coordinates[i][0]));
            layout.getChildren().add(coordinates[i][0].getHoldedObject());
            coordinates[i][11].makeBox();
            coordinates[i][11].setHoldedObject(new Box(coordinates[i][11]));
            layout.getChildren().add(coordinates[i][11].getHoldedObject());
            if (i > 2 && i < 17) {
                coordinates[i][2].makeBox();
                coordinates[i][2].setHoldedObject(new Box(coordinates[i][2]));
                layout.getChildren().add(coordinates[i][2].getHoldedObject());
                coordinates[i][9].makeBox();
                coordinates[i][9].setHoldedObject(new Box(coordinates[i][9]));
                layout.getChildren().add(coordinates[i][9].getHoldedObject());
                if (i > 3 && i < 8 || i < 16 && i > 11) {
                    coordinates[i][4].makeBox();
                    coordinates[i][4].setHoldedObject(new Box(coordinates[i][4]));
                    layout.getChildren().add(coordinates[i][4].getHoldedObject());
                    coordinates[i][7].makeBox();
                    coordinates[i][7].setHoldedObject(new Box(coordinates[i][7]));
                    layout.getChildren().add(coordinates[i][7].getHoldedObject());
                }
            }
            if (i > 0 && i < 11) {
                coordinates[0][i].makeBox();
                coordinates[0][i].setHoldedObject(new Box(coordinates[0][i]));
                layout.getChildren().add(coordinates[0][i].getHoldedObject());
                coordinates[19][i].makeBox();
                coordinates[19][i].setHoldedObject(new Box(coordinates[19][i]));
                layout.getChildren().add(coordinates[19][i].getHoldedObject());
            }
        }
        coordinates[9][5].makeBox();
        coordinates[9][5].setHoldedObject(new Box(coordinates[9][5]));
        layout.getChildren().add(coordinates[9][5].getHoldedObject());
        coordinates[10][5].makeBox();
        coordinates[10][5].setHoldedObject(new Box(coordinates[10][5]));
        layout.getChildren().add(coordinates[10][5].getHoldedObject());
        coordinates[9][6].makeBox();
        coordinates[9][6].setHoldedObject(new Box(coordinates[9][6]));
        layout.getChildren().add(coordinates[9][6].getHoldedObject());
        coordinates[10][6].makeBox();
        coordinates[10][6].setHoldedObject(new Box(coordinates[10][6]));
        layout.getChildren().add(coordinates[10][6].getHoldedObject());

    }

    private void setCoordinates() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 12; j++) {
                coordinates[i][j] = new Coordinate(i, j);
                coordinates[i][j].makeEmpty();
//                layout.getChildren().add(new Box(coordinates[i][j]));
            }
        }
    }

    public void resetPoints() {
        points = 0;
        updatePointer();
        for(int i = 0; i< 12; i++) {
            for (int j = 0; j < 20; j++) {
                if (coordinates[j][i].isEmpty()) {
                    if (coordinates[j][i].getHoldedObject() != null) {
                        if (coordinates[j][i].getHoldedObject() instanceof Point) {
                            layout.getChildren().add(coordinates[j][i].getHoldedObject());
                            coordinates[j][i].makePoint();
                        }
                    }
                }
            }
        }
    }
    public void updatePointer() {
        if(points == 60) {
            pointsEarned.setText("Congratulations!");
        }else {
            pointsEarned.setText("Points: " + points);
        }
    }
    public void printCurrent() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.printf("%s ",coordinates[j][i].isEmpty()?"1":"0");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void createPoints() {
        for(int i = 2; i < 18; i++) {
            coordinates[i][1].makePoint();
            coordinates[i][1].setHoldedObject(new Point(coordinates[i][1]));
            layout.getChildren().add(coordinates[i][1].getHoldedObject());
            coordinates[i][10].makePoint();
            coordinates[i][10].setHoldedObject(new Point(coordinates[i][10]));
            layout.getChildren().add(coordinates[i][10].getHoldedObject());
            if (i > 3 && i < 8 || i > 11 && i < 16) {
                coordinates[i][3].makePoint();
                coordinates[i][3].setHoldedObject(new Point(coordinates[i][3]));
                layout.getChildren().add(coordinates[i][3].getHoldedObject());
                coordinates[i][8].makePoint();
                coordinates[i][8].setHoldedObject(new Point(coordinates[i][8]));
                layout.getChildren().add(coordinates[i][8].getHoldedObject());
            }
            if (i > 7 && i < 12) {
                coordinates[i][4].makePoint();
                coordinates[i][4].setHoldedObject(new Point(coordinates[i][4]));
                layout.getChildren().add(coordinates[i][4].getHoldedObject());
                coordinates[i][7].makePoint();
                coordinates[i][7].setHoldedObject(new Point(coordinates[i][7]));
                layout.getChildren().add(coordinates[i][7].getHoldedObject());
            }

            if (i > 4 && i < 7) {
                coordinates[8][i].makePoint();
                coordinates[8][i].setHoldedObject(new Point(coordinates[8][i]));
                layout.getChildren().add(coordinates[8][i].getHoldedObject());
                coordinates[11][i].makePoint();
                coordinates[11][i].setHoldedObject(new Point(coordinates[11][i]));
                layout.getChildren().add(coordinates[11][i].getHoldedObject());
            }
        }
    }
}
