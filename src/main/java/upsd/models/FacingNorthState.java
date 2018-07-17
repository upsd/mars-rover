package upsd.models;

public class FacingNorthState implements RoverState {

    private Plateau plateau;

    public FacingNorthState(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public Rover move(Rover rover) {
        int newX = rover.x();
        int newY = rover.y() + rover.speed();

        if (newY > plateau.maxY()) {
            newY = plateau.minY();
        }

        return new Rover(rover.id(), newX, newY, rover.orientation(), plateau);
    }
}
