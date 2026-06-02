import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> sharedData = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try {
            sharedData = Files.readAllLines(Paths.get(source));
            System.out.println("Данные успешно загружены. Строк: " + sharedData.size());
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }

    public void processData() {
        ExecutorService executor = Executors.newFixedThreadPool(Math.max(1, processors.size()));
        List<Callable<List<String>>> tasks = new ArrayList<>();

        for (Object processor : processors) {
            Method[] methods = processor.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    tasks.add(() -> {
                        System.out.println("Поток [" + Thread.currentThread().getName() 
                                + "] запускает метод: " + method.getName());
                        return (List<String>) method.invoke(processor, sharedData);
                    });
                }
            }
        }

        try {
            List<Future<List<String>>> results = executor.invokeAll(tasks);
            
            for (Future<List<String>> result : results) {
                sharedData = result.get(); 
            }
        } catch (Exception e) {
            System.err.println("Ошибка при многопоточной обработке: " + e.getMessage());
        } finally {
            executor.shutdown(); 
        }
    }

    public void saveData(String destination) {
        try {
            Files.write(Paths.get(destination), sharedData);
            System.out.println("Обработанные данные успешно сохранены в: " + destination);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }
}