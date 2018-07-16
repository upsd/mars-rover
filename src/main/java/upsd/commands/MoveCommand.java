package upsd.commands;

import upsd.models.Plateau;
import upsd.models.Rover;
import upsd.orientation_and_direction.Orientation;

public class MoveCommand implements RoverCommand {

    private Plateau plateau;

    public MoveCommand(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public Rover execute(Rover rover) {
        int newX = rover.x();
        int newY = rover.y();
        int roverSpeed = 1;

        if (rover.orientation().equals(Orientation.NORTH)) {
            newY = moveNorthwards(roverSpeed, rover.y());
        }
        if (rover.orientation().equals(Orientation.EAST)) {
            newX = moveEastwards(roverSpeed, rover.x());
        }
        if (rover.orientation().equals(Orientation.SOUTH)) {
            newY = moveSouthwards(roverSpeed, rover.y());
        }
        if (rover.orientation().equals(Orientation.WEST)) {
            newX = moveWestwards(rover, roverSpeed);
        }

        return new Rover(rover.id(), newX, newY, rover.orientation());
    }

    private int moveWestwards(Rover foundRover, int roverSpeed) {
        int newX = foundRover.x() - roverSpeed;

        if (newX < plateau.minX()) {
            newX = plateau.maxX();
        }

        return newX;
    }

    private int moveSouthwards(int roverSpeed, int y) {
        int newY = y - roverSpeed;

        if (newY < plateau.minY()) {
            newY = plateau.maxY();
        }

        return newY;
    }

    private int moveEastwards(int roverSpeed, int x) {
        int newX = x + roverSpeed;

        if (newX > plateau.maxX()) {
            newX = plateau.minX();
        }

        return newX;
    }

    private int moveNorthwards(int roverSpeed, int y) {
        int newY = y + roverSpeed;

        if (newY > plateau.maxY()) {
            newY = plateau.minY();
        }

        return newY;
    }
}
