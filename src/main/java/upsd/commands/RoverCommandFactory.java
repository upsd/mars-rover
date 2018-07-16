package upsd.commands;

import upsd.models.Plateau;
import upsd.orientation_and_direction.Direction;

public class RoverCommandFactory {

    private static String MOVE = "M";
    private static String RIGHT = "R";
    private static String LEFT = "L";
    private static Plateau plateau;

    public RoverCommandFactory(Plateau plateau) {
        this.plateau = plateau;
    }

    public RoverCommand get(String command) {

        if (command.equals(MOVE)) {
            return new MoveCommand(plateau);
        }

        if (command.equals(RIGHT)) {
            return new TurnCommand(Direction.RIGHT);
        }

        if (command.equals(LEFT)) {
            return new TurnCommand(Direction.LEFT);
        }
        return null;
    }
}
