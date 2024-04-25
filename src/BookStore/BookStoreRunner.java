package BookStore;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStoreRunner {
    public static void main(String[] args) {
        BookStore myBookStore = new BookStore();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("BookStore Application");
            System.out.println("1. Add a Book");
            System.out.println("2. Place Order");
            System.out.println("3. View All Orders");
            System.out.println("4. View Order Details");
            System.out.println("5. Process Next Order");
            System.out.println("6. Display All Books");
            System.out.println("7. Find Orders by Customer Name");
            System.out.println("8. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter the book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter the author's name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter the price: $");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter the quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    myBookStore.addBook(title, author, price, quantity);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    myBookStore.displayAvailableBooks();
                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();
                    ArrayList<Integer> bookIds = new ArrayList<>();
                    ArrayList<Integer> quantities = new ArrayList<>();
                    System.out.println("Enter book IDs and quantities (separated by space, format: id1 quantity1 id2 quantity2 ...): ");
                    String[] input = sc.nextLine().split(" ");
                    for (int i = 0; i < input.length; i += 2) {
                        bookIds.add(Integer.parseInt(input[i]));
                        quantities.add(Integer.parseInt(input[i + 1]));
                    }
                    myBookStore.placeOrder(customerName, bookIds, quantities);
                    System.out.println("Order placed successfully!");
                    break;
                case 3:
                    myBookStore.viewAllOrders();
                    break;
                case 4:
                    myBookStore.viewAllOrders();
                    System.out.print("Enter the order ID: ");
                    int orderId = Integer.parseInt(sc.nextLine());
                    myBookStore.viewOrderDetails(orderId);
                    break;
                case 5:
                    myBookStore.processNextOrder();
                    break;
                case 6:
                    myBookStore.displayBooks();
                    break;
                case 7:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    myBookStore.findOrdersByCustomerName(name);
                    break;
                case 8:
                    System.out.println("Exiting the program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
