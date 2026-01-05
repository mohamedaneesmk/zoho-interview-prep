import java.util.Scanner;

public class CheckPalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = sc.nextLine(); 
        if (findPalindromeString(inputString))
            System.out.println("The input string \"" + inputString + "\" is a Palindrome.");
        else
            System.out.println("The input string \"" + inputString + "\" is not a Palindrome.");
        sc.close();
    }
 
    private static boolean findPalindromeString(String inputString) {
        if (inputString.length() <= 1)
            return true;

        int left = 0;
        int right = inputString.length() - 1;

        while (left < right) {
            char leftChar = inputString.charAt(left);
            char rightChar = inputString.charAt(right);

            if (!Character.isLetter(leftChar)) {
                left++;
            } else if (!Character.isLetter(rightChar)) {
                right--;
            } else if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
