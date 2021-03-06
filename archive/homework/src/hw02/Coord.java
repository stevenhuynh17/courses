package hw02;

public class Coord {
    // TODO: Add the members like "double x, y" to represent this coordinate.
	private double x, y;
	Coord origin;
	
	private Coord(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Coord(Coord other) {
//      this(...);
		this.origin = other;
    }

    public static Coord fromXAndY(double x, double y) {
        // TODO
    	return new Coord(x, y);
    }

    public static Coord fromAngleAndDistance(double angle, double distance) {
    	double x = Math.cos(angle) * distance;
    	double y = Math.sin(angle) * distance;
		return fromXAndY(x, y);
        // TODO
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

	public static Coord origin() {
		// TODO Auto-generated method stub
		return new Coord(0, 0);
	}
}
