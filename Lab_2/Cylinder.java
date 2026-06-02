public class Cylinder extends Shape {

    private double radius;
    private double height;

    public Cylinder() {
        super();
        radius = 1;
        height = 1;
    }

    public Cylinder(double radius, double height, String color) {
        super("Cylinder", color, 1.0);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}