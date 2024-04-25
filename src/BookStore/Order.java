package BookStore;

import java.util.ArrayList;

public class Order {
    // data members
    private int orderId;
    private String customerName;
    private ArrayList<Book> books;
    private ArrayList<Integer> quantities;

    // constructor
    public Order(int orderId, String customerName){
        this.orderId = orderId;
        this.customerName = customerName;
        books = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    // methods
    public void addBook(Book book, int quantity){
        books.add(book);
        quantities.add(quantity);
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void displayOrderDetails(){
        double totalAmount = 0.0;
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Books:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            int quantity = quantities.get(i);
            double bookTotal = book.getPrice() * quantity;
            totalAmount += bookTotal;
            System.out.println("Title: " + book.getTitle() + "\tAuthor: " + book.getAuthor() + "\tPrice: $" + book.getPrice() + "\tQuantity: " + quantity);
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}
