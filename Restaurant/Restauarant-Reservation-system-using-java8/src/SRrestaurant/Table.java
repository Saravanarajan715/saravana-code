package SRrestaurant;


public class Table {
    private int number;
    private int capacity;

    public Table(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Table [Number=" + number + ", Capacity=" + capacity + "]";
    }
}
