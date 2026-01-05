import java.util.*;

public class StrongPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter your date of birth (dd-mm-yyyy): ");
        String dob = scanner.nextLine().trim();  

        // Validate and split DOB
        String[] dobParts = dob.split("-");
        if (dobParts.length != 3) {
            System.out.println("Invalid DOB format. Please use dd-mm-yyyy.");
        }

        String day = dobParts[0];
        String month = dobParts[1];
        String year = dobParts[2];

        // Extract parts from name
        String lowerNamePart = name.substring(0, Math.min(2, name.length())).toLowerCase(); // e.g., "an"
        String upperNamePart = name.substring(Math.max(0, name.length() - 2)).toUpperCase(); // e.g., "ES"

        // Random character sets
        String symbols = "!@#$%^&*?";
        String numbers = "0123456789";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";

        Random rand = new Random();

        // Pick random characters
        char symbolChar = symbols.charAt(rand.nextInt(symbols.length()));
        char numberChar = numbers.charAt(rand.nextInt(numbers.length()));
        char upperChar = upper.charAt(rand.nextInt(upper.length()));
        char lowerChar = lower.charAt(rand.nextInt(lower.length()));

        // Combine and shuffle
        String rawPassword = lowerNamePart + upperNamePart + symbolChar + day + month + upperChar + numberChar + lowerChar + year;
        List<Character> passwordChars = new ArrayList<>();
        for (char ch : rawPassword.toCharArray()) {
            passwordChars.add(ch);
        }
        Collections.shuffle(passwordChars); // Shuffle to avoid patterns

        // Build final password string
        StringBuilder finalPassword = new StringBuilder();
        for (char ch : passwordChars) {
            finalPassword.append(ch);
        }

        System.out.println("\nGenerated Strong Password: " + finalPassword);

        scanner.close();
    }
}
