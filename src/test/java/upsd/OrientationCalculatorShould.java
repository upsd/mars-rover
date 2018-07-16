package upsd;

import org.junit.Test;
import upsd.orientation_and_direction.Direction;
import upsd.orientation_and_direction.Orientation;
import upsd.orientation_and_direction.OrientationCalculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrientationCalculatorShould {

    @Test
    public void be_west_when_facing_north_and_turn_left() {
        Orientation newOrientation = OrientationCalculator.calculate(Orientation.NORTH, Direction.LEFT);

        assertThat(newOrientation, is(Orientation.WEST));
    }

    @Test
    public void be_east_when_facing_north_and_turn_right() {
        Orientation newOrientation = OrientationCalculator.calculate(Orientation.NORTH, Direction.RIGHT);

        assertThat(newOrientation, is(Orientation.EAST));
    }

    @Test
    public void be_south_when_facing_east_and_turn_right() {
        Orientation newOrientation = OrientationCalculator.calculate(Orientation.EAST, Direction.RIGHT);

        assertThat(newOrientation, is(Orientation.SOUTH));
    }

    @Test
    public void be_north_when_facing_west_and_turn_right() {
        Orientation newOrientation = OrientationCalculator.calculate(Orientation.WEST, Direction.RIGHT);

        assertThat(newOrientation, is(Orientation.NORTH));
    }

    @Test
    public void return_north() {
        Orientation orientation = OrientationCalculator.orientationFrom("N");

        assertThat(orientation, is(Orientation.NORTH));
    }

    @Test
    public void return_east() {
        Orientation orientation = OrientationCalculator.orientationFrom("E");

        assertThat(orientation, is(Orientation.EAST));
    }

    @Test
    public void return_south() {
        Orientation orientation = OrientationCalculator.orientationFrom("S");

        assertThat(orientation, is(Orientation.SOUTH));
    }

    @Test
    public void return_west() {
        Orientation orientation = OrientationCalculator.orientationFrom("W");

        assertThat(orientation, is(Orientation.WEST));
    }

    @Test
    public void return_n() {
        assertThat(OrientationCalculator.abbreviationOf(Orientation.NORTH), is("N"));
    }

    @Test
    public void return_e() {
        assertThat(OrientationCalculator.abbreviationOf(Orientation.EAST), is("E"));
    }

    @Test
    public void return_s() {
        assertThat(OrientationCalculator.abbreviationOf(Orientation.SOUTH), is("S"));
    }

    @Test
    public void return_w() {
        assertThat(OrientationCalculator.abbreviationOf(Orientation.WEST), is("W"));
    }
}
