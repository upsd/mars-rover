package upsd;

import org.junit.Test;
import upsd.controllers.RoverController;
import upsd.exceptions.OutOfBoundsException;
import upsd.models.Plateau;
import upsd.models.Rover;
import upsd.orientation_and_direction.Orientation;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoverControllerShould {

    @Test
    public void add_rover() {
        Plateau plateau = new Plateau(2, 2);
        Rover rover = new Rover(1, 1, 1, Orientation.NORTH, plateau);
        RoverController roverController = new RoverController(plateau, null);

        roverController.add(rover);

        Optional<Rover> roverFound = roverController.getRoverAt(1, 1);

        assertThat(roverFound.get(), is(rover));
    }

    @Test(expected = OutOfBoundsException.class)
    public void throws_exception_if_out_of_bounds() {
        Plateau plateau = new Plateau(1, 1);
        Rover roverThatWillBeOutOfBounds = new Rover(1, 2, 2, Orientation.NORTH, plateau);
        RoverController roverController = new RoverController(plateau, null);

        roverController.add(roverThatWillBeOutOfBounds);
    }
}
