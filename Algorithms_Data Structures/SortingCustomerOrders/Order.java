import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

public static void bubbleSort(Order[] orders) {
    int n = orders.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                Order temp = orders[j];
                orders[j] = orders[j + 1];
                orders[j + 1] = temp;
            }
        }
    }
}

public static void quickSort(Order[] orders, int low, int high) {
    if (low < high) {
        int pi = partition(orders, low, high);

        quickSort(orders, low, pi - 1);
        quickSort(orders, pi + 1, high);
    }
}

public static int partition(Order[] orders, int low, int high) {
    double pivot = orders[high].totalPrice;
    int i = (low - 1);

    for (int j = low; j < high; j++) {
        if (orders[j].totalPrice <= pivot) {
            i++;

            Order temp = orders[i];
            orders[i] = orders[j];
            orders[j] = temp;
        }
    }

    Order temp = orders[i + 1];
    orders[i + 1] = orders[high];
    orders[high] = temp;

    return i + 1;
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of orders:");
    int n = scanner.nextInt();
    scanner.nextLine(); 

    Order[] orders = new Order[n];
    for (int i = 0; i < n; i++) {
        System.out.println("Enter details for order " + (i + 1) + ":");
        System.out.print("Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Total Price: ");
        double totalPrice = scanner.nextDouble();
        scanner.nextLine(); 

        orders[i] = new Order(orderId, customerName, totalPrice);
    }

    System.out.println("Orders before sorting:");
    for (Order order : orders) {
        System.out.println(order);
    }

    bubbleSort(orders);
    System.out.println("Orders after Bubble Sort:");
    for (Order order : orders) {
        System.out.println(order);
    }

    for (int i = 0; i < n; i++) {
        System.out.println("Enter details for order " + (i + 1) + " again:");
        System.out.print("Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Total Price: ");
        double totalPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        orders[i] = new Order(orderId, customerName, totalPrice);
    }

    quickSort(orders, 0, orders.length - 1);
    System.out.println("Orders after Quick Sort:");
    for (Order order : orders) {
        System.out.println(order);
    }

    scanner.close();
}
