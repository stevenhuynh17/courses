package hw02;

public class Coord {
    // TODO: Add the members like "double x, y" to represent this coordinate.

    public static Coord fromXAndY(double x, double y) {
        // TODO
    }

    public static Coord fromAngleAndDistance(double angle, double distance) {
        // TODO
    }

    public Coord(Coord other) {
        // this(...);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public String toString() {
        return String.format("(%f, %f)", getX(), getY());
    }
}