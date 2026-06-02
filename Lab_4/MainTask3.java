import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

class CustomEmptyStackException extends Exception {
    public CustomEmptyStackException(String message) {
        super(message);
    }
}

class ExceptionLogger {
    
    private static final String LOG_FILE = "exceptions.log";

    public static void log(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println("[" + LocalDateTime.now() + "] Исключение: " 
                         + e.getClass().getName() + " - " + e.getMessage());
        } catch (IOException ioException) {
            System.out.println("Ошибка записи в лог-файл: " + ioException.getMessage());
        }
    }
}
class CustomStack {
    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomStack() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(int value) {
        if (size == elements.length) {
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size++] = value;
        System.out.println("Элемент " + value + " добавлен в стек.");
    }

    public int pop() throws CustomEmptyStackException {
        if (size == 0) {
            throw new CustomEmptyStackException("Критическая ошибка: попытка извлечь элемент из пустого стека.");
        }
        return elements[--size];
    }
}

public class MainTask3 {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();

        try {
            stack.push(100);
            
            System.out.println("Извлечено: " + stack.pop());
            System.out.println("Попытка извлечь еще раз...");
            System.out.println("Извлечено: " + stack.pop()); 
            
        } catch (CustomEmptyStackException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
            ExceptionLogger.log(e);
            System.out.println("Данные об ошибке сохранены в exceptions.log");
        }
    }
}