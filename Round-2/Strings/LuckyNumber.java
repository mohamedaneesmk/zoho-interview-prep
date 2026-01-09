public class LuckyNumber {

    public static int findLargestLuckyNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Find the maximum value in array to determine frequency array size
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create frequency array
        int[] frequency = new int[max + 1];

        // Count frequencies
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) { // Handle only non-negative numbers
                frequency[arr[i]]++;
            }
        }

        // Find largest lucky number
        int largestLucky = -1;
        for (int i = 0; i < frequency.length; i++) {
            if (i == frequency[i]) { // Value equals frequency
                largestLucky = i; // Since we iterate forward, last match is largest
            }
        }

        return largestLucky;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = { 1, 2, 2, 3 };
        System.out.println("Input: [1, 2, 2, 3]");
        System.out.println("Largest Lucky Number: " + findLargestLuckyNumber(arr1));
    }
}