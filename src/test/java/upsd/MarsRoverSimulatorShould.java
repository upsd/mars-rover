package upsd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarsRoverSimulatorShould {
    
    @Test
    public void end_in_correct_position_for_multiple_rovers() {
        String input = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

        MarsRoverSimulator simulator = new MarsRoverSimulator(input);
        String report = simulator.getReport();

        assertThat(report, is("1 3 N\n5 1 E"));
    }
}
