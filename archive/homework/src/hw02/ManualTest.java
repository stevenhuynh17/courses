package hw02;

import java.io.PrintWriter;

public class ManualTest {
    public static void main(String[] args) {
        // prints (100.0, 0.0)
        System.out.println(Coord.fromAngleAndDistance(0, 100));
        // prints (0.0, -100.0)
        System.out.println(Coord.fromAngleAndDistance(3 * Math.PI / 2, 100));
        // prints (0.0, -100.0)
        System.out.println(Coord.fromAngleAndDistance(7 * Math.PI / 2, 100));
        System.out.println();

        // prints 8 coordinates (order does not matter) that look like this:
        // (1.000000,   0.000000)
        // (0.707107,   0.707107)
        // (0.000000,   1.000000)
        // (-0.707107,  0.707107)
        // (-1.000000,  0.000000)
        // (-0.707107, -0.707107)
        // (0.000000,  -1.000000)
        // (0.707107,  -0.707107)
        RegularPolygon octagon = new RegularPolygon(8);
        for (Coord c : octagon.getCoords()) {
            System.out.println(c);
        }
        System.out.println();

        // prints 4 coordinates (order does not matter):
        // (5.000000, 5.000000)
        // (-5.000000, 5.000000)
        // (-5.000000, -5.000000)
        // (5.000000, -5.000000)
        Square square = new Square(10);
        for (Coord c : square.getCoords()) {
            System.out.println(c);
        }
        System.out.println();

        // order does not matter:
        // (25.000000, 45.000000)
        // (15.000000, 45.000000)
        // (15.000000, 35.000000)
        // (25.000000, 35.000000)
        square.translate(Coord.fromXAndY(20, 40));
        for (Coord c : square.getCoords()) {
            System.out.println(c);
        }
        System.out.println();

        // order does not matter:
        // (-14.142136, 49.497475)
        // (-21.213203, 42.426407)
        // (-14.142136, 35.355339)
        // (-7.071068, 42.426407)
        square.rotateAboutOrigin(Math.PI / 4);
        for (Coord c : square.getCoords()) {
            System.out.println(c);
        }
        System.out.println();

        // undo the previous rotation
        square.rotateAboutOrigin(-Math.PI / 4);
        // order does not matter:
        // (250.000000, 450.000000)
        // (150.000000, 450.000000)
        // (150.000000, 350.000000)
        // (250.000000, 350.000000)
        square.scale(10);
        for (Coord c : square.getCoords()) {
            System.out.println(c);
        }
        System.out.println();
        
//        Triangle test = new Triangle(3);
//        for (Coord c : t.getCoords()) {
//            System.out.println(c);
//        }
//        System.out.println();

        // <svg viewBox="-100 -100 200 200" preserveAspectRatio="xMinYMin">
        //   <polygon points="0.0,0.0 50.0,0.0 0.0,50.0" fill="#ff7f00"/>
        // </svg>
        Drawer drawer = new SVGDrawer(new PrintWriter(System.out));
        // Since this is a demo, we just draw a single triangle instead of multiple.
        drawer.drawTriangle(
                new Triangle(
                        Coord.fromXAndY(0, 0),
                        Coord.fromXAndY(50, 0),
                        Coord.fromXAndY(0, 50)),
                new Color(1.0, 0.5, 0.0));
        drawer.render();
    }
}
