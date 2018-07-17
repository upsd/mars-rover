package upsd.models;

public class FacingEastState implements RoverState {

    private Plateau plateau;

    public FacingEastState(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public Rover move(Rover rover) {
        int newX = rover.x() + rover.speed();

        if (newX > plateau.maxX()) {
            newX = plateau.minX();
        }

        return new Rover(rover.id(), newX, rover.y(), rover.orientation(), plateau);
    }
}
