package ATM;

// Bank.java
import java.util.*;

public class Bank {
    private final Map<String, Account> accounts = new HashMap<>();

    public void add(Account a) { accounts.put(a.getAccountNo(), a); }
    public Account find(String accountNo) { return accounts.get(accountNo); }

    public Account authenticate(String accountNo, int pin) {
        Account a = accounts.get(accountNo);
        return (a != null && a.verifyPin(pin)) ? a : null;
    }
}
