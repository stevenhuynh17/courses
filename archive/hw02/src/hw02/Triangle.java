package hw02;


public class Triangle extends Drawable {
    // TODO: Add members to represent the triangle

    public Triangle(Triangle other) {
        // TODO
    }

    public Triangle(Coord a, Coord b, Coord c) {
        // TODO
    }

    public Triangle(Coord[] coords) {
        // TODO
        // Should throw IllegalArgumentException if coords.length != 3.
    }

    public Coord[] getCoords() {
        // TODO
    }

    public void draw(Drawer drawer, Color color) {
        drawer.drawTriangle(this, color);
    }

    public void translate(Coord amount) {
        // TODO
    }

    public void rotateAboutOrigin(double radians) {
        // TODO
    }

    public void scale(double size) {
        // TODO
    }
}
