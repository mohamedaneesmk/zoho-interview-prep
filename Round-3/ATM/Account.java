package ATM;

// Account.java
import java.util.*;

public class Account {
    private final String accountNo;
    private final int pin;
    private final String holderName;
    private long balance; // in cents for accuracy
    private final Deque<String> history = new ArrayDeque<>();

    public Account(String accountNo, int pin, String holderName, long openingBalanceCents) {
        this.accountNo = accountNo;
        this.pin = pin;
        this.holderName = holderName;
        this.balance = openingBalanceCents;
        addHistory("Account opened with " + format(balance));
    }

    public String getAccountNo() { return accountNo; }
    public String getHolderName() { return holderName; }
    public long getBalance() { return balance; }

    public boolean verifyPin(int entered) { return this.pin == entered; }

    public void deposit(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
        addHistory("Deposit " + format(amount) + " | New bal " + format(balance));
    }

    public boolean withdraw(long amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) return false;
        balance -= amount;
        addHistory("Withdraw " + format(amount) + " | New bal " + format(balance));
        return true;
    }

    public boolean transferTo(Account other, long amount) {
        if (other == null) throw new IllegalArgumentException("Target account required");
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        other.balance += amount;
        addHistory("Transfer to " + other.accountNo + " " + format(amount) + " | New bal " + format(balance));
        other.addHistory("Transfer from " + this.accountNo + " " + format(amount) + " | New bal " + format(other.balance));
        return true;
    }

    public List<String> lastTransactions(int n) {
        List<String> out = new ArrayList<>();
        Iterator<String> it = history.descendingIterator();
        while (it.hasNext() && out.size() < n) out.add(it.next());
        return out;
    }

    private void addHistory(String line) {
        history.addLast(line);
        if (history.size() > 50) history.removeFirst();
    }

    public static String format(long cents) {
        return "₹" + (cents / 100) + "." + String.format("%02d", Math.abs(cents % 100));
    }
}
