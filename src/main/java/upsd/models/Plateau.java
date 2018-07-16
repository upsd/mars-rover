package upsd.models;

public class Plateau {

    private final int maxX;
    private final int maxY;

    private int MINIMUM_X_PLATEAU = 1;
    private int MINIMUM_Y_PLATEAU = 1;

    public Plateau(int upperRightX, int upperRightY) {
        this.maxX = upperRightX;
        this.maxY = upperRightY;
    }

    public int minX() {
        return MINIMUM_X_PLATEAU;
    }

    public int maxX() {
        return maxX;
    }

    public int minY() {
        return MINIMUM_Y_PLATEAU;
    }

    public int maxY() {
        return maxY;
    }
}
