public class MinimumKeypresses {
    public static int minimumPushes(String word) {
        int n = word.length();
        int totalPushes = 0;

        for (int i = 0; i < n; i++) {
            totalPushes += (i / 8) + 1;
        }
        return totalPushes;
    }

    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));       // Output: 5
        System.out.println(minimumPushes("xycdefghij"));  // Output: 12
        System.out.println(minimumPushes("abcdefghijklmnopqrstuvwxyz")); // Output: 50
    }
}
