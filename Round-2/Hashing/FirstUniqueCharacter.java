public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s = "leetcode";
        int result = firstUniqueCharacter(s);

        System.out.println(result);
    }

    private static int firstUniqueCharacter(String s) {
        int[] freq = new int[26];

        // Count freq of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
