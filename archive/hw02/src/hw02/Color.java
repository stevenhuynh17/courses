package hw02;

public class Color {
    private double red, green, blue;

    public Color(double red, double green, double blue) {
        if (red < 0 || red > 1 || green < 0 || green > 1 || blue < 0 || blue > 1) {
            throw new IllegalArgumentException("Color red/green/blue values must all be between 0 and 1.");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String htmlColorCode() {
        int r = (int)(red * 255);
        int g = (int)(green * 255);
        int b = (int)(blue * 255);
        return String.format("#%02x%02x%02x", r, g, b);
    }

    @Override
    public String toString() {
        return htmlColorCode();
    }
}
