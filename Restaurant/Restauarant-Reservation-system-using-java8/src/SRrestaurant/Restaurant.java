package SRrestaurant;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private List<Reservation> reservations;
    private List<Event> events;
    private List<Order> orders;
    private List<Table> tables;
    private Menu menu;

    public Restaurant() {
        reservations = new ArrayList<>();
        events = new ArrayList<>();
        orders = new ArrayList<>();
        tables = new ArrayList<>();
        menu = new Menu();
        initializeTables();
        initializeMenu();
    }

    private void initializeTables() {
        tables.add(new Table(1, 4));
        tables.add(new Table(2, 2));
        tables.add(new Table(3, 6));
        tables.add(new Table(4, 8));
    }

    private void initializeMenu() {
        menu.addItem("IDLY", 6.00);
        menu.addItem("DOSA", 15.00);
        menu.addItem("PARUPPU VADAI", 5.00);
        menu.addItem("SAMBAR VADAI", 10.00);
    }

    public void makeReservation(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter table number: ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter reservation time (YYYY-MM-DDTHH:MM): ");
        String timeStr = scanner.nextLine();
        LocalDateTime time = LocalDateTime.parse(timeStr);
        Table table = findTableByNumber(tableNumber);
        if (table != null) {
            Customer customer = new Customer(name, phone);
            Reservation reservation = new Reservation(customer, table, time);
            reservations.add(reservation);
            System.out.println("Reservation made: " + reservation);
        } else {
            System.out.println("Table number " + tableNumber + " does not exist.");
        }
    }

    public void bookEvent(Scanner scanner) {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter event time (YYYY-MM-DDHH:MM): ");
        String timeStr = scanner.nextLine();
        LocalDateTime time = LocalDateTime.parse(timeStr);
        Customer customer = new Customer(name, phone);
        Event event = new Event(eventName, customer, time);
        events.add(event);
        System.out.println("Event booked: " + event);
    }

    public void viewAllReservations() {
        System.out.println("Viewing all reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public void checkTableAvailability() {
        System.out.println("Checking table availability...");
        for (Table table : tables) {
            boolean available = true;
            for (Reservation reservation : reservations) {
                if (reservation.getTable().getNumber() == table.getNumber()) {
                    available = false;
                    break;
                }
            }
            System.out.println("Table " + table.getNumber() + " is " + (available ? "available" : "not available"));
        }
    }

    public void displayMenu() {
        menu.displayMenu();
    }

    public void makeOrder(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter dish name: ");
        String dishName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter notification (e.g., 'We will reach within 5 minutes'): ");
        String notification = scanner.nextLine();
        Customer customer = new Customer(name, phone);
        Order order = new Order(customer, dishName, quantity, notification);
        orders.add(order);
        order.notifyKitchen();
    }

    public void giveMembership(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, phone);
        System.out.println("Membership given to customer: " + customer);
    }

    private Table findTableByNumber(int tableNumber) {
        for (Table table : tables) {
            if (table.getNumber() == tableNumber) {
                return table;
            }
        }
        return null;
    }
}
