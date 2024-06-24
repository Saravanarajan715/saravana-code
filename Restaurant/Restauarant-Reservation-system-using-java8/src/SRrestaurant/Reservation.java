package SRrestaurant;


import java.time.LocalDateTime;

public class Reservation {
    private static int idCounter = 0;
    private int id;
    private Customer customer;
    private Table table;
    private LocalDateTime time;

    public Reservation(Customer customer, Table table, LocalDateTime time) {
        this.id = ++idCounter;
        this.customer = customer;
        this.table = table;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Table getTable() {
        return table;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Reservation [ID=" + id + ", Customer=" + customer + ", Table=" + table + ", Time=" + time + "]";
    }
}
