public class LinearSearch {
    public static Product search(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null;
    }
}