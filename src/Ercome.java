public class Ercome extends Ghost {
    public Ercome( int x, int y) {
        super("resources/ghost_ercome.png", x, y);
    }

    @Override
    protected Directions getAIMove() {
        return null;
    }

    @Override
    public GhostType getGhostType() {
        return null;
    }

    @Override
    public boolean checkDistance(double curDistanceDiff) {
        return false;
    }
}
