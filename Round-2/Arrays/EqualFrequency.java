public class EqualFrequency {

    public boolean equalFrequency(String word) {
        int len = word.length();
        int[] count = new int[26]; // to store frequency of each letter (a-z)

        // Step 1: Count frequency of each character
        for (int i = 0; i < len; ++i) {
            char c = word.charAt(i);
            count[c - 'a']++;
        }

        // Step 2: Try removing each character once and check
        for (int i = 0; i < len; ++i) {
            char c = word.charAt(i);
            count[c - 'a']--; // remove this character once

            if (equalCount(count)) {
                return true; // if after removal all non-zero frequencies are equal
            }

            count[c - 'a']++; // restore for next iteration
        }

        return false;
    }

    // Helper function to check if all non-zero frequencies are equal
    public boolean equalCount(int[] count) {
        int c = 0;

        for (int i : count) {
            if (i == 0) continue; // skip unused letters
            if (c == 0) c = i; // first non-zero frequency
            else if (c != i) return false; // mismatch found
        }

        return true;
    }

    // Main function for quick testing
    public static void main(String[] args) {
        EqualFrequency s = new EqualFrequency();
        System.out.println(s.equalFrequency("abcc")); // true
        System.out.println(s.equalFrequency("aazz")); // false
        System.out.println(s.equalFrequency("aabc")); // true
        System.out.println(s.equalFrequency("abc"));  // true
        System.out.println(s.equalFrequency("zzzz")); // true
    }
}
