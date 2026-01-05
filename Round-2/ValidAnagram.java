public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(checkAnagram(s, t));
    }

    private static boolean checkAnagram(String s, String t) {
        // Different length's can't be anagram
        if (s.length() != t.length()) {
            return false;
        }

        // Use frequency array for lowercase English Letters
        int[] freq = new int[26];

        // Single pass : count s chars, discount t chars
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // All frequency should be 0 for Valid Anagram
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
