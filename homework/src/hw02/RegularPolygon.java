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
    	for(int i=1; i < coords.length; i++) {
    		drawer.drawTriangle(new Triangle(this.center, coords[i-1], coords[i]), color);
    	}
    	
    }

    public void translate(Coord amount) {
        // TODO
    	for(int i = 0; i < coords.length; i++) {
    		double x = coords[i].getX() + amount.getX();
    		double y = coords[i].getY() + amount.getY();
    		
    		double new_distance = Math.sqrt(x*x + y*y);
    		double current_angle = Math.atan2(y, x);
    		coords[i] = Coord.fromAngleAndDistance(current_angle, new_distance);
    	}
    }

    public void rotateAboutOrigin(double radians) {
        // TODO
    	for(int i = 0; i < coords.length; i++) {
    		double x = coords[i].getX();
    		double y = coords[i].getY();
    		
    		double distance = Math.sqrt(x*x + y*y);
    		double new_angle = Math.atan2(coords[i].getY(), coords[i].getX()) + radians;
    		
    		coords[i] = Coord.fromAngleAndDistance(new_angle, distance);
    	}
    }

    public void scale(double size) {
        // TODO
    	for(int i = 0; i < coords.length; i++) {
    		// Get the original coordinate and double it
    		double x = coords[i].getX();
    		double y = coords[i].getY();
    		
    		double new_distance = Math.sqrt(x*x + y*y) * size;
    		double current_angle = Math.atan2(coords[i].getY(), coords[i].getX());
    		coords[i] = Coord.fromAngleAndDistance(current_angle, new_distance);
    	}
    }
}
