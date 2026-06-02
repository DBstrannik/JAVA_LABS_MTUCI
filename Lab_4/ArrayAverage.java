public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"10", "20", "ошибка", "40", "50"};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i <= arr.length; i++) {
                try {
                    int num = Integer.parseInt(arr[i]);
                    sum += num;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Обработано исключение: Элемент '" + (i < arr.length ? arr[i] : "вне границ") + "' не является числом.");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Обработано исключение: Выход за пределы массива (завершение перебора).");
        } finally {
            if (count > 0) {
                double average = (double) sum / count;
                System.out.println("Расчет окончен. Среднее арифметическое корректных чисел: " + average);
            } else {
                System.out.println("Корректные числа не найдены.");
            }
        }
    }
}