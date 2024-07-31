class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public static Product linearSearch(Product[] products, int productId) {
    for (Product product : products) {
        if (product.productId == productId) {
            return product;
        }
    }
    return null;
}

public static Product binarySearch(Product[] products, int productId) {
    int left = 0;
    int right = products.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (products[mid].productId == productId) {
            return products[mid];
        } else if (products[mid].productId < productId) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return null;
}

public static void main(String[] args) {
    Product[] products = {
        new Product(1, "Headphones", "Electronics"),
        new Product(2, "Laptops", "Electronics"),
        new Product(3, "Smartphones", "Electronics"),
        new Product(4, "Pc", "Electronics")
    };

    System.out.println("Linear Search Result:");
    Product result = linearSearch(products, 3);
    if (result != null) {
        System.out.println(result);
    } else {
        System.out.println("Product not found");
    }

    Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

    System.out.println("Binary Search Result:");
    result = binarySearch(products, 3);
    if (result != null) {
        System.out.println(result);
    } else {
        System.out.println("Product not found");
    }
}
