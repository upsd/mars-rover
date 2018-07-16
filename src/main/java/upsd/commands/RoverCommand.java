package upsd.commands;

import upsd.models.Rover;

public interface RoverCommand {

    Rover execute(Rover rover);
}
