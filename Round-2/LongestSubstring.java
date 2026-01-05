import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        // Map to store character and its most recent index
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character exists in our window, move left pointer
            // to the position after the last occurrence
            if (charIndex.containsKey(currentChar)) {
                // Use Math.max to ensure left only moves
                left = Math.max(left, charIndex.get(currentChar) + 1);
            }

            // Update the character's position
            charIndex.put(currentChar, right);

            // Calculate current window size and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
