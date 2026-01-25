// BookingSystem.java
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Taxi> taxis;
    private int bookingId = 1;

    public BookingSystem(int taxiCount) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    private int calculateCharges(char pickup, char drop) {
        int distanceUnits = Math.abs(pickup - drop); // A->B->C are unit steps
        int km = distanceUnits * 15;
        int charge = 100;
        int extraKm = Math.max(0, km - 5);
        return charge + extraKm * 10;
    }

    Taxi findTaxi(char pickup, int pickupTime) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi t : taxis) {
            if (t.isFree(pickup, pickupTime)) freeTaxis.add(t);
        }
        if (freeTaxis.isEmpty()) return null;

        int minDistance = Integer.MAX_VALUE;
        for (Taxi t : freeTaxis) {
            minDistance = Math.min(minDistance, Math.abs(pickup - t.getCurrentSpot()));
        }

        Taxi selected = null;
        for (Taxi t : freeTaxis) {
            int d = Math.abs(pickup - t.getCurrentSpot());
            if (d == minDistance) {
                if (selected == null || t.getEarnings() < selected.getEarnings()) {
                    selected = t;
                }
            }
        }
        return selected;
    }

    public void bookTaxi(Customer c) {
        Taxi selected = findTaxi(c.getPickup(), c.getPickupTime());
        if (selected == null) {
            System.out.println("No Taxi is Available");
            return;
        }

        int travelTime = Math.abs(c.getPickup() - c.getDrop());
        int dropTime = c.getPickupTime() + travelTime;
        int charges = calculateCharges(c.getPickup(), c.getDrop());

        Booking booking = new Booking(bookingId++, dropTime, charges, c);
        selected.assignBookings(booking);
        selected.setFreeTime(dropTime);
        selected.setEarnings(selected.getEarnings() + charges);
        selected.setCurrentSpot(c.getDrop());

        System.out.println("Taxi-" + selected.getTaxiId() + " is allocated");
    }

    public void displayTaxi() {
        System.out.println();
        for (Taxi t : taxis) {
            System.out.println("Taxi-" + t.getTaxiId() + " Earnings: " + t.getEarnings());
            System.out.println("Booking Id  Customer Id  From  To  Pickup Time  Drop Time  Charges");
            for (Booking b : t.getBookings()) {
                System.out.println(b.getBookingId() + "          " + b.getCustomerId()
                        + "           " + b.getPickUpPoint() + "     " + b.getDropPoint()
                        + "      " + b.getPickUpTime() + "           " + b.getDropTime()
                        + "        " + b.getAmount());
            }
            System.out.println();
        }
    }
}
