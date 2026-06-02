public class Task2<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Task2(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new RuntimeException("Стек переполнен");
        }
        data[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Стек пуст");
        }

        T element = data[--size];
        data[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Стек пуст");
        }
        return data[size - 1];
    }

    public static void main(String[] args) {
        Task2<Integer> stack = new Task2<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());   // 3
        System.out.println(stack.peek());  // 2

        stack.push(4);

        System.out.println(stack.pop());   // 4
    }
}