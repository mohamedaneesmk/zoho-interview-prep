public class MinimumSizeSubArray {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        int result = findMinimumSizeSubArray(nums, target);
        System.out.println(result);
    }

    private static int findMinimumSizeSubArray(int[] nums, int target) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        // Expand window with right pointer
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Shrink window from left while sum >= target
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        // Return 0 if no valid subarray found
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}