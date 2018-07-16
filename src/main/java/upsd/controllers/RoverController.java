package upsd.controllers;

import upsd.commands.RoverCommand;
import upsd.commands.RoverCommandFactory;
import upsd.exceptions.OutOfBoundsException;
import upsd.models.Plateau;
import upsd.models.Rover;
import upsd.orientation_and_direction.OrientationCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoverController {

    private final Plateau plateau;
    private List<Rover> rovers = new ArrayList<>();
    private Map<Integer, String> roverAndInstructions;

    public RoverController(Plateau plateau, Map<Integer, String> roverAndInstructions) {
        this.plateau = plateau;
        this.roverAndInstructions = roverAndInstructions;
    }

    public void add(Rover roverToAdd) {
        if (isOutOfBounds(roverToAdd)) {
            throw new OutOfBoundsException();
        }
        this.rovers.add(roverToAdd);
    }

    private void sendCommandTo(int id, String command) {
        Rover foundRover = getRoverById(id);
        int index = rovers.indexOf(foundRover);
        RoverCommandFactory factory = new RoverCommandFactory(plateau);

        RoverCommand roverCommand = factory.get(command);

        rovers.set(index, roverCommand.execute(foundRover));
    }

    private boolean isOutOfBounds(Rover roverToAdd) {
        return roverToAdd.x() > plateau.maxX()
                || roverToAdd.x() < plateau.minX()
                || roverToAdd.y() > plateau.maxY()
                || roverToAdd.y() < plateau.minY();
    }

    public void processInstructionsForEachRover() {
        roverAndInstructions
                .entrySet()
                .forEach(entry -> {
                    int id = entry.getKey();
                    String instructions = entry.getValue();

                    for (String command : instructions.split("")) {
                        sendCommandTo(id, command);
                    }
                });
    }

    Rover getRoverById(int id) {
        return this.rovers
                .stream()
                .filter(rover -> rover.id() == id)
                .findFirst()
                .get();
    }

    public Optional<Rover> getRoverAt(int x, int y) {
        return this.rovers
                .stream()
                .filter(rover -> rover.x() == x && rover.y() == y)
                .findFirst();
    }

    public String getReport() {
        return this.roverAndInstructions
                .entrySet()
                .stream()
                .map(entry -> {
                    int id = entry.getKey();
                    Rover rover = getRoverById(id);
                    return rover.x() + " " + rover.y() + " " + OrientationCalculator.abbreviationOf(rover.orientation());
                })
                .collect(Collectors.joining("\n"));
    }
}