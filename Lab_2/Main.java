public class Main {

    public static void main(String[] args) {

        Sphere s = new Sphere(3, "Red");
        Cylinder c = new Cylinder(2, 5, "Blue");
        Parallelepiped p = new Parallelepiped(2,3,4,"Green");

        System.out.println("Sphere volume: " + s.volume());
        System.out.println("Cylinder volume: " + c.volume());
        System.out.println("Parallelepiped volume: " + p.volume());

        System.out.println("Created spheres: " + Sphere.getCounter());
    }
}