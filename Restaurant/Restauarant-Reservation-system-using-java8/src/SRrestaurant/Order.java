package SRrestaurant;


public class Order {
    private Customer customer;
    private String dishName;
    private int quantity;
    private String notification;

    public Order(Customer customer, String dishName, int quantity, String notification) {
        this.customer = customer;
        this.dishName = dishName;
        this.quantity = quantity;
        this.notification = notification;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getDishName() {
        return dishName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNotification() {
        return notification;
    }

    public void notifyKitchen() {
        System.out.println("Order for " + customer.getName() + ": " + quantity + " x " + dishName);
        System.out.println("Notification: " + notification);
    }
}
