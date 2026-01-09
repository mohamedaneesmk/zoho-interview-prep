public class ClimbingStairs {
    public static void main(String[] args) {
        int num = 3;
        int result = findClimbingStairs(num);

        System.out.println(result);
    }

    private static int findClimbingStairs(int num) {
        // Brute force with no optimal space complexcity

        /*
         * int[] arr = new int[num + 1];
         * arr[0] = 1;
         * arr[1] = 1;
         * 
         * for (int index = 2; index < num + 1; index++) {
         * arr[index] = arr[index - 1] + arr[index - 2];
         * }
         * 
         * return arr[num];
         */

        // Time and Space Complexcity Optimized
        if (num <= 1)
            return 1;

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= num; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
