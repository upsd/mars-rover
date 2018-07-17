package upsd;

import upsd.controllers.RoverController;
import upsd.input.InputParser;
import upsd.models.Plateau;

public class MarsRoverSimulator {

    private final Plateau plateau;
    private RoverController roverController;

    public MarsRoverSimulator(String input) {
        int[] dimensions = InputParser.parseDimensionsFrom(input);
        this.plateau = new Plateau(dimensions[0], dimensions[1]);
        roverController = new RoverController(plateau, InputParser.parseInstructionsFrom(input));

        addRoversToController(input);
        roverController.processInstructionsForEachRover();
    }

    private void addRoversToController(String input) {
        InputParser.parseRoversFrom(input, plateau)
                .stream()
                .forEach(rover -> this.roverController.add(rover));
    }

    public String getReport() {
        return roverController.getReport();
    }
}
