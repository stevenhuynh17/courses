package hw02;

// https://en.wikipedia.org/wiki/Regular_polygon
public class RegularPolygon extends Drawable {
    // The implementation below is ONLY a suggestion. You may use a different internal representation
    // for your Regular Polygon if you want to.
    private Coord[] coords;
    private Coord center;

    /**
     * Construct a regular polygon where the first Coord is on the x-axis (at Coord.fromXAndY(1, 0)
     * and all Coords are 1.0 distance from the origin.
     * @param numSides
     */
    public RegularPolygon(int numSides) {
        coords = new Coord[numSides];
        for (int i = 0; i < numSides; i++) {
            coords[i] = Coord.fromAngleAndDistance(i * 2 * Math.PI / numSides, 1.0);
        }
        center = Coord.origin();
    }

    public Coord[] getCoords() {
        return coords;
    }

    public void draw(Drawer drawer, Color color) {
        // TODO
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
