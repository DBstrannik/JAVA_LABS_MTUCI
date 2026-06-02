public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();

        TextFilterProcessor textProcessor = new TextFilterProcessor();
        manager.registerDataProcessor(textProcessor);

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        System.out.println("--- Старт лабораторной работы №8 ---");
        
        manager.loadData(inputFile);

        System.out.println("\n--- Запуск обработки ---");
        manager.processData();

        System.out.println("\n--- Сохранение результатов ---");
        manager.saveData(outputFile);
        
        System.out.println("\n--- Работа завершена! Проверьте файл " + outputFile + " ---");
    }
}