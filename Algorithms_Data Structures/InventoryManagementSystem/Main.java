import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String DATA_FILE = "inventory.txt";
    private static Scanner scanner = new Scanner(System.in);
    private static InventoryManagementSystem ims = new InventoryManagementSystem();

    public static void main(String[] args) {
        ims.loadFromFile(DATA_FILE);

        while (true) {
            System.out.println("=".repeat(30));
            System.out.println("Inventory Management System");
            System.out.println("=".repeat(30));
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Save and Exit");
            System.out.println("=".repeat(30));
            System.out.print("Enter your choice: ");

            int choice = getValidChoice();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    ims.displayAllProducts();
                    break;
                case 5:
                    ims.saveToFile(DATA_FILE);
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getValidChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(id, name, quantity, price);
        ims.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        String id = scanner.nextLine();
        Product product = ims.getProduct(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new Product Name (or press Enter to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            product.setProductName(name);
        }

        System.out.print("Enter new Quantity (or -1 to keep current): ");
        int quantity = scanner.nextInt();
        if (quantity != -1) {
            product.setQuantity(quantity);
        }

        System.out.print("Enter new Price (or -1 to keep current): ");
        double price = scanner.nextDouble();
        if (price != -1) {
            product.setPrice(price);
        }

        ims.updateProduct(product);
        System.out.println("Product updated successfully.");
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        String id = scanner.nextLine();
        Product product = ims.getProduct(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        ims.deleteProduct(id);
        System.out.println("Product deleted successfully.");
    }
}