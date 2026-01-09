import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        int len = 8;

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "@#$%&*!";
 
        String allChars = upper + lower + digits + special;

        Random random = new Random();
        char[] password = new char[len];

        // Ensure one character from each required set
        password[0] = upper.charAt(random.nextInt(upper.length()));
        password[1] = lower.charAt(random.nextInt(lower.length()));
        password[2] = digits.charAt(random.nextInt(digits.length()));
        password[3] = special.charAt(random.nextInt(special.length()));

        // Fill remaining with random characters from all sets
        for (int i = 4; i < len; i++) {
            password[i] = allChars.charAt(random.nextInt(allChars.length()));
        }

        // Print password
        System.out.println("Generated Password: " + new String(password));
    }
}
