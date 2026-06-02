import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab5 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Лабораторная работа №5 ===");
            System.out.println("1 - Задание 1: Поиск всех чисел в тексте");
            System.out.println("2 - Задание 2: Проверка корректности ввода пароля");
            System.out.println("3 - Задание 3: Поиск заглавной буквы после строчной");
            System.out.println("4 - Задание 4: Проверка корректности ввода IP-адреса");
            System.out.println("5 - Задание 5: Поиск слов по первой букве");
            System.out.println("0 - Выход");
            System.out.print("Выберите задание: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите число.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Ошибка: неверный пункт меню.");
            }
        }
    }

    
    private static void task1() {
        System.out.println("\n--- Задание 1: Поиск чисел ---");
        System.out.print("Введите текст для поиска чисел: ");
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные числа:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) System.out.println("Числа не найдены.");
    }

    
    private static void task2() {
        System.out.println("\n--- Задание 2: Валидация пароля ---");
        System.out.print("Введите пароль для проверки: ");
        String password = scanner.nextLine();
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        
        if (password.matches(regex)) {
            System.out.println("Пароль корректен и соответствует всем требованиям.");
        } else {
            System.out.println("Ошибка: Пароль должен быть длиной от 8 до 16 символов, состоять из латинских букв и цифр, содержать минимум одну заглавную букву и одну цифру.");
        }
    }

    private static void task3() {
        System.out.println("\n--- Задание 3: Выделение заглавных после строчных ---");
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        String regex = "(?<=\\p{Ll})(?=\\p{Lu})";
        String result = text.replaceAll(regex, "!!");

        System.out.println("Результат обработки:");
        System.out.println(result);
    }

    // Задание 4: Проверка корректности ввода IP-адреса (IPv4)
    private static void task4() {
        System.out.println("\n--- Задание 4: Валидация IP-адреса ---");
        System.out.print("Введите IP-адрес: ");
        String ip = scanner.nextLine();
        String octet = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
        String regex = "^" + octet + "\\." + octet + "\\." + octet + "\\." + octet + "$";

        if (ip.matches(regex)) {
            System.out.println("IP-адрес корректен.");
        } else {
            System.out.println("Ошибка: Неверный формат IP-адреса. Должно быть 4 числа от 0 до 255, разделенных точками.");
        }
    }

   
    private static void task5() {
        System.out.println("\n--- Задание 5: Поиск слов по первой букве ---");
        System.out.println("1 - Использовать готовый текст");
        System.out.println("2 - Ввести свой текст");
        System.out.print("Выберите режим: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите число.");
            scanner.next();
            return;
        }
        int choice = scanner.nextInt();
        scanner.nextLine();

        String text;
        if (choice == 1) {
            text = "Город готовится к празднику. Гости гуляют по главным улицам.";
        } else if (choice == 2) {
            System.out.print("Введите текст: ");
            text = scanner.nextLine();
        } else {
            System.out.println("Ошибка: неверный пункт меню.");
            return;
        }

        System.out.print("Введите букву: ");
        String input = scanner.nextLine();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Ошибка: нужно ввести одну букву.");
            return;
        }

        char letter = input.charAt(0);

        String regex = "\\b[" + Character.toUpperCase(letter) + Character.toLowerCase(letter) + "][\\p{L}]*\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные слова:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Совпадения не найдены.");
        }
    }
}