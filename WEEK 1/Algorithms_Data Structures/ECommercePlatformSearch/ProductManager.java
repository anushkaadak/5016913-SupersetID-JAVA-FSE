import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    // Linear insertion
    public void addProductLinear(Product product) {
        products.add(product);
    }

    // Add product using bubble sort
    public void addProductBubbleSort(Product product) {
        products.add(product);
        bubbleSort();
    }

    // Bubble sort implementation
    private void bubbleSort() {
        int n = products.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (products.get(j).getProductName().compareToIgnoreCase(products.get(j + 1).getProductName()) > 0) {
                    // Swap products
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }

    // Get all products
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    // Print all products
    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}