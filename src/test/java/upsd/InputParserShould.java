package upsd;

import org.junit.Test;
import upsd.input.InputParser;
import upsd.models.Rover;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputParserShould {

    private String input = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

    @Test
    public void parse_rovers_from_input() {
        List<Rover> rovers = InputParser.parseRoversFrom(input);

        assertThat(rovers.size(), is(2));
    }

    @Test
    public void parse_instructions_from_input() {
        Map<Integer, String> instructions = InputParser.parseInstructionsFrom(input);

        assertThat(instructions.size(), is(2));
    }

    @Test
    public void parse_upper_right_dimensions_from_input() {
        int[] dimensions = InputParser.parseDimensionsFrom(input);

        assertThat(dimensions[0], is(5));
        assertThat(dimensions[1], is(5));
    }
}
