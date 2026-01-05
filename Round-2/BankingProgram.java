import java.util.Scanner;

public class BankingProgram {
    static int balanceAmount = 0;  // ✅ Make it static so all methods can access

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n Banking Program!");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw cash");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int userInput;

            try {
                userInput = Integer.parseInt(sc.nextLine()); // handles invalid inputs
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (userInput) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    depositMoney(sc);
                    break;

                case 3:
                    withdrawCash(sc);
                    break;
 
                case 4:
                    System.out.println("Thank you for using our bank. Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 to 4.");
            }
        }
        sc.close();
    }

    public static void checkBalance() {
        System.out.println("Balance amount = ₹" + balanceAmount);
    }

    public static void depositMoney(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        int amount = sc.nextInt();
        sc.nextLine(); // consume newline
        if (amount > 0) {
            balanceAmount += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public static void withdrawCash(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();
        sc.nextLine(); // consume newline
        if (amount > 0 && amount <= balanceAmount) {
            balanceAmount -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
