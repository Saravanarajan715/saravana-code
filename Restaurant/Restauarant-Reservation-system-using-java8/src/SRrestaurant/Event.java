package SRrestaurant;


import java.time.LocalDateTime;

public class Event {
    private static int idCounter = 0;
    private int id;
    private String eventName;
    private Customer customer;
    private LocalDateTime time;

    public Event(String eventName, Customer customer, LocalDateTime time) {
        this.id = ++idCounter;
        this.eventName = eventName;
        this.customer = customer;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Event [ID=" + id + ", Event=" + eventName + ", Customer=" + customer + ", Time=" + time + "]";
    }
}
