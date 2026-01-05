public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        System.out.println(missingNumber(nums)); // Output: 2 
    }

    private static int missingNumber(int[] nums) {
        int n = nums.length; // 3
        int xor = 0;

        for (int i = 0; i < n; i++) { // 2 < 3
            xor = xor ^ i; // xor = 2 ^ 2 = 0
            xor = xor ^ nums[i]; // xor = 0 ^ 1 = 1  
        }

        return xor ^ n; // xor = 1 ^ 3 = 2
    }
}
