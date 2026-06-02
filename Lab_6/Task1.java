import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        File file = new File(filePath);

        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();

                Matcher matcher = Pattern.compile("[a-zA-Zа-яА-ЯёЁ]+").matcher(line);
                while (matcher.find()) {
                    String word = matcher.group();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println("Топ-10 самых частых слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }
    }
}