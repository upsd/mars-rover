package upsd.models;

public class FacingWestState implements RoverState {

    private Plateau plateau;

    public FacingWestState(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public Rover move(Rover rover) {
        int newX = rover.x() - rover.speed();

        if (newX < plateau.minX()) {
            newX = plateau.maxX();
        }

        return new Rover(rover.id(), newX, rover.y(), rover.orientation(), plateau);
    }
}
