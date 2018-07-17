package upsd.commands;

import upsd.models.Plateau;
import upsd.models.Rover;

public class MoveCommand implements RoverCommand {

    private Plateau plateau;

    public MoveCommand(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public Rover execute(Rover rover) {
        return rover.move();
    }
}
