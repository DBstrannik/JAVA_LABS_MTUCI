import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task3 {
    public static void main(String[] args) {
        
        int[] targetGoods = {30, 40, 50, 20, 25, 35, 45, 15, 60, 10, 40, 30};
        
        ExecutorService executor = Executors.newFixedThreadPool(3); 
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
        
        int currentWeight = 0;
        int goodsSent = 0;
        int totalGoods = targetGoods.length;

        System.out.println("--- Начинаем перенос товаров ---");

        
        while (goodsSent < totalGoods) {
            
            while (goodsSent < totalGoods) {
                final int weight = targetGoods[goodsSent];
                final int goodIndex = goodsSent + 1;
                goodsSent++;
                
                completionService.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        
                        Thread.sleep(new Random().nextInt(500) + 200);
                        System.out.println(Thread.currentThread().getName() + " перенес товар №" + goodIndex + " весом " + weight + " кг");
                        return weight;
                    }
                });
            }

            
            for (int i = 0; i < goodsSent; i++) {
                try {
                    Future<Integer> completedTask = completionService.take();
                    int weightBrought = completedTask.get();
                    currentWeight += weightBrought;
                    System.out.println("Текущий вес на погрузочной зоне: " + currentWeight + " кг / 150 кг");

                    if (currentWeight >= 150) {
                        System.out.println("\n Набрано " + currentWeight + " кг! Грузчики уехали разгружать на другой склад...\n");
                        Thread.sleep(1000); 
                        currentWeight = 0; 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        
        if (currentWeight > 0) {
            System.out.println("\n Финальный рейс! Отвозим остатки: " + currentWeight + " кг.\n");
        }

        executor.shutdown();
        System.out.println("--- Все товары успешно перенесены! ---");
    }
}