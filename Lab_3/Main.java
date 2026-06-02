import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        
        HashTable<String, Integer> table = new HashTable<>(10);

        table.put("apple", 5);
        table.put("banana", 3);
        table.put("orange", 7);

        System.out.println("HashTable:");
        System.out.println(table.get("apple"));
        table.remove("banana");
        System.out.println(table.size());

        HashMap<String, Student> students = new HashMap<>();

        students.put("12345", new Student("Иван", "Иванов", 20, 4.5));
        students.put("67890", new Student("Петр", "Петров", 21, 4.2));

        System.out.println("\nСтуденты:");
        System.out.println(students.get("12345"));

        students.remove("67890");

        System.out.println("\nПосле удаления:");
        System.out.println(students.get("67890"));
    }
}