package hw02;

public class Square extends RegularPolygon {
    /**
     * Construct a square with sideLength
     * and it's sides parallel/perpendicular to the x and y axis.
     */
    public Square(double sideLength) {
        super(4);
        rotateAboutOrigin(Math.PI / 4.0);
        scale(sideLength / Math.sqrt(2.0));
    }

    // TODO/OPTIONAL: Override the draw(...) method to draw using only two triangles instead of four.
}
