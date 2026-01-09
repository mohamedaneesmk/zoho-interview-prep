public class ClosetTarget {

    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        // Loop through all words
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int diff = Math.abs(i - startIndex);        // normal distance
                int circularDiff = n - diff;                // wrap-around distance
                minDistance = Math.min(minDistance, Math.min(diff, circularDiff));
            }
        }

        // If target never found
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    public static void main(String[] args) {
        ClosetTarget s = new ClosetTarget();

        String[] words1 = {"hello", "i", "am", "leetcode", "hello"};
        System.out.println(s.closetTarget(words1, "hello", 1)); // Output: 1

        String[] words2 = {"a", "b", "leetcode"};
        System.out.println(s.closetTarget(words2, "leetcode", 0)); // Output: 1

        String[] words3 = {"i", "eat", "leetcode"};
        System.out.println(s.closetTarget(words3, "ate", 0)); // Output: -1
    }
}
