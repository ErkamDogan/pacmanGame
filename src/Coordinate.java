import javafx.scene.Node;

public class Coordinate {
    private int x;
    private int y;
    private int type;
    private Node holdedObject;

    /**
     * type attributes
     * 0 -- Empty
     * 1 -- Box
     * 2 -- Point
     * 3 -- Pacman
     */


    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
        this.type = 0;
    }

    public void setHoldedObject(Node holdedObject) {
        this.holdedObject = holdedObject;
    }

    public Node getHoldedObject(){
        if (holdedObject == null) {

        }
        return holdedObject;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEmpty() {
        return type == 0;
    }

    public boolean isBox() {
        return type == 1;
    }
    public boolean isPoint() {
        return type == 2;
    }
    public boolean isPacman() {
        return type == 3;
    }

    public void makeEmpty() {
        type = 0;
    }

    public void makeBox() {
        type = 1;
    }

    public void makePoint() {
        type = 2;
    }

    public void makePacman() {
        type = 3;
    }

    public String toString() {
        return "[" + x + ", " + y + "] = " +   (isEmpty()?"Empty":( (isBox()?"Box":(isPoint()?"Point":"Pacman"))));
    }

}
