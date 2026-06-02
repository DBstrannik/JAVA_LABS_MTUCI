import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Map<String, Integer> sales = new HashMap<>();
    private Map<String, Product> products = new HashMap<>();

    public void addSale(Product product, int quantity) {
        String name = product.getName();

        products.put(name, product);
        sales.put(name, sales.getOrDefault(name, 0) + quantity);
    }

    public void printSales() {
        System.out.println("Список проданных товаров:");

        for (String name : sales.keySet()) {
            int quantity = sales.get(name);
            double price = products.get(name).getPrice();

            System.out.println(name +
                    " | Количество: " + quantity +
                    " | Цена: " + price);
        }
    }

    public double getTotalSalesAmount() {
        double total = 0;

        for (String name : sales.keySet()) {
            int quantity = sales.get(name);
            double price = products.get(name).getPrice();

            total += quantity * price;
        }

        return total;
    }

    public String getMostPopularProduct() {
        String popular = null;
        int max = 0;

        for (String name : sales.keySet()) {
            int quantity = sales.get(name);

            if (quantity > max) {
                max = quantity;
                popular = name;
            }
        }

        return popular;
    }

    public static void main(String[] args) {
        Task3 tracker = new Task3();

        Product milk = new Product("Молоко", 90.0);
        Product bread = new Product("Хлеб", 50.0);
        Product cheese = new Product("Сыр", 200.0);

        tracker.addSale(milk, 5);
        tracker.addSale(bread, 8);
        tracker.addSale(cheese, 2);
        tracker.addSale(milk, 3);

        tracker.printSales();

        System.out.println("\nОбщая сумма продаж: " +
                tracker.getTotalSalesAmount());

        System.out.println("Самый популярный товар: " +
                tracker.getMostPopularProduct());
    }
}