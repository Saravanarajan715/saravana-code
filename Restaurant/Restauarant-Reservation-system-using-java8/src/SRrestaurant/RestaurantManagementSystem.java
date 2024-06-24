package SRrestaurant;


import java.util.Scanner;

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println(" WELCOME TO SR RESTAURANT");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Book an Event");
            System.out.println("3. View All Reservations");
            System.out.println("4. Check Table Availability");
            System.out.println("5. View Menu");
            System.out.println("6. Make an Order");
            System.out.println("7. Give Membership");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    restaurant.makeReservation(scanner);
                    break;
                case 2:
                    restaurant.bookEvent(scanner);
                    break;
                case 3:
                    restaurant.viewAllReservations();
                    break;
                case 4:
                    restaurant.checkTableAvailability();
                    break;
                case 5:
                    restaurant.displayMenu();
                    break;
                case 6:
                    restaurant.makeOrder(scanner);
                    break;
                case 7:
                    restaurant.giveMembership(scanner);
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
