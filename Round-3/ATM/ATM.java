package ATM;

// ATM.java
import java.util.*;

public class ATM {
    private final Bank bank;
    private final Scanner in;

    public ATM(Bank bank, Scanner in) {
        this.bank = bank;
        this.in = in;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Welcome to ATM ===");
            System.out.print("Account No: ");
            String acc = in.nextLine().trim();
            System.out.print("PIN: ");
            int pin = readInt();

            Account user = bank.authenticate(acc, pin);
            if (user == null) {
                System.out.println("Invalid credentials. Try again.");
                continue;
            }
            System.out.println("Hello, " + user.getHolderName() + " (" + user.getAccountNo() + ")");
            session(user);
        }
    }

    private void session(Account user) {
        while (true) {
            System.out.println("\n1) Balance  2) Deposit  3) Withdraw  4) Transfer  5) Mini-Statement  6) Logout");
            System.out.print("Choose: ");
            int ch = readInt();
            try {
                switch (ch) {
                    case 1 -> System.out.println("Balance: " + Account.format(user.getBalance()));
                    case 2 -> {
                        System.out.print("Amount (₹): ");
                        long cents = readAmountToCents();
                        user.deposit(cents);
                        System.out.println("Deposited. New balance: " + Account.format(user.getBalance()));
                    }
                    case 3 -> {
                        System.out.print("Amount (₹): ");
                        long cents = readAmountToCents();
                        if (user.withdraw(cents))
                            System.out.println("Dispensed. New balance: " + Account.format(user.getBalance()));
                        else
                            System.out.println("Insufficient funds.");
                    }
                    case 4 -> {
                        System.out.print("Target Account No: ");
                        String to = in.nextLine().trim();
                        Account target = bank.find(to);
                        if (target == null) {
                            System.out.println("Target not found.");
                            break;
                        }
                        System.out.print("Amount (₹): ");
                        long cents = readAmountToCents();
                        if (user.transferTo(target, cents))
                            System.out.println("Transferred. Your balance: " + Account.format(user.getBalance()));
                        else
                            System.out.println("Transfer failed (funds/amount).");
                    }
                    case 5 -> {
                        System.out.println("--- Last 10 transactions ---");
                        for (String s : user.lastTransactions(10)) System.out.println(s);
                    }
                    case 6 -> {
                        System.out.println("Logged out.");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("Error: " + iae.getMessage());
            }
        }
    }

    private int readInt() {
        while (true) {
            String s = in.nextLine().trim();
            try { return Integer.parseInt(s); } catch (Exception e) { System.out.print("Enter a number: "); }
        }
    }

    private long readAmountToCents() {
        while (true) {
            String s = in.nextLine().trim().replace(",", "");
            try {
                if (s.contains(".")) {
                    String[] p = s.split("\\.");
                    long rupees = Long.parseLong(p[0]);
                    int paise = Integer.parseInt((p.length > 1 ? (p[1] + "00") : "00").substring(0, 2));
                    long cents = rupees * 100 + paise;
                    if (cents <= 0) throw new NumberFormatException();
                    return cents;
                } else {
                    long rupees = Long.parseLong(s);
                    long cents = rupees * 100;
                    if (cents <= 0) throw new NumberFormatException();
                    return cents;
                }
            } catch (Exception e) {
                System.out.print("Enter a positive amount (e.g., 500 or 500.50): ");
            }
        }
    }
}
