public class Giyo extends Ghost {
    public Giyo(int x, int y) {
        super("resources/ghost_giyo.png", x, y);
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
