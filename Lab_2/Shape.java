public abstract class Shape {

    protected String name;
    protected String color;
    protected double density;

    public Shape() {
        this.name = "Unknown";
        this.color = "White";
        this.density = 1.0;
    }

    public Shape(String name, String color, double density) {
        this.name = name;
        this.color = color;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double volume();

    public abstract double surfaceArea();
}