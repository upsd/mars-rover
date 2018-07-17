package upsd.commands;

import upsd.models.Plateau;
import upsd.models.Rover;
import upsd.orientation_and_direction.Direction;
import upsd.orientation_and_direction.Orientation;
import upsd.orientation_and_direction.OrientationCalculator;

public class TurnCommand implements RoverCommand {

    private Direction direction;
    private Plateau plateau;

    public TurnCommand(Direction direction, Plateau plateau) {
        this.direction = direction;
        this.plateau = plateau;
    }

    @Override
    public Rover execute(Rover rover) {
        Orientation newOrientation = OrientationCalculator.calculate(rover.orientation(), this.direction);
        return new Rover(rover.id(), rover.x(), rover.y(), newOrientation, plateau);
    }
}
