import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Point extends Circle {
    private Coordinate position;

    public Point(Coordinate position) {
        super(position.getX() * 50 + 25, position.getY() * 50 + 25, 3, Color.WHITE);
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

}
