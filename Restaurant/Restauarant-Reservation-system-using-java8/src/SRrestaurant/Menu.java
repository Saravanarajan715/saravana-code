package SRrestaurant;



import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, Double> menuItems;

    public Menu() {
        menuItems = new HashMap<>();
    }

    public void addItem(String name, double price) {
        menuItems.put(name, price);
    }

    public Map<String, Double> getMenuItems() {
        return menuItems;
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (Map.Entry<String, Double> entry : menuItems.entrySet()) {
            System.out.println(entry.getKey() + ": RS." + entry.getValue());
        }
    }
}
