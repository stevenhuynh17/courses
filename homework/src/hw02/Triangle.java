package hw02;


public class Triangle extends Drawable {
    // TODO: Add members to represent the triangle
	private Coord[] coords;
	private Coord center;
	private Coord point1, point2, point3;
	
    public Triangle(Triangle other) {
        // TODO
    	this.coords = other.getCoords();
    }

    public Triangle(Coord a, Coord b, Coord c) {
        // TODO
    	this.coords = new Coord[3];
    	coords[0] = a;
    	coords[1] = b;
    	coords[2] = c;
  
//    	System.out.println("TESTING");
//    	System.out.println(coords[0].toString());
//    	System.out.println(coords[1].toString());
//    	System.out.println(coords[2].toString());
//    	System.out.println(this.getCoords());
    	
    }

    public Triangle(Coord[] coords) {
        // TODO
        // Should throw IllegalArgumentException if coords.length != 3.
    	if(coords.length !=3 ) {
    		throw new IllegalArgumentException("Sides provided does not make a triangle!");
    	}
    	
    	for(int i=0; i < coords.length; i++) {
//    		System.out.println(coords[i]);
    	}
    }

    public Coord[] getCoords() {
        // TODO
    	return coords;
    }

    public void draw(Drawer drawer, Color color) {
    	System.out.println(coords[0].toString());
    	System.out.println(coords[1].toString());
    	System.out.println(coords[2].toString());
        drawer.drawTriangle(new Triangle(coords[0], coords[1], coords[2]), color);
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
    	for(int i=0; i < coords.length; i++) {
    		double x = coords[i].getX() * size;
    		double y = coords[i].getY() * size;
    		
    		coords[i] = Coord.fromXAndY(x, y);
    	}
    }
}
