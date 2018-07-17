package upsd.input;

import upsd.models.Plateau;
import upsd.orientation_and_direction.Orientation;
import upsd.orientation_and_direction.OrientationCalculator;
import upsd.models.Rover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputParser {

    public static List<Rover> parseRoversFrom(String input, Plateau plateau) {
        String[] commands = getCommandsFrom(input);

        List<Rover> rovers = new ArrayList<>();

        for (int i = 1; i < commands.length; i += 2) {
            String position = commands[i];

            String[] startingInfo = position.split(" ");
            int x = Integer.parseInt(startingInfo[0]);
            int y = Integer.parseInt(startingInfo[1]);
            Orientation orientation = OrientationCalculator.orientationFrom(startingInfo[2]);

            rovers.add(new Rover(i, x, y, orientation, plateau));
        }

        return rovers;
    }

    public static Map<Integer, String> parseInstructionsFrom(String input) {
        String[] commands = getCommandsFrom(input);

        Map<Integer, String> roverAndInstructions = new HashMap<>();

        for (int i = 1; i < commands.length; i += 2) {
            roverAndInstructions.put(i, commands[i + 1]);
        }

        return roverAndInstructions;
    }

    public static int[] parseDimensionsFrom(String input) {
        String[] dimensions = getCommandsFrom(input)[0].split(" ");

        return new int[]{Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1])};
    }

    private static String[] getCommandsFrom(String input) {
        return input.split("\n");
    }

}