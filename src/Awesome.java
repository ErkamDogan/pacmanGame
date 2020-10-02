
//Blinky
public class Awesome extends Ghost {
    int minDistance= 15;
    public Awesome(int x, int y) {

        super("resources/ghost_awesome.png", x, y);
    }

    @Override
    protected Directions getAIMove() {
        return null;
    }
    public GhostType getGhostType(){ return GhostType.AWESOME;}
    public double getDistanceToPacman(int pacCurX, int pacCurY, int ghostCurX, int ghostCurY){
        double curDistanceDiff = Math.sqrt(Math.pow((pacCurX-ghostCurX),2)+ Math.pow((pacCurX-ghostCurX),2));
        return curDistanceDiff;}
    public boolean checkDistance(double curDistanceDiff){return minDistance < curDistanceDiff;}
}
