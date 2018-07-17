package upsd.models;

import upsd.orientation_and_direction.Orientation;

public class RoverStateFactory {


    public RoverState getState(Plateau plateau, Orientation roverOrientation) {
        if (roverOrientation.equals(Orientation.NORTH)) {
            return new FacingNorthState(plateau);
        }
        if (roverOrientation.equals(Orientation.EAST)) {
            return new FacingEastState(plateau);
        }
        if (roverOrientation.equals(Orientation.SOUTH)) {
            return new FacingSouthState(plateau);
        }
        if (roverOrientation.equals(Orientation.WEST)) {
            return new FacingWestState(plateau);
        }
        return null;
    }
}
