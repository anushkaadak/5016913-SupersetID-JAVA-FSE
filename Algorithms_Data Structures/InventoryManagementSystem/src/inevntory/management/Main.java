package inevntory.management;

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product product1 = new Product("P001", "Product 1", 10, 99.99);
        Product product2 = new Product("P002", "Product 2", 5, 149.99);
        Product product3 = new Product("P003", "Product 3", 20, 199.99);

        ims.addProduct(product1);
        ims.addProduct(product2);
        ims.addProduct(product3);

        ims.displayInventory();

        System.out.println("Updating Product 2...");
        product2.setPrice(129.99);
        ims.updateProduct(product2);
        ims.displayInventory();

        System.out.println("Deleting Product 1...");
        ims.deleteProduct("P001");
        ims.displayInventory();
    }
}

