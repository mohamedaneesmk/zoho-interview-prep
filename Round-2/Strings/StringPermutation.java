public class StringPermutation {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] freq = new int[26];

        // Count frequency of characters in s1
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0, right = 0;
        int needed = s1.length();

        while (right < s2.length()) {
            char rightChar = s2.charAt(right);

            // If char needed, decrease needed count
            if (freq[rightChar - 'a'] > 0) {
                needed--;
            }
            freq[rightChar - 'a']--;
            right++;

            // If window size exceeds s1 length, move left
            if (right - left > s1.length()) {
                char leftChar = s2.charAt(left);
                if (freq[leftChar - 'a'] >= 0) {
                    needed++;
                }
                freq[leftChar - 'a']++;
                left++;
            }

            // If all characters matched
            if (needed == 0)
                return true;
        }

        return false;
    }
}
