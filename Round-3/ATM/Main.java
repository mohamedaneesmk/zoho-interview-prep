package ATM;

// Main.java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // Seed demo accounts: accountNo, pin, holder, opening balance
        bank.add(new Account("1001", 1111, "Alice", 50000));   // ₹500.00
        bank.add(new Account("1002", 2222, "Bob",   12345));   // ₹123.45
        bank.add(new Account("1003", 3333, "Carol", 100000)); // ₹1,000.00

        try (Scanner in = new Scanner(System.in)) {
            new ATM(bank, in).start();
        }
    }
}
