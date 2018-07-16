package upsd.models;

import upsd.orientation_and_direction.Orientation;

import java.util.Objects;

public class Rover {
    private final int x;
    private final int y;
    private final int id;
    private Orientation orientation;

    public Rover(int id, int x, int y, Orientation orientation) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public Orientation orientation() {
        return this.orientation;
    }

    public int id() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return x == rover.x &&
                y == rover.y &&
                id == rover.id &&
                Objects.equals(orientation, rover.orientation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, id, orientation);
    }
}
