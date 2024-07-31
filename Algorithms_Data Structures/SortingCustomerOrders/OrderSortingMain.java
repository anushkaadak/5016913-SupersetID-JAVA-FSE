import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderSortingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        System.out.println("=".repeat(50));
        while (true) {
            System.out.println("Enter order details (or 'done' to finish):");
            System.out.print("Order ID: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;

            int orderId = Integer.parseInt(input);
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Total Price: ");
            double totalPrice = Double.parseDouble(scanner.nextLine());
            System.out.println("=".repeat(50));
            orders.add(new Order(orderId, customerName, totalPrice));
        }
        System.out.println("-".repeat(80));
        System.out.println("Original orders:");
        printOrders(orders);

        System.out.println("-".repeat(80));
        System.out.println("\nSorting using Bubble Sort:");
        List<Order> bubbleSortedOrders = new ArrayList<>(orders);
        SortingAlgorithms.bubbleSort(bubbleSortedOrders);
        printOrders(bubbleSortedOrders);

        System.out.println("-".repeat(80));
        System.out.println("\nSorting using Quick Sort:");
        List<Order> quickSortedOrders = new ArrayList<>(orders);
        SortingAlgorithms.quickSort(quickSortedOrders, 0, quickSortedOrders.size() - 1);
        printOrders(quickSortedOrders);
        System.out.println("-".repeat(80));

        scanner.close();
    }

    private static void printOrders(List<Order> orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}