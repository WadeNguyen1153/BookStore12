package BookStore;

import java.util.ArrayList;
import java.util.Collections;

public class BookStore {
    // data members
    private ArrayList<Book> books;
    private ArrayList<Order> orders;
    private int bookId;
    private int orderId;

    // constructor
    public BookStore(){
        books = new ArrayList<>();
        orders = new ArrayList<>();
        bookId = 1;
        orderId = 1;
    }

    // methods
    public void addBook(String title, String author, double price, int quantity){
        Book book = new Book(bookId, title, author, price, quantity);
        books.add(book);
        bookId++;
    }

    public void displayBooks(){
        System.out.println("Book Catalog (Arranged from A - Z):");
        Collections.sort(books, (book1, book2) -> book1.getTitle().compareToIgnoreCase(book2.getTitle()));
        for(Book book : books){
            System.out.println(book);
        }
    }

    public void displayAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the store.");
        } else {
            System.out.println("Available Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void placeOrder(String customerName, ArrayList<Integer> bookIds, ArrayList<Integer> quantities){
        Order order = new Order(orderId, customerName);
        for(int i = 0; i < bookIds.size(); i++){
            int id = bookIds.get(i);
            int quantity = quantities.get(i);
            for(Book book : books){
                if(book.getId() == id){
                    if(book.getQuantity() >= quantity) {
                        order.addBook(book, quantity);
                        book.setQuantity(book.getQuantity() - quantity);
                    } else {
                        System.out.println("Insufficient quantity for book: " + book.getTitle());
                    }
                    break;
                }
            }
        }
        orders.add(order);
        orderId++;
    }

    public void viewAllOrders(){
        if(orders.isEmpty()){
            System.out.println("No orders available.");
        } else {
            System.out.println("All Orders:");
            for(Order order : orders){
                System.out.println("Order ID: " + order.getOrderId() + "\tCustomer Name: " + order.getCustomerName());
            }
        }
    }

    public void viewOrderDetails(int orderId){
        for(Order order : orders){
            if(order.getOrderId() == orderId){
                order.displayOrderDetails();
                return;
            }
        }
        System.out.println("Order with ID " + orderId + " not found.");
    }

    public void findOrdersByCustomerName(String customerName){
        System.out.println("Orders by Customer Name '" + customerName + "':");
        boolean found = false;
        for(Order order : orders){
            if(order.getCustomerName().equalsIgnoreCase(customerName)){
                System.out.println("Order ID: " + order.getOrderId());
                found = true;
            }
        }
        if(!found){
            System.out.println("No orders found for customer '" + customerName + "'.");
        }
    }

    public void processNextOrder(){
        if(orders.isEmpty()){
            System.out.println("No orders to process.");
            return;
        }
        Order nextOrder = orders.remove(0);
        System.out.println("Processing next order:");
        nextOrder.displayOrderDetails();

    }
    public void displayUpdateTable(){
        System.out.println("-------------------------------------------------");
        System.out.println("                 Update Table                   ");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-15s %-25s %-15s\n", "Book ID", "Title", "Author");
        System.out.println("-------------------------------------------------");

        for(Book book : books){
            System.out.printf("%-15d %-25s %-15s\n", book.getId(), book.getTitle(), book.getAuthor());
        }

        System.out.println("-------------------------------------------------");
        System.out.println();
    }
}
