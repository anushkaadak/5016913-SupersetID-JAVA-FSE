
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        // Add sample products
        manager.addProductLinear(new Product(1, "Laptop", "Electronics"));
        manager.addProductLinear(new Product(2, "Smartphone", "Electronics"));
        manager.addProductLinear(new Product(3, "Headphones", "Electronics"));
        manager.addProductLinear(new Product(4, "Book", "Literature"));
        manager.addProductLinear(new Product(5, "Desk", "Furniture"));

        System.out.println("Products after linear insertion:");
        manager.printProducts();

        // Clear products and add using bubble sort
        manager = new ProductManager();
        manager.addProductBubbleSort(new Product(1, "Laptop", "Electronics"));
        manager.addProductBubbleSort(new Product(2, "Smartphone", "Electronics"));
        manager.addProductBubbleSort(new Product(3, "Headphones", "Electronics"));
        manager.addProductBubbleSort(new Product(4, "Book", "Literature"));
        manager.addProductBubbleSort(new Product(5, "Desk", "Furniture"));

        System.out.println("\nProducts after bubble sort insertion:");
        manager.printProducts();

        System.out.println("\nE-commerce Platform Search Function");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Choose search method (1 or 2): ");
        int searchMethod = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter product name to search: ");
        String searchTerm = scanner.nextLine();

        List<Product> productList = manager.getProducts();
        Product[] productArray = productList.toArray(new Product[0]);

        Product result;
        long startTime = System.nanoTime();

        if (searchMethod == 1) {
            result = LinearSearch.search(productArray, searchTerm);
        } else {
            result = BinarySearch.search(productArray, searchTerm);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("Search time: " + duration + " nanoseconds");

        scanner.close();
    }
}