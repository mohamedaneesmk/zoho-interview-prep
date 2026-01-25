// Customer.java
public class Customer {
    private int customerId;
    private char pickup;
    private char drop;
    private int pickupTime;

    public Customer(int customerId, char pickup, char drop, int pickupTime) {
        this.customerId = customerId;
        this.pickup = pickup;
        this.drop = drop;
        this.pickupTime = pickupTime;
    }

    public int getCustomerId() { return customerId; }
    public char getPickup() { return pickup; }
    public char getDrop() { return drop; }
    public int getPickupTime() { return pickupTime; }
}
