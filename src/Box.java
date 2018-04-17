import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Box extends Rectangle{

    public Box(Coordinate coordinate) {
        super(coordinate.getX()*50, coordinate.getY()*50, 50,50);
        setFill(Color.BLACK);
        setStroke(Color.BLUE);
        setArcHeight(15);
        setArcWidth(15);
    }

}
