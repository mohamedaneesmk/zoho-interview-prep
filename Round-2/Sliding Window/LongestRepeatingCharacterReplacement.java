public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    private static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0; // Tracks max frequency in window
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Expand window: add right character
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // Check validity: can we replace all non-majority chars with k operations?
            if (right - left + 1 - maxCount > k) {
                // Invalid: shrink window from left
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Track maximum valid window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}