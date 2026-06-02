public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private double gpa;

    public Student(String firstName, String lastName, int age, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                ", возраст: " + age +
                ", средний балл: " + gpa;
    }
}