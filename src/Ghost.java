

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public abstract class Ghost  extends ImageView implements AI{
    private static final int GHOST_WIDTH = 40;
    private static final int GHOST_HEIGHT = 40;
    protected Directions lastDirection = Directions.LEFT;
    protected Directions curDirection;

    protected final int ATTACK = 280;
    protected final int SCATTER = 100;

    private int scoreValue;
    private boolean scatter;

    protected boolean isAttacking = false;
    private Coordinate position;
    private Coordinate[][] mapCoordinates;

    public Ghost(String imgPath, int x, int y){
        super(new Image(imgPath));
        super.setFitWidth(GHOST_WIDTH);
        super.setFitHeight(GHOST_HEIGHT);
        super.setLayoutX(x*50+25);
        super.setLayoutY(y*50+25);
        position = new Coordinate(x,y);
        mapCoordinates = Map.getCoordinates();
    }

    public Directions getMove(){
        return curDirection;
    }
    protected abstract Directions getAIMove();

    public boolean moveIsAllowed(Directions d)
    {
        if (d == Directions.UP && position.getX()>1 && !mapCoordinates[position.getX()][position.getY()-1].isBox())
            return true;
        if (d == Directions.DOWN && position.getY()<20*50 && !mapCoordinates[position.getX()][position.getY()+1].isBox())
            return true;
        if (d == Directions.LEFT && position.getY()>1 && !mapCoordinates[position.getX()-1][position.getY()].isBox())
            return true;
        if (d == Directions.RIGHT&& position.getX()<49 && !mapCoordinates[position.getX()+1][position.getY()].isBox())
            return true;
        else
            return false;
    }
    //Bu method ghostun şu anki methodunun target koordinata gitmesi için gereken yönünü verir
    protected void tryMove(int curX, int curY, int targetX, int targetY){
        int horizontalDifference = curX - targetX;
        int verticalDifference = curY - targetY;
        Directions preferredHorizontal = horizontalDifference > 0 ? Directions.LEFT : Directions.RIGHT;
        Directions preferredVertical = verticalDifference > 0 ? Directions.UP : Directions.DOWN;

        boolean verticalMoreImportant = Math.abs(verticalDifference) > Math.abs(horizontalDifference);
        if (verticalMoreImportant)
            curDirection = preferredVertical;
        else
            curDirection = preferredHorizontal;
        if (!this.moveIsAllowed(curDirection)) {
            if (verticalMoreImportant) {
                if (lastDirection == Directions.LEFT || lastDirection == Directions.RIGHT) {
                    curDirection = lastDirection;
                    if (!this.moveIsAllowed(curDirection))
                        curDirection = curDirection == Directions.LEFT ? Directions.RIGHT : Directions.LEFT;
                } else {
                    curDirection = preferredHorizontal;
                    if (!this.moveIsAllowed(curDirection)) {
                        curDirection = preferredHorizontal == Directions.LEFT ? Directions.RIGHT : Directions.LEFT;
                        if (!this.moveIsAllowed(curDirection))
                            curDirection = preferredVertical == Directions.UP ? Directions.DOWN : Directions.UP;
                    }
                }
            } else {
                if (lastDirection == Directions.UP || lastDirection == Directions.DOWN) {
                    curDirection = lastDirection;
                    if (!this.moveIsAllowed(curDirection))
                        curDirection = curDirection == Directions.UP ? Directions.DOWN : Directions.UP;
                } else {
                    curDirection = preferredVertical;
                    if (!this.moveIsAllowed(curDirection)) {
                        curDirection = preferredVertical == Directions.UP ? Directions.DOWN : Directions.UP;
                        if (!this.moveIsAllowed(curDirection))
                            curDirection = preferredHorizontal == Directions.LEFT ? Directions.RIGHT : Directions.LEFT;
                    }
                }
            }
        }
    }
    //Şu anki koordinattan gönderilen koordinata doğru gidilmesi gerekn yönü belirtip bir birim yer değiştirir.
public void move(Coordinate pacPosition){
        tryMove(position.getX(),position.getY(),pacPosition.getX(),pacPosition.getY());
        if(curDirection == Directions.LEFT){
            position = new Coordinate(position.getX()-1,position.getY());
        }
        else if(curDirection == Directions.DOWN){
            position = new Coordinate(position.getX(),position.getY()+1);
        }
        else if(curDirection == Directions.RIGHT){
            position = new Coordinate(position.getX()+1,position.getY());
        }else if(curDirection == Directions.UP){
            position = new Coordinate(position.getX(),position.getY()-1);
        }
    super.setLayoutX(position.getX()*50);
    super.setLayoutY(position.getY()*50);
}
    public abstract GhostType getGhostType();
    public abstract boolean checkDistance(double curDistanceDiff);

    public void scatter(){}
    public boolean isScatter(){return false;}
    public void unScatter(){}
}
