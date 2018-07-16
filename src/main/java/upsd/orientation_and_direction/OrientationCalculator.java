package upsd.orientation_and_direction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OrientationCalculator {

    private static HashMap<String, Orientation> abbreviationToOrientation = new HashMap<>();

    public static Orientation calculate(Orientation current, Direction turningDirection) {
        List<Orientation> directions = Arrays.asList(Orientation.NORTH, Orientation.EAST, Orientation.SOUTH, Orientation.WEST);

        int index = directions.indexOf(current);

        if (turningDirection.equals(Direction.RIGHT)) {
            if ((index + 1) < directions.size())
                return directions.get(index + 1);
            return directions.get(0);
        }

        if (turningDirection.equals(Direction.LEFT)) {
            if ((index - 1) >= 0)
                return directions.get(index - 1);
            return directions.get(directions.size() - 1);
        }
        return null;
    }

    public static Orientation orientationFrom(String orientationAsText) {
        initLookupTable();
        return abbreviationToOrientation.get(orientationAsText);
    }

    public static String abbreviationOf(Orientation orientation) {
        initLookupTable();
        return abbreviationToOrientation
                .entrySet()
                .stream()
                .filter(e -> e.getValue().equals(orientation))
                .findFirst()
                .get()
                .getKey();
    }

    private static void initLookupTable() {
        abbreviationToOrientation.put("N", Orientation.NORTH);
        abbreviationToOrientation.put("E", Orientation.EAST);
        abbreviationToOrientation.put("S", Orientation.SOUTH);
        abbreviationToOrientation.put("W", Orientation.WEST);
    }
}
