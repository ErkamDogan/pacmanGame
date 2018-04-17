import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class Pacman extends Arc {
    private Coordinate position;

    public Pacman() {
        super(75, 75, 20, 20, 45, 270);
        setFill(Color.rgb(253, 255,0));
        setType(ArcType.ROUND);
        position = new Coordinate(1, 1);

    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
        move(position);
    }

    public void move(Coordinate position) {
        setCenterX(position.getX()*50 + 25);
        setCenterY(position.getY()*50 + 25);
    }

    //Rotation
    public void rotateUp() {
        setStartAngle(135);
    }

    public void rotateRight() {
        setStartAngle(45);
    }

    public void rotateDown() {
        setStartAngle(315);
    }

    public void rotateLeft() {
        setStartAngle(225);
    }
}
