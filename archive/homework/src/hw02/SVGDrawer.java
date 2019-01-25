package hw02;

import java.io.PrintWriter;

public class SVGDrawer extends Drawer {
    private PrintWriter writer;

    public SVGDrawer(PrintWriter writer) {
        this.writer = writer;
        writer.println("<svg viewBox=\"-100 -100 200 200\" preserveAspectRatio=\"xMinYMin\">");
    }

    public void drawTriangle(Triangle triangle, Color color) {
    	triangle = new Triangle(triangle);

        Coord[] coords = triangle.getCoords();
        
        String svgPolygon = String.format(
                "  <polygon points=\"%f,%f %f,%f %f,%f\" fill=\"%s\"/>",
                coords[0].getX(), coords[0].getY(),
                coords[1].getX(), coords[1].getY(),
                coords[2].getX(), coords[2].getY(), color.htmlColorCode());
        writer.println(svgPolygon);
    }

    public void render() {
        writer.println("</svg>");
        writer.close();
    }
}
