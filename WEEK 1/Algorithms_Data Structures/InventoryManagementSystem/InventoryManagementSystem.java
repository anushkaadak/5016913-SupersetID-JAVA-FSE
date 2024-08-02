import java.io.*;
import java.util.*;

public class InventoryManagementSystem {
    private Map<String, Product> productMap;

    public InventoryManagementSystem() {
        productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void deleteProduct(String productId) {
        productMap.remove(productId);
    }

    public Product getProduct(String productId) {
        return productMap.get(productId);
    }

    public void displayAllProducts() {
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Product product : productMap.values()) {
                writer.println(product.getProductId() + "," + product.getProductName() + "," + product.getQuantity() + "," + product.getPrice());
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Product product = new Product(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
                    productMap.put(product.getProductId(), product);
                }
            }
            System.out.println("Data loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}