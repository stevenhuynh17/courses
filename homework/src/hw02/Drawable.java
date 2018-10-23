package hw02;

public class Drawable {
    /**
     * Draw the Drawable by calling drawer.drawTriangle(...) one or more times.
     */
    public void draw(Drawer drawer, Color color) { }
    /**
     * Move the Drawable by amount.
     * For example this.translate(Coord.fromXAndY(1.0, 0.0)) should move this 1.0 to the right.
     */
    public void translate(Coord amount) { }
    /**
     * Rotate the Drawable by radians.
     * For example, this.rotateAboutOrigin(Math.PI) is like rotating the entire XY Plane 180 degrees.
     * @param radians Angle in radians, rotating clockwise.
     */
    public void rotateAboutOrigin(double radians) { }
    /**
     * Multiply the size of the Drawable by size.
     * For example, this.scale(2) moves every part of this to be twice as far from the origin.
     * @param size
     */
    public void scale(double size) { }
}
