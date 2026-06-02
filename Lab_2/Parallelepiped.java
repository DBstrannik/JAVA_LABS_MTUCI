public class Parallelepiped extends Shape {

    private double length;
    private double width;
    private double height;

    public Parallelepiped() {
        super();
        length = width = height = 1;
    }

    public Parallelepiped(double length, double width, double height, String color) {
        super("Parallelepiped", color, 1.0);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double volume() {
        return length * width * height;
    }

    @Override
    public double surfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }
}