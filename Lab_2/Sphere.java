public class Sphere extends Shape {

    private double radius;
    private static int counter = 0;

    public Sphere() {
        super();
        radius = 1;
        counter++;
    }

    public Sphere(double radius, String color) {
        super("Sphere", color, 1.0);
        this.radius = radius;
        counter++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    public static int getCounter() {
        return counter;
    }
}