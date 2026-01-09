import java.util.*;

public class LargestPalindrome {

    /**
     * Find the largest palindrome that can be formed by rearranging digits.
     * 
     * @param str Input string containing digits
     * @return Largest palindrome possible, or empty string if not possible
     */
    public static String largestPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        // Count frequency of each digit
        int[] freq = new int[10];
        for (char c : str.toCharArray()) {
            freq[c - '0']++;
        }

        // Count how many digits have odd frequency
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // For a palindrome:
        // - Even length: all digits must have even frequency
        // - Odd length: exactly one digit can have odd frequency (middle element)
        if (oddCount > 1) {
            return ""; // Palindrome not possible
        }

        // Build the palindrome
        StringBuilder firstHalf = new StringBuilder();
        String middle = "";

        // Process digits from 9 to 0 (largest first for maximum value)
        for (int digit = 9; digit >= 0; digit--) {
            int count = freq[digit];

            // Add half of the pairs to first half
            int pairs = count / 2;
            for (int i = 0; i < pairs; i++) {
                firstHalf.append(digit);
            }

            // If odd count, this digit goes in the middle
            if (count % 2 != 0) {
                middle = String.valueOf(digit);
            }
        }

        // Build the complete palindrome
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        String result = firstHalf.toString() + middle + secondHalf;

        // Handle edge case: if result starts with 0, it's invalid (except "0")
        if (result.length() > 1 && result.charAt(0) == '0') {
            return "";
        }

        return result;
    }

    /**
     * Alternative approach with more detailed explanation
     */
    public static String largestPalindromeVerbose(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        // Count frequency of each digit (0-9)
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Find digits with odd frequency
        char middleChar = ' ';
        int oddFreqCount = 0;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddFreqCount++;
                middleChar = entry.getKey();
            }
        }

        // Palindrome is only possible if at most one digit has odd frequency
        if (oddFreqCount > 1) {
            return "";
        }

        // Build first half by placing largest digits first
        List<Character> digits = new ArrayList<>(freqMap.keySet());
        Collections.sort(digits, Collections.reverseOrder());

        StringBuilder firstHalf = new StringBuilder();

        for (char digit : digits) {
            int count = freqMap.get(digit);
            int pairsToAdd = count / 2;

            for (int i = 0; i < pairsToAdd; i++) {
                firstHalf.append(digit);
            }
        }

        // Construct the palindrome
        StringBuilder palindrome = new StringBuilder();
        palindrome.append(firstHalf);

        if (middleChar != ' ') {
            palindrome.append(middleChar);
        }

        palindrome.append(firstHalf.reverse());

        String result = palindrome.toString();

        // Check if result is valid (not starting with 0 unless it's just "0")
        if (result.length() > 1 && result.charAt(0) == '0') {
            return "";
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {
                "313551",
                "331",
                "3444",
                "12321",
                "aabbcc",
                "112233",
                "00011",
                "9988776655"
        };

        System.out.println("=== Largest Palindrome Formation ===\n");

        for (String input : testInputs) {
            String result = largestPalindrome(input);
            System.out.println("Input:  \"" + input + "\"");
            System.out.println("Output: \"" + result + "\"");

            if (result.isEmpty()) {
                System.out.println("Explanation: Palindrome is not possible.");
            } else {
                System.out.println("Explanation: " + result + " is the largest palindrome.");
            }
            System.out.println();
        }

        // Verify palindromes
        System.out.println("=== Verification ===");
        for (String input : testInputs) {
            String result = largestPalindrome(input);
            if (!result.isEmpty()) {
                boolean isPalindrome = result.equals(new StringBuilder(result).reverse().toString());
                System.out.println(input + " -> " + result + " (Valid: " + isPalindrome + ")");
            }
        }
    }
}
