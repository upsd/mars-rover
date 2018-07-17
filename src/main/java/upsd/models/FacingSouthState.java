package upsd.models;

public class FacingSouthState implements RoverState {

    private Plateau plateau;

    public FacingSouthState(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public Rover move(Rover rover) {
        int newY = rover.y() - rover.speed();

        if (newY < plateau.minY()) {
            newY = plateau.maxY();
        }

        return new Rover(rover.id(), rover.x(), newY, rover.orientation(), plateau);
    }
}
